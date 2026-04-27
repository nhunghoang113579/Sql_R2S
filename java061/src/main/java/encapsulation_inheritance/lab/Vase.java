package encapsulation_inheritance.lab;

import encapsulation_inheritance.lab.Item;

import java.util.Scanner;

public class Vase extends Item {
    private int height;
    private String material;

    public Vase() {}

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);
        setHeight(height);
        setMaterial(material);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0)
            throw new IllegalArgumentException("Height must be > 0");
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty())
            throw new IllegalArgumentException("Material must not be empty");
        this.material = material;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);

        while (true) {
            try {
                System.out.print("Enter height: ");
                setHeight(sc.nextInt());
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid height!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Enter material: ");
                setMaterial(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "Vase -> " + super.toString() +
                ", height=" + height +
                ", material=" + material;
    }
}