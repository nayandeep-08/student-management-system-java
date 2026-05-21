package util;

import model.Student;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    // data folder ke andar file save hogi
    private static final String FILE_PATH = "data/students.txt";
    // SAVE STUDENTS
    public static void saveStudents(ArrayList<Student> students) {

        try {

            File file = new File(FILE_PATH);

            // agar data folder nahi ho to create ho jaye
            file.getParentFile().mkdirs();

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(file));

            for (Student s : students) {

                writer.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getCourse() + "," +
                                s.getMarks() + "," +
                                s.getTotalClasses() + "," +
                                s.getAttendedClasses()
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("Data Saved Successfully!");

        } catch (Exception e) {

            System.out.println("Error Saving Data!");
            e.printStackTrace();
        }
    }

    // LOAD STUDENTS
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try {

            File file = new File(FILE_PATH);

            // file nahi hai to empty list return
            if (!file.exists()) {
                file.createNewFile();
                return students;
            }

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                double marks = Double.parseDouble(data[4]);
                int totalClasses = Integer.parseInt(data[5]);
                int attendedClasses = Integer.parseInt(data[6]);

                Student student = new Student(
                        age,
                        id,
                        name,
                        course,
                        marks,
                        totalClasses,
                        attendedClasses
                );

                students.add(student);
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("Error Loading Data!");
            e.printStackTrace();
        }

        return students;
    }
}