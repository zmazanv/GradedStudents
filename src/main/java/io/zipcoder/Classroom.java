package io.zipcoder;

import io.zipcoder.comparators.StudentDescendingComparator;

import java.util.*;

public class Classroom {
    private final List<Student> students = new ArrayList<>();

    public Classroom() {}
    public Classroom(Student[] students) {
        this.students.addAll(Arrays.asList(students));
    }
    public Classroom(List<Student> students) {
        this.students.addAll(students);
    }

    public List<Student> getStudents() {
        return this.students;
    }
    public List<Student> getStudentsByScore() {
        List<Student> studentsByScore = new ArrayList<>(this.students);
        studentsByScore.sort(new StudentDescendingComparator());
        return studentsByScore;
    }
    public Map<Student, Character> getGradeBook() {
        Map<Student, Character> gradeBook = new TreeMap<>(new StudentDescendingComparator());
        List<Student> studentsByScore = new ArrayList<>(this.students);
        for (int i = 0; i < this.students.size(); i++) {
            double percentileRank = (double)(i + 1) / this.students.size() * 100;
            char grade = 0;
            if (percentileRank <= 10) {
                grade = 'A';
            } else if (percentileRank <= 30) {
                grade = 'B';
            } else if (percentileRank <= 50) {
                grade = 'C';
            } else if (percentileRank <= 90) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            gradeBook.put(studentsByScore.get(i), grade);
        }
        return gradeBook;
    }
    public double getAverageExamScore() {
        double examScoreAveragesSum = 0;
        for (Student student : this.students) {
            examScoreAveragesSum += student.getAverageExamScore();
        }
        return (examScoreAveragesSum / this.students.size());
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student studentToBeRemoved) {
        this.students.remove(studentToBeRemoved);
    }
    public void removeStudent(String firstNameOfStudentToBeRemoved, String lastNameOfStudentToBeRemoved) {
        String fullNameOfStudentToBeRemoved = firstNameOfStudentToBeRemoved + ' ' + lastNameOfStudentToBeRemoved;
        Student studentToBeRemoved = null;
        for (Student student : this.students) {
            if (Objects.equals(student.getFullName().toLowerCase(), fullNameOfStudentToBeRemoved.toLowerCase())) {
                studentToBeRemoved = student;
            }
        }
        this.students.remove(studentToBeRemoved);
    }
}
