package classObject.lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();
        Menu menu = new Menu();
        while (true) {
            menu.displayMenu();
            int choice = menu.getChoice(scanner);

            switch (choice) {
                case 1:
                    service.createStudent();
                    break;

                case 2:
                    service.displayAll();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Student s = service.findById(scanner.nextLine());
                    if (s != null) s.display();
                    else System.out.println("Not found");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    service.updateStudent(scanner.nextLine());
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}