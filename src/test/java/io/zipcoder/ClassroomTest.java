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
        Classroom testClassroom = new Classroom(this.students);
        assertEquals(3, testClassroom.getStudents().size());
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
        assertEquals(4, classroom.getStudents().size());

        assertEquals(newStudent, classroom.getStudents().get(classroom.getStudents().size() - 1));
    }

    @Test
    public void testRemoveStudent() {
        System.out.println(classroom.getStudents());
        System.out.println();
        classroom.removeStudent("Alice", "Johnson");
        System.out.println(classroom.getStudents());
        assertEquals(2, classroom.getStudents().size());
        assertFalse(Arrays.asList(classroom.getStudents()).contains(students[0]));
    }

    @Test
    public void testGetStudentsByScore() {
        List<Student> expected = new ArrayList<>(Arrays.asList(this.students));
        List<Student> actual = classroom.getStudentsByScore();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetGradeBook() {
        Map<Student, Character> gradeBook = classroom.getGradeBook();
        assertEquals('C', (char) gradeBook.get(students[0]));
        assertEquals('D', (char) gradeBook.get(students[1]));
        assertEquals('F', (char) gradeBook.get(students[2]));
    }
}
