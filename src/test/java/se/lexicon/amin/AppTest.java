package se.lexicon.amin;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.amin.config.ComponentScanConfig;
import se.lexicon.amin.models.Student;
import se.lexicon.amin.service.StudentManagement;

import java.util.List;


public class AppTest {

    StudentManagement studentManagement;
    Student testStudent1;
    Student testStudent2;
    Student testStudent3;

    @Before
    public void setup() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        studentManagement = context.getBean(StudentManagement.class);

        testStudent1 = new Student(1, "student1");
        testStudent2 = new Student(2, "student2");
        testStudent3 = new Student(3, "student3");

    }

    @Test
    public void saveStudents() {

        studentManagement.save(testStudent1);
        studentManagement.save(testStudent2);
        studentManagement.save(testStudent3);

        List<Student> studentList = studentManagement.findAll();

        assertTrue(studentList.contains(testStudent1));
        assertTrue(studentList.contains(testStudent2));
        assertTrue(studentList.contains(testStudent3));

    }

    @Test
    public void findById() {

        studentManagement.save(testStudent1);

        Student student = studentManagement.find(1);

        assertEquals(1, student.getId());
        assertEquals("student1", student.getName());
    }

    @Test
    public void removeStudent() {

        studentManagement.save(testStudent1);
        studentManagement.save(testStudent2);
        studentManagement.save(testStudent3);

        //Remove testStudent3
        studentManagement.remove(3);

        List<Student> studentList = studentManagement.findAll();

        //testStudent 1 and 2 should still be in the list
        assertTrue(studentList.contains(testStudent1));
        assertTrue(studentList.contains(testStudent2));

        //testStudent3 should not be in the list
        assertFalse(studentList.contains(testStudent3));

    }



}
