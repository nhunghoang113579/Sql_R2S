package constroucts.lab2;

import java.util.Scanner;

public class TrainingManagement {
    private TraineeForm traineeForm;
    private Scanner scanner;
    private Trainee[] listOfTrainees = new Trainee[100];
    private Byte count = 0;

    public TrainingManagement() {
        this.scanner = new Scanner(System.in);
        this.traineeForm = new TraineeForm(scanner);
    }

    public static void main(String[] args) {
        TrainingManagement trainingManagement = new TrainingManagement();
        trainingManagement.displayMenu();


    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n===== MANAGEMENT MENU =====");
            System.out.println("1. Add Trainee");
            System.out.println("2. Display All Trainees");
            System.out.println("3. Find Trainee by ID");
            System.out.println("4. Find Trainee by Name");
            System.out.println("5. Update Trainee");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    addTrainee();
                    break;
                case 2:
                    displayTrainee();
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();

                    Trainee traineeID = findTraineeById(id);

                    if (traineeID != null) {
                        System.out.println(traineeID);
                    } else {
                        System.out.println("Trainee not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                   Trainee traineeName = findTraineeByName(name);
                    if (traineeName != null) {
                        System.out.println(traineeName);
                    } else {
                        System.out.println("Trainee not found!");
                    }
                    break;
                case 5:
                    System.out.print("Enter ID: ");
                    String updateId = scanner.nextLine();
                    Trainee existing = findTraineeById(updateId);
                    if (existing != null) {
                        Trainee newTrainee = traineeForm.getTrainee();
                        updateTrainee(updateId,newTrainee);
                    } else {
                        System.out.println("Trainee not found!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private void addTrainee() {
        if (count >= listOfTrainees.length) {
            System.out.println("List is full!");
            return;
        }
        String id;
        while (true) {
            id = traineeForm.getId();
            if (findTraineeById(id) != null) {
                System.out.println("Id already exists. Enter another.");
            } else {

                break;
            }
        }
        Trainee trainee = traineeForm.getTrainee();
        trainee.setId(id);
        listOfTrainees[count++] = trainee;
        System.out.println("Trainee added successfully!");
    }

    private void displayTrainee(){
        for (int i = 0; i < count; i++) {
            System.out.println(listOfTrainees[i]);

        }

    }


    private Trainee findTraineeById(String id) {
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getId().equals(id)) {
                return listOfTrainees[i];
            }
        }
        return null;


    }

    private Trainee findTraineeByName(String name) {
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getName().equals(name)) {
                return listOfTrainees[i];
            }
        }
        return null;


    }

    private void updateTrainee(String id, Trainee newTrainee) {
        Trainee traineeById = findTraineeById(id);
        if (traineeById == null) {
            System.out.println("Trainee not found!");
            return;
        }
        traineeById.setId(id);
        traineeById.setName(newTrainee.getName());
        traineeById.setGender(newTrainee.getGender());
        traineeById.setAge(newTrainee.getAge());
        System.out.println("Update successful!");
    }

}


