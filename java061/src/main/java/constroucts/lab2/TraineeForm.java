package constroucts.lab2;

import java.util.Scanner;

    public class TraineeForm {
        private final Scanner scanner;
        Scanner sc = new Scanner(System.in);


        public TraineeForm(Scanner scanner) {
            this.scanner = scanner;
        }

        public void TraineeForm(Scanner scanner) {

        }

        String getId() {
            while (true) {
                System.out.print("Enter trainee id: ");
                String id = scanner.nextLine().trim();
                if (!id.isEmpty()) return id;
                System.out.println("Id cannot be empty. Try again.");
            }
        }

        private String readNonEmpty(String prompt) {
                while (true) {
                      System.out.print(prompt);
                      String value = scanner.nextLine().trim();

                    if (! value.isEmpty()) return value;
                    System.out.println("Value cannot be empty.");
                  }
           }

        public String readGender(){
            while (true) {
                    System.out.print("Enter gender: ");
                   String  gender = sc.nextLine().trim().toLowerCase();
                if (gender.equals("male") || gender.equals("female")) return gender;
                     System.out.println("Gender must be 'male' or 'female'.");
                    return gender;
            }
        }

        public Byte readtAge() {
            while (true) {
                try {
                    System.out.print("Enter age: ");
                    Byte age = Byte.parseByte(scanner.nextLine());
                    if (age < 6) {
                        throw new IllegalArgumentException("Age must be >= 6");
                    }
                    return age;

                } catch (NumberFormatException e) {
                    System.out.println("Age must be a number!");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }



            public Trainee getTrainee() {
                String id = readNonEmpty("Enter id");
                String name = readNonEmpty("Enter name");
                String gender = readGender();
                byte age = readtAge();

                return new Trainee(id, name, gender, age);
            }
    }





