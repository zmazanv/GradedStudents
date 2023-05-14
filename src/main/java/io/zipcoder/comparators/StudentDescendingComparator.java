package io.zipcoder.comparators;

import io.zipcoder.Student;

import java.util.Comparator;

public class StudentDescendingComparator implements Comparator<Student> {
    @Override
    public int compare(Student studentOne, Student studentTwo) {
        int scoreComparison = (Double.compare(studentOne.getAverageExamScore(), studentTwo.getAverageExamScore())) * -1;
        if (scoreComparison == 0) {
            return studentOne.getFullName().compareTo(studentTwo.getFullName());
        }
        return scoreComparison;
    }
}
