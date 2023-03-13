package student;

public class Student {
    private int rollNumber;
    private String name;
    private String course;
    private int marks1;
    private int marks2;
    private int marks3;

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getMarks1() {
        return marks1;
    }

    public void setMarks1(int marks1) {
        this.marks1 = marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public void setMarks2(int marks2) {
        this.marks2 = marks2;
    }

    public int getMarks3() {
        return marks3;
    }

    public void setMarks3(int marks3) {
        this.marks3 = marks3;
    }

    public int calculateTotal() {
        return marks1 + marks2 + marks3;
    }

    public double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    public String calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 90) {
            return "A+";
        } else if (avg >= 80) {
            return "A";
        } else if (avg >= 70) {
            return "B+";
        } else if (avg >= 60) {
            return "B";
        } else if (avg >= 50) {
            return "C+";
        } else if (avg >= 40) {
            return "C";
        } else {
            return "F";
        }
    }

    @Override
    public String toString() {
        return "Student [rollNumber=" + rollNumber + ", name=" + name + ", course=" + course + ", marks1=" + marks1
                + ", marks2=" + marks2 + ", marks3=" + marks3 + ", total=" + calculateTotal() + ", average="
                + calculateAverage() + ", grade=" + calculateGrade() + "]";
    }
}
