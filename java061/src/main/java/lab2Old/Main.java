package lab2Old;



import java.util.Scanner;
    public class Main {
        Student[] listStudents = new Student[100];
        int count = 0;
        Scanner sc = new Scanner(System.in);

        boolean isDuplicateId(String id) {
            for (int i = 0; i < count; i++) {
                if (listStudents[i].id.equals(id)) {
                    return true;
                }
            }
            return false;
        }


       void createStudent(){
           if(count >= 100){
               System.out.println("List is full!");
               return;
           }
           Student student = new Student();


           do {
               System.out.print("Enter ID: ");
               student.id = sc.nextLine();

           } while (isDuplicateId(student.id));

                   do {
                       System.out.print("Enter name: ");
                       student.name = sc.nextLine();
                   }while (student.name.isEmpty());


               do {
                   System.out.print("Enter age: ");
                   student.age = Integer.parseInt(sc.nextLine());

               }while (student.age < 18);

               System.out.print("Enter address: ");
               student.address = sc.nextLine();
               do {
                   System.out.print("Enter gender (male/female): ");
                   student.gender = sc.nextLine();

               }while (!student.gender.equalsIgnoreCase("male") && !student.gender.equalsIgnoreCase("female") );

               System.out.print("Enter email: ");
               student.email = sc.nextLine();

               listStudents[count++] = student;
               System.out.println("Student added!");

       }
        public void displayAll() {
            for (int i = 0; i < count; i++) {
                System.out.println(listStudents[i]);
            }
        }
       public Student findById(String id) {
            for (int i = 0; i < count; i++) {
                if (listStudents[i]!= null && listStudents[i].id.equals(id)) {
                    return listStudents[i];
                }
            }
            return null;
        }

        public Student updateStudent(Scanner sc, String id) {;
            Student s = findById(id);
             if (s == null) {
             System.out.println("Student not found!");
             return null;
            }

         // Name
            do {
                System.out.print("New name: ");
                s.name = sc.nextLine();
            } while (s.name.isEmpty());

            // Age
            do {
                System.out.print("New age: ");
                s.age = Integer.parseInt(sc.nextLine());
            } while (s.age < 18);

            // Address
            System.out.print("New address: ");
            s.address = sc.nextLine();

            // Gender
            do {
                System.out.print("New gender (male/female): ");
                s.gender = sc.nextLine();
            } while (!s.gender.equalsIgnoreCase("male")
                    && !s.gender.equalsIgnoreCase("female"));

            // Email
            System.out.print("New email: ");
            s.email = sc.nextLine();

            System.out.println("Updated successfully!");

            return s;
        }


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Main main = new Main();

            int choice;
            do {
                System.out.println("\n1. Create a student");
                System.out.println("2. Display all");
                System.out.println("3. Find a student by id");
                System.out.println("4. Update a student by id");
                System.out.println("5. Quit");
                System.out.print("Your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        main.createStudent();
                        break;
                    case 2:

                        main.displayAll();

                        break;
                    case 3:
                         System.out.print("Enter ID to find: ");
                        String findId = sc.nextLine();
                        Student found = main.findById(findId);
                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Not found!");
                        }
                        break;
                    case 4:
                        System.out.print("Enter ID to update: ");
                        String updateId = sc.nextLine();
                        main.updateStudent(sc, updateId);
                        break;
                }
            } while (choice != 5);
        }
    }


