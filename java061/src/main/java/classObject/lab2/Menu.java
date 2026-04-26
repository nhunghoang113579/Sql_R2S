package classObject.lab2;

import java.util.Scanner;

public class Menu {
    void displayMenu(){
        System.out.println("1.Create a student");
        System.out.println("2.Display all");
        System.out.println("3.Find a student by id");
        System.out.println("4.Update a student by id");
        System.out.println("5.Quit");
    }

    int getChoice(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Choice phải từ 1-5");
                }

            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }

}
