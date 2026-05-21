package util;

import model.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_PATH =
            "src/data/students.txt";

    // SAVE STUDENTS
    public static void saveStudents(ArrayList<Student> students) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(FILE_PATH));

            for (Student s : students) {

                writer.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getCourse() + "," +
                                s.getMarks() +","+
                                s.getTotalClasses() + "," +
                                s.getAttendedClasses()
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("Data Saved Successfully!");

        } catch (IOException e) {

            System.out.println("Error Saving Data!");
        }
    }

    // LOAD STUDENTS
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();


        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_PATH));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                double marks = Double.parseDouble(data[4]);
                int totalClasses = Integer.parseInt(data[5]);
                int attendedClasses = Integer.parseInt(data[6]);

                Student student =
                        new Student(age,id,name, course, marks,totalClasses,attendedClasses);

                students.add(student);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error Loading Data!");
        }

        return students;
    }
}