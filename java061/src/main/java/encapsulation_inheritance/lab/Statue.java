package encapsulation_inheritance.lab;

import java.util.Scanner;

public class Statue extends Item {
    private int weight;
    private String color;

    public Statue() {}

    public Statue(String id, int value, String creator, int weight, String color) {
        super(id, value, creator);
        setWeight(weight);
        setColor(color);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight <= 0)
            throw new IllegalArgumentException("Weight must be > 0");
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty())
            throw new IllegalArgumentException("Color must not be empty");
        this.color = color;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);

        while (true) {
            try {
                System.out.print("Enter weight: ");
                setWeight(sc.nextInt());
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid weight!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Enter color: ");
                setColor(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "Statue -> " + super.toString() +
                ", weight=" + weight +
                ", color=" + color;
    }
}