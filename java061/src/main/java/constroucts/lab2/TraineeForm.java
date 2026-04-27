package constroucts.lab2;

import java.util.Locale;
import java.util.Scanner;

    public class TraineeForm {
        private Scanner scanner;
        private Trainee trainee;


        public TraineeForm(Scanner scanner) {
            this.scanner = scanner;
        }

        public String getId() {
                return readNonEmpty("Enter ID:");

        }

        public Trainee getTrainee() {
            String name = readNonEmpty("Enter name: ");
            String gender = readGender("Enter gender (male/female): ");
            byte age = readAge("Enter age (>=6): ");
            return new Trainee("TEMP", name, gender, age);
        }

//        ===========================Check Empty=====================

        private String validateNonEmpty(String value) {
            if (value == null || value.trim().isEmpty()) {
                throw new IllegalArgumentException("Value cannot be empty");
            }
            return value.trim();
        }
        private String readNonEmpty(String prompt) {
            while (true){
                try{
                    System.out.print(prompt);
                    String input = scanner.nextLine();
                    return validateNonEmpty(input);

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }//        ===========================Check Gender=====================

        private String readGender(String prompt) {
            while (true) {
                try {
                    System.out.print(prompt);
                    String gender = validateNonEmpty(scanner.nextLine());

                    if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                        return gender.toLowerCase();
                    }

                    throw new IllegalArgumentException("Gender must be male or female");

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        private Byte readAge(String prompt){
            while (true){
                try {
                    System.out.print(prompt);
                    Byte age = Byte.parseByte(scanner.nextLine());
                    if (age < 6){
                        throw new IllegalArgumentException("Age must be >= 6");
                    }
                    return age;


                }catch (NumberFormatException e){
                    System.out.println("Age must be a number");

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

        }

    }








