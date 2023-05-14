package io.zipcoder;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private String fullName;
    private final List<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName) {
        StringBuilder titledFirstName = new StringBuilder(firstName);
        for (int i = 0; i < titledFirstName.length(); i++) {
            if (i == 0) {
                titledFirstName.setCharAt(i, Character.toUpperCase(titledFirstName.charAt(i)));
            } else if (titledFirstName.charAt(i - 1) == ' ') {
                titledFirstName.setCharAt(i, Character.toUpperCase(titledFirstName.charAt(i)));
            } else {
                titledFirstName.setCharAt(i, Character.toLowerCase(titledFirstName.charAt(i)));
            }
        }
        StringBuilder titledLastName = new StringBuilder(lastName);
        for (int i = 0; i < titledLastName.length(); i++) {
            if (i == 0) {
                titledLastName.setCharAt(i, Character.toUpperCase(titledLastName.charAt(i)));
            } else if (titledLastName.charAt(i - 1) == ' ') {
                titledLastName.setCharAt(i, Character.toUpperCase(titledLastName.charAt(i)));
            } else {
                titledLastName.setCharAt(i, Character.toLowerCase(titledLastName.charAt(i)));
            }
        }
        this.firstName = titledFirstName.toString();
        this.lastName = titledLastName.toString();
        this.fullName = this.firstName + ' ' + this.lastName;
    }
    public Student(String firstName, String lastName, Double[] examScores) {
        StringBuilder titledFirstName = new StringBuilder(firstName);
        for (int i = 0; i < titledFirstName.length(); i++) {
            if (i == 0) {
                titledFirstName.setCharAt(i, Character.toUpperCase(titledFirstName.charAt(i)));
            } else if (titledFirstName.charAt(i - 1) == ' ') {
                titledFirstName.setCharAt(i, Character.toUpperCase(titledFirstName.charAt(i)));
            } else {
                titledFirstName.setCharAt(i, Character.toLowerCase(titledFirstName.charAt(i)));
            }
        }
        StringBuilder titledLastName = new StringBuilder(lastName);
        for (int i = 0; i < titledLastName.length(); i++) {
            if (i == 0) {
                titledLastName.setCharAt(i, Character.toUpperCase(titledLastName.charAt(i)));
            } else if (titledLastName.charAt(i - 1) == ' ') {
                titledLastName.setCharAt(i, Character.toUpperCase(titledLastName.charAt(i)));
            } else {
                titledLastName.setCharAt(i, Character.toLowerCase(titledLastName.charAt(i)));
            }
        }
        this.firstName = titledFirstName.toString();
        this.lastName = titledLastName.toString();
        this.fullName = this.firstName + ' ' + this.lastName;
        this.examScores.addAll(Arrays.asList(examScores));
    }
    public Student(String firstName, String lastName, List<Double> examScores) {
        StringBuilder titledFirstName = new StringBuilder(firstName);
        for (int i = 0; i < titledFirstName.length(); i++) {
            if (i == 0) {
                titledFirstName.setCharAt(i, Character.toUpperCase(titledFirstName.charAt(i)));
            } else if (titledFirstName.charAt(i - 1) == ' ') {
                titledFirstName.setCharAt(i, Character.toUpperCase(titledFirstName.charAt(i)));
            } else {
                titledFirstName.setCharAt(i, Character.toLowerCase(titledFirstName.charAt(i)));
            }
        }
        StringBuilder titledLastName = new StringBuilder(lastName);
        for (int i = 0; i < titledLastName.length(); i++) {
            if (i == 0) {
                titledLastName.setCharAt(i, Character.toUpperCase(titledLastName.charAt(i)));
            } else if (titledLastName.charAt(i - 1) == ' ') {
                titledLastName.setCharAt(i, Character.toUpperCase(titledLastName.charAt(i)));
            } else {
                titledLastName.setCharAt(i, Character.toLowerCase(titledLastName.charAt(i)));
            }
        }
        this.firstName = titledFirstName.toString();
        this.lastName = titledLastName.toString();
        this.fullName = this.firstName + ' ' + this.lastName;
        this.examScores.addAll(examScores);
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getFullName() {
        return this.fullName;
    }
    public List<Double> getExamScores() {
        return this.examScores;
    }
    public int getNumberOfExamsTaken() {
        return this.examScores.size();
    }
    public double getAverageExamScore() {
        double examScoresSum = 0;
        for (Double examScore : this.examScores) {
            examScoresSum += examScore;
        }
        return (examScoresSum / this.examScores.size());
    }

    public void changeFirstName(String newFirstName) {
        StringBuilder titledNewFirstName = new StringBuilder(newFirstName);
        for (int i = 0; i < titledNewFirstName.length(); i++) {
            if (i == 0) {
                titledNewFirstName.setCharAt(i, Character.toUpperCase(titledNewFirstName.charAt(i)));
            } else if (titledNewFirstName.charAt(i - 1) == ' ') {
                titledNewFirstName.setCharAt(i, Character.toUpperCase(titledNewFirstName.charAt(i)));
            } else {
                titledNewFirstName.setCharAt(i, Character.toLowerCase(titledNewFirstName.charAt(i)));
            }
        }
        this.firstName = titledNewFirstName.toString();
        this.fullName = this.firstName + ' ' + this.lastName;
    }
    public void changeLastName(String newLastName) {
        StringBuilder titledNewLastName = new StringBuilder(newLastName);
        for (int i = 0; i < titledNewLastName.length(); i++) {
            if (i == 0) {
                titledNewLastName.setCharAt(i, Character.toUpperCase(titledNewLastName.charAt(i)));
            } else if (titledNewLastName.charAt(i - 1) == ' ') {
                titledNewLastName.setCharAt(i, Character.toUpperCase(titledNewLastName.charAt(i)));
            } else {
                titledNewLastName.setCharAt(i, Character.toLowerCase(titledNewLastName.charAt(i)));
            }
        }
        this.lastName = titledNewLastName.toString();
        this.fullName = this.firstName + ' ' + this.lastName;
    }
    public void addExamScore(double newExamScore) {
        this.examScores.add(newExamScore);
    }
    public void changeExamScore(int examNumber, double newExamScore) {
        this.examScores.set(examNumber - 1, newExamScore);
    }

    public String examScoresAsString() {
        StringBuilder examScoresAsString = new StringBuilder("Exam Scores:");
        for (Double examScore : this.examScores) {
            examScoresAsString.append("\n\tExam ").append(this.examScores.indexOf(examScore) + 1).append(" -> ").append(examScore);
        }
        return examScoresAsString.toString();
    }
    @Override
    public String toString() {
        StringBuilder studentStringRepresentation = new StringBuilder("Student Name: " + this.fullName);
        studentStringRepresentation.append("\n> Average Score: ").append(this.getAverageExamScore());
        studentStringRepresentation.append("\n> Exam Scores:");
        for (Double examScore : this.examScores) {
            studentStringRepresentation.append("\n\t Exam ").append(this.examScores.indexOf(examScore) + 1).append(" -> ").append(examScore);
        }
        return studentStringRepresentation.toString();
    }

    @Override
    public int compareTo(Student otherStudent) {
        int scoreComparison = Double.compare(this.getAverageExamScore(), otherStudent.getAverageExamScore());
        if (scoreComparison == 0) {
            return (this.fullName.toLowerCase().compareTo(otherStudent.fullName.toLowerCase()));
        }
        return scoreComparison;
    }
}
