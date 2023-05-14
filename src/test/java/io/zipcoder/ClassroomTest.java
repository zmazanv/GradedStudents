package io.zipcoder;

import java.util.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import io.zipcoder.comparators.StudentDescendingComparator;

public class ClassroomTest {
    private Classroom classroom;
    private Student[] students;

    @Before
    public void setUp() {
        students = new Student[]{
                new Student("Alice", "Johnson", Arrays.asList(75.0, 85.0)),
                new Student("Bob", "Smith", Arrays.asList(65.0, 90.0)),
                new Student("Charlie", "Brown", Arrays.asList(80.0, 70.0))
        };
        classroom = new Classroom(students);
    }

    @Test
    public void testConstructor() {
        Classroom testClassroom = new Classroom(10);
        assertEquals(10, testClassroom.getStudents().length);
    }

    @Test
    public void testGetAverageExamScore() {
        double expected = (75.0 + 85.0 + 65.0 + 90.0 + 80.0 + 70.0) / 6;
        double actual = classroom.getAverageExamScore();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testAddStudent() {
        Student newStudent = new Student("David", "White", Arrays.asList(80.0, 85.0));
        classroom.addStudent(newStudent);
        assertEquals(4, classroom.getStudents().length);
        assertEquals(newStudent, classroom.getStudents()[classroom.getStudents().length - 1]);
    }

    @Test
    public void testRemoveStudent() {
        classroom.removeStudent("Alice", "Johnson");
        assertEquals(2, classroom.getStudents().length);
        assertFalse(Arrays.asList(classroom.getStudents()).contains(students[0]));
    }

    @Test
    public void testGetStudentsByScore() {
        Student[] expected = {students[0], students[1], students[2]};
        Student[] actual = classroom.getStudentsByScore();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetGradeBook() {
        Map<Student, Character> gradeBook = classroom.getGradeBook();
        System.out.println(gradeBook);
        assertEquals('C', (char) gradeBook.get(students[0]));
        assertEquals('D', (char) gradeBook.get(students[1]));
        assertEquals('F', (char) gradeBook.get(students[2]));
    }
}
