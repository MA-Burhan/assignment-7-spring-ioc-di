package se.lexicon.amin.data_access;

import se.lexicon.amin.models.Student;

import java.util.List;

public interface StudentDao {

    Student save(Student student);

    Student find(int id);

    List<Student> findAll();

    Student delete(int id);
}
