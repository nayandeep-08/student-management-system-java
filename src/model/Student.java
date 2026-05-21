package model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;
    private int totalClasses;
    private int attendedClasses;

    public Student(int age, int id, String name, String course, double marks,int totalClasses,int attendedClasses) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }
    public int getTotalClasses() {
        return totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Age: " + age +
                " | Course: " + course +
                " | Marks: " + marks+
                " | Grade: " + calculateGrade()+
                " | Attendance: " + calculateAttendance() + "%";


    }
    public String calculateGrade() {

        if (marks >= 90) {

            return "A";
        }

        else if (marks >= 75) {

            return "B";
        }

        else if (marks >= 60) {

            return "C";
        }

        else {

            return "Fail";
        }
    }
    public double calculateAttendance() {

        if (totalClasses == 0) {

            return 0;
        }

        return (attendedClasses * 100.0) / totalClasses;
    }
}
