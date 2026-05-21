package services;

import model.Student;
import util.FileHandler;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import java.util.ArrayList;

public class StudentService {

    ArrayList<Student> students = FileHandler.loadStudents();
    // Add Student
    public void addStudent(Student student) {

        students.add(student);

        System.out.println("Student Added Successfully!");
    }

    // View Students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }
    public void searchstudent(int id){
        boolean found = false;
        for (Student s: students){
            if (s.getId()==id){
                System.out.println("student found");
                System.out.println(s);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("student not found");
        }
    }
    public void updateStudent(int id, String name, int age,
                              String course, double marks) {

        boolean found = false;

        for (Student s : students) {

            if (s.getId() == id) {

                s.setName(name);
                s.setAge(age);
                s.setCourse(course);
                s.setMarks(marks);

                System.out.println("Student Updated Successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }
    public void deleteStudent(int id) {

        boolean found = false;

        for (Student s : students) {

            if (s.getId() == id) {

                students.remove(s);

                System.out.println("Student Deleted Successfully!");

                found = true;

                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void sortByName() {

        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });

        System.out.println("Students Sorted By Name!");

        viewStudents();
    }
    public void sortByMarks() {

        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                return Double.compare(s2.getMarks(), s1.getMarks());
            }
        });

        System.out.println("Students Sorted By Marks!");

        viewStudents();
    }
    public boolean isIdExists(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void showTopper() {

        Student topper = students.stream()

                .max((s1, s2) ->
                        Double.compare(s1.getMarks(),
                                s2.getMarks()))

                .orElse(null);

        if (topper != null) {

            System.out.println("Topper Student:");
            System.out.println(topper);
        }
    }
    public void showPassedStudents() {

        List<Student> passedStudents = students.stream()
                .filter(s -> s.getMarks() >= 60)
                .collect(Collectors.toList());
        if (passedStudents.isEmpty()) {
            System.out.println("No Passed Students!");
            return;
        }
        for (Student s : passedStudents) {
            System.out.println(s);
        }
    }

}