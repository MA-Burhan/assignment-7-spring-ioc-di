package se.lexicon.amin.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.amin.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {

    private List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student student) {
        if(student != null && !students.contains(student)) {

            students.add(student);
        }

        return student;
    }

    @Override
    public Student find(int id) {
        for(Student student : students) {
            if(student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student delete(int id) {

        for (Student student  : students) {

            if (student.getId() == id) {
                students.remove(student);
                return student;
            }

        }
        return null;
    }
}
