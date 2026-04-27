package encapsulation_inheritance.lab;

import java.util.Scanner;

public class AntiqueShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemList itemList = new ItemList();
        int choice = 0;

        do {
            try {
                System.out.println("\n--- ANTIQUE SHOP MENU ---");
                System.out.println("1. Add a new Vase");
                System.out.println("2. Add a new Statue");
                System.out.println("3. Add a new Painting");
                System.out.println("4. Display all items");
                System.out.println("5. Find the items by the creator");
                System.out.println("6. Display the list of items");
                System.out.println("7. Quit");
                System.out.print("Input your choice: ");

                // Dùng Integer.parseInt để tránh lỗi trôi lệnh triệt để
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String idVase = sc.nextLine();
                        Vase vase = new Vase();
                        vase.setId(idVase); // Bắt buộc phải set ID trước khi check trùng

                        if (itemList.addItem(vase)) {
                            vase.input(sc);
                            System.out.println("Added Vase successfully.");
                        } else {
                            System.out.println("Add failed: Duplicate ID or List full!");
                        }
                        break;

                    case 2:
                        System.out.print("Enter ID: ");
                        String idStatue = sc.nextLine();
                        Statue statue = new Statue();
                        statue.setId(idStatue);

                        if (itemList.addItem(statue)) {
                            statue.input(sc);
                            System.out.println("Added Statue successfully.");
                        } else {
                            System.out.println("Add failed: Duplicate ID or List full!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        String idPainting = sc.nextLine();
                        Painting painting = new Painting();
                        painting.setId(idPainting);

                        if (itemList.addItem(painting)) {
                            painting.input(sc);
                            System.out.println("Added Painting successfully.");
                        } else {
                            System.out.println("Add failed: Duplicate ID or List full!");
                        }
                        break;

                    case 4:
                        itemList.displayAll();
                        break;

                    case 5:
                        System.out.print("Enter creator name: ");
                        String creator = sc.nextLine();
                        Item item1 = itemList.findItem(creator);
                        if (item1 != null) System.out.println(item1);
                        else System.out.println("No item found with creator: " + creator);
                        break;

                    case 6:
                        System.out.print("Enter type name: ");
                        String type = sc.nextLine();
                        itemList.displayItemsByType(type);
                        break;
                    case 7:
                        System.out.println("Enter max value");
                        int max = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter min value");
                        int min = Integer.parseInt(sc.nextLine());
                        itemList.search(max,min);

                    case 8:
                        System.out.println("Quit program...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please choose 1-7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please input a number for choice!");
                choice = 0; // Reset choice để loop tiếp tục
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 7);

        sc.close();
    }
}