package encapsulation_inheritance.lab;

import java.util.Scanner;

public class Item {
    protected String id;
    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(String id, int value, String creator) {
        setId(id);
        setValue(value);
        setCreator(creator);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID must not be empty");
        }
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be > 0");
        }
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        if (creator == null || creator.trim().isEmpty()) {
            throw new IllegalArgumentException("Creator must not be empty");
        }
        this.creator = creator;
    }

    public void input(Scanner sc) {
        while (true) {
            try {
                System.out.print("Enter value: ");
                int v = sc.nextInt();
                sc.nextLine();
                setValue(v);
                break;
            } catch (Exception e) {
                System.out.println("Invalid number!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Enter creator: ");
                setCreator(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }








    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", value=" + value +
                ", creator='" + creator + '\'' +
                '}';
    }
}
