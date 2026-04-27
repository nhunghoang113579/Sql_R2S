package encapsulation_inheritance.lab;

import java.util.Scanner;

public class ItemList {
    private Item[] list;
    private int numOfItem;
    private final int MAX = 100;

    public ItemList() {
        list = new Item[MAX];
        numOfItem = 0;
    }

    public boolean isDuplicateId(String id, Item newItem) {
        if (id == null || newItem == null) return false;
        id = id.trim().toLowerCase();

        for (int i = 0; i < numOfItem; i++) {
            if (list[i] != null && list[i].getId() != null) {
                if (list[i].getId().trim().equalsIgnoreCase(id.trim()) && list[i].getClass().equals(newItem.getClass())) {
                    return true;

                }
            }
        }
        return false;
    }

    public boolean addItem(Item item) {
        // Truyền cả item vào để check trùng theo loại
        if (item == null || item.getId() == null || numOfItem >= MAX || isDuplicateId(item.getId(), item)) {
            return false;
        }

        list[numOfItem++] = item;
        return true;
    }

    public void displayAll() {
        if (numOfItem == 0) {
            System.out.println("List is empty!");
            return;
        }

        for (Item item : list) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }


    public Item findItem(String creator) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getCreator().equalsIgnoreCase(creator)) {
                return list[i];
            }

        }
        return null;
    }

    public boolean updateItem(Scanner sc, String id) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getId().equalsIgnoreCase(id)) {
                list[i].input(sc);
                return true;

            }
        }
        return false;

    }


    public void displayItemsByType(String type) {
        for (int i = 0; i < numOfItem; i++) {
            if (type.equalsIgnoreCase("vase") && list[i] instanceof Vase ||
                    type.equalsIgnoreCase("statue") && list[i] instanceof Statue ||
                    type.equalsIgnoreCase("painting") && list[i] instanceof Painting) {

                System.out.println(list[i]);

            } else {
                System.out.println("Not found");
            }

        }

    }


    public void search(int max, int min) {
        if (numOfItem == 0) {
            System.out.println("Trong kho chua co hang nao ca");
        }
        for (int i = 0; i < numOfItem; i++) {
            if (list[i] != null) {
                if (list[i].getValue() <= max && list[i].getValue() >= min) {
                    System.out.println(list[i]);
                }


            }

        }

    }
}



