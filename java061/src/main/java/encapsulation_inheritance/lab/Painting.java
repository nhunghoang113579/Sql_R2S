package encapsulation_inheritance.lab;

import encapsulation_inheritance.lab.Item;

import java.util.Scanner;

public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;

    public Painting() {}

    public Painting(String id, int value, String creator,
                    int height, int width,
                    boolean isWaterColor, boolean isFramed) {
        super(id, value, creator);
        setHeight(height);
        setWidth(width);
        this.isWaterColor = isWaterColor;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0)
            throw new IllegalArgumentException("Height must be > 0");
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width <= 0)
            throw new IllegalArgumentException("Width must be > 0");
        this.width = width;
    }

    public boolean isWaterColor() {
        return isWaterColor;
    }

    public void setWaterColor(boolean waterColor) {
        isWaterColor = waterColor;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setFramed(boolean framed) {
        isFramed = framed;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);

        // height
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

        // width
        while (true) {
            try {
                System.out.print("Enter width: ");
                setWidth(sc.nextInt());
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid width!");
                sc.nextLine();
            }
        }

        // watercolor
        while (true) {
            try {
                System.out.print("Is watercolor (true/false): ");
                setWaterColor(sc.nextBoolean());
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Enter true or false!");
                sc.nextLine();
            }
        }

        // framed
        while (true) {
            try {
                System.out.print("Is framed (true/false): ");
                setFramed(sc.nextBoolean());
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Enter true or false!");
                sc.nextLine();
            }
        }
    }

    @Override
    public String toString() {
        return "Painting -> " + super.toString() +
                ", height=" + height +
                ", width=" + width +
                ", isWaterColor=" + isWaterColor +
                ", isFramed=" + isFramed;
    }
}