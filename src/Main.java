import java.util.Scanner;
import model.Student;
import services.StudentService;
import util.FileHandler;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        String correctUsername = "admin";
        String correctPassword = "1234";

        System.out.println("===== LOGIN SYSTEM =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (!username.equals(correctUsername)
                || !password.equals(correctPassword)) {

            System.out.println("Invalid Username or Password!");

            return;
        }

        System.out.println("Login Successful!");
        while (true){
            System.out.println("\n==== STUDENT MANAGEMENT SYSTEM ====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort By Name");
            System.out.println("7. Sort By Marks");
            System.out.println("8. Show Topper");
            System.out.println("9. Show Passed Students");
            System.out.println("10. Exit");





            System.out.print("Enter choice: ");
            try {

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        if (service.isIdExists(id)) {

                            System.out.println("ID Already Exists!");

                            break;
                        }

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        if (name.trim().isEmpty()) {

                            System.out.println("Name Cannot Be Empty!");

                            break;
                        }

                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        if (age <= 0) {
                            System.out.println("Invalid Age!");
                            break;
                        }

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();
                        if (marks < 0 || marks > 100) {
                            System.out.println("Marks must be between 0 and 100!");
                            break;
                        }
                        System.out.print("Enter Total Classes: ");
                        int totalClasses = sc.nextInt();

                        System.out.print("Enter Attended Classes: ");
                        int attendedClasses = sc.nextInt();
                        if (attendedClasses > totalClasses) {
                            System.out.println("Attended Classes Cannot Be Greater Than Total Classes!");
                            break;
                        }

                        Student student = new Student(age,id,name,course,marks,totalClasses,attendedClasses);

                        service.addStudent(student);
                        break;
                    case 2:
                        service.viewStudents();
                        break;
                    case 3:
                        System.out.print("Enter Student ID to Search: ");
                        int searchId = sc.nextInt();
                        service.searchstudent(searchId);

                        break;
                    case 4:

                        System.out.print("Enter Student ID to Update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Course: ");
                        String newCourse = sc.nextLine();

                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();

                        service.updateStudent(updateId, newName,
                                newAge, newCourse, newMarks);

                        break;
                    case 5:
                        System.out.print("Enter Student ID to Delete: ");
                        int deleteId = sc.nextInt();
                        service.deleteStudent(deleteId);
                        break;
                    case 6:
                        service.sortByName();
                        break;
                    case 7:
                        service.sortByMarks();
                        break;
                    case 8:
                        service.showTopper();
                        break;
                    case 9:
                        service.showPassedStudents();
                        break;

                    case 10:
                        FileHandler.saveStudents(service.getStudents());
                        System.out.println("Thank You!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");


                }

            } catch (Exception e) {

                System.out.println("Invalid Input!");

                sc.nextLine();
            }
        }
    }
}