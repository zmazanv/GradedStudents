package io.zipcoder;

import java.util.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    private Student student;
    private Student studentWithExamScores;
    private Student studentWithExamScoresList;

    @Before
    public void setUp() {
        student = new Student("John", "Doe");
        Double[] examScores = {90.0, 80.0, 70.0, 60.0, 50.0};
        studentWithExamScores = new Student("Jane", "Doe", examScores);
        List<Double> examScoresList = Arrays.asList(examScores);
        studentWithExamScoresList = new Student("Jack", "Smith", examScoresList);
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", student.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", student.getLastName());
    }

    @Test
    public void testGetFullName() {
        assertEquals("John Doe", student.getFullName());
    }

    @Test
    public void testGetExamScores() {
        List<Double> expectedExamScores = Arrays.asList(90.0, 80.0, 70.0, 60.0, 50.0);
        assertEquals(expectedExamScores, studentWithExamScores.getExamScores());
    }

    @Test
    public void testGetNumberOfExamsTaken() {
        assertEquals(5, studentWithExamScores.getNumberOfExamsTaken());
    }

    @Test
    public void testGetAverageExamScore() {
        double expectedAverage = 70.0;
        assertEquals(expectedAverage, studentWithExamScores.getAverageExamScore(), 0.01);
    }

    @Test
    public void testChangeFirstName() {
        student.changeFirstName("Jimmy");
        assertEquals("Jimmy", student.getFirstName());
    }

    @Test
    public void testChangeLastName() {
        student.changeLastName("Smith");
        assertEquals("Smith", student.getLastName());
    }

    @Test
    public void testAddExamScore() {
        student.addExamScore(100.0);
        assertEquals(1, student.getNumberOfExamsTaken());
        assertEquals(100.0, student.getExamScores().get(0), 0.01);
    }

    @Test
    public void testChangeExamScore() {
        studentWithExamScores.changeExamScore(1, 95.0);
        assertEquals(95.0, studentWithExamScores.getExamScores().get(0), 0.01);
    }

    @Test
    public void testExamScoresAsString() {
        String expectedOutput = "Exam Scores:\n\tExam 1 -> 90.0\n\tExam 2 -> 80.0\n\tExam 3 -> 70.0\n\tExam 4 -> 60.0\n\tExam 5 -> 50.0";
        assertEquals(expectedOutput, studentWithExamScores.examScoresAsString());
    }

    @Test
    public void testToString() {
        String expectedOutput = "Student Name: Jane Doe\n> Average Score: 70.0\n> Exam Scores:\n\t Exam 1 -> 90.0\n\t Exam 2 -> 80.0\n\t Exam 3 -> 70.0\n\t Exam 4 -> 60.0\n\t Exam 5 -> 50.0";
        assertEquals(expectedOutput, studentWithExamScores.toString());
    }

    @Test
    public void testCompareTo_SameAverageDifferentName() {
        Student student1 = new Student("Alice", "Johnson", Arrays.asList(75.0, 85.0));
        Student student2 = new Student("Bob", "Johnson", Arrays.asList(85.0, 75.0));
        assertEquals(-1, student1.compareTo(student2));
    }

    @Test
    public void testCompareTo_DifferentAverage() {
        Student student1 = new Student("Alice", "Johnson", Arrays.asList(75.0, 85.0));
        Student student2 = new Student("Bob", "Johnson", Arrays.asList(80.0, 90.0));
        assertTrue(student1.compareTo(student2) < 0);
    }

    @Test
    public void testCompareTo_SameAverageSameName() {
        Student student1 = new Student("Alice", "Johnson", Arrays.asList(75.0, 85.0));
        Student student2 = new Student("Alice", "Johnson", Arrays.asList(85.0, 75.0));
        assertEquals(0, student1.compareTo(student2));
    }
}