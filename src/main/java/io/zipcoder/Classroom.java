package io.zipcoder;

import io.zipcoder.comparators.StudentDescendingComparator;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Classroom {
    private Student[] students;

    public Classroom() {
        this.students = new Student[30];
    }
    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }
    public Classroom(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return this.students;
    }
    public Student[] getStudentsByScore() {
        Student[] studentsByScore = new Student[this.students.length];
        System.arraycopy(this.students, 0,studentsByScore, 0, this.students.length);
        Arrays.sort(studentsByScore, new StudentDescendingComparator());
        return studentsByScore;
    }
    public Map<Student, Character> getGradeBook() {
        Map<Student, Character> gradeBook = new TreeMap<>(new StudentDescendingComparator());
        Student[] studentsByScore = this.getStudentsByScore();
        for (int i = 0; i < this.students.length; i++) {
            Student student = studentsByScore[i];
            double percentileRank = (double)(i + 1) / this.students.length * 100;
            char grade = 0;
            if (percentileRank < 10) {
                grade = 'A';
            } else if (percentileRank < 30) {
                grade = 'B';
            } else if (percentileRank < 50) {
                grade = 'C';
            } else if (percentileRank < 90) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            gradeBook.put(student, grade);
        }
        return gradeBook;
    }
    public double getAverageExamScore() {
        double examScoreAveragesSum = 0;
        for (Student student : this.students) {
            examScoreAveragesSum += student.getAverageExamScore();
        }
        return (examScoreAveragesSum / this.students.length);
    }

    public void addStudent(Student student) {
        Student[] studentsPlusOne = new Student[this.students.length + 1];
        System.arraycopy(this.students, 0, studentsPlusOne, 0, this.students.length);
        studentsPlusOne[studentsPlusOne.length - 1] = student;
        this.students = studentsPlusOne;
    }

    public void removeStudent(Student studentToBeRemoved) {
        Student[] studentsMinusOne = new Student[this.students.length - 1];
        for (int i = 0; i < this.students.length; i++) {
            if (!(Objects.equals(this.students[i], studentToBeRemoved))) {
                studentsMinusOne[i] = this.students[i];
            }
        }
        this.students = studentsMinusOne;
    }
    public void removeStudent(String firstNameOfStudentToBeRemoved, String lastNameOfStudentToBeRemoved) {
        String fullNameOfStudentToBeRemoved = firstNameOfStudentToBeRemoved + ' ' + lastNameOfStudentToBeRemoved;
        Student[] studentsMinusOne = new Student[this.students.length - 1];
        int counter = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (!(Objects.equals(this.students[i].getFullName().toLowerCase(), fullNameOfStudentToBeRemoved.toLowerCase()))) {
                studentsMinusOne[counter] = this.students[i];
                counter++;
            }
        }
        this.students = studentsMinusOne;
    }
}
