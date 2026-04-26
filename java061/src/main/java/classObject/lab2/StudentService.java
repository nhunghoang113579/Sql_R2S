package classObject.lab2;

import java.util.Scanner;

public class StudentService {

    Student[] studentList = new Student[100];
    int count = 0;
    Scanner scanner = new Scanner(System.in);

    // ===== CREATE =====
    Student createStudent() {
        Student student = new Student();

        // ID
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        if (findById(id) != null) {
            System.out.println("ID already exists!");
            return null;
        }
        student.id = id;

        // NAME
        while (true) {
            try {
                System.out.print("Enter name: ");
                student.name = checkName(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // AGE
        while (true) {
            try {
                System.out.print("Enter age: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (!checkAge(age)) continue;
                student.age = age;
                break;
            } catch (Exception e) {
                System.out.println("Invalid age!");
            }
        }

        // ADDRESS
        System.out.print("Enter address: ");
        student.address = scanner.nextLine();

        // GENDER
        while (true) {
            try {
                System.out.print("Enter gender: ");
                student.gender = checkGender(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // EMAIL
        System.out.print("Enter email: ");
        student.email = scanner.nextLine();

        // ADD TO ARRAY
        studentList[count++] = student;

        System.out.println("Student added successfully!");
        return student;
    }

    // ===== DISPLAY =====
    void displayAll() {
        if (count == 0) {
            System.out.println("Student list is empty");
            return;
        }

        System.out.println("===== STUDENT LIST =====");
        for (int i = 0; i < count; i++) {
            studentList[i].display();
        }
    }

    // ===== FIND =====
    public Student findById(String id) {
        for (int i = 0; i < count; i++) {
            if (studentList[i].id.equals(id)) {
                return studentList[i];
            }
        }
        return null;
    }

    // ===== UPDATE =====
    Student updateStudent(String id) {
        Student student = findById(id);

        if (student == null) {
            System.out.println("Student not found!");
            return null;
        }

        // NAME
        while (true) {
            try {
                System.out.print("Enter new name: ");
                student.name = checkName(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // AGE
        while (true) {
            try {
                System.out.print("Enter new age: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (!checkAge(age)) continue;
                student.age = age;
                break;
            } catch (Exception e) {
                System.out.println("Invalid age!");
            }
        }

        // ADDRESS
        System.out.print("Enter new address: ");
        student.address = scanner.nextLine();

        // GENDER
        while (true) {
            try {
                System.out.print("Enter new gender: ");
                student.gender = checkGender(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // EMAIL
        System.out.print("Enter new email: ");
        student.email = scanner.nextLine();

        System.out.println("Student updated successfully!");
        return student;
    }

    // ===== VALIDATION =====
    public boolean checkAge(int age) {
        if (age < 18) {
            System.out.println("Age must be >= 18");
            return false;
        }
        return true;
    }

    public String checkGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Gender cannot be empty");
        }

        if (gender.equalsIgnoreCase("male")) return "male";
        if (gender.equalsIgnoreCase("female")) return "female";

        throw new IllegalArgumentException("Gender must be male or female");
    }

    public String checkName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return name;
    }
}