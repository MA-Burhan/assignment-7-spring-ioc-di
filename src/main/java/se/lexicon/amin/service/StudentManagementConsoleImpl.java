package se.lexicon.amin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.amin.data_access.StudentDao;
import se.lexicon.amin.models.Student;
import se.lexicon.amin.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    @Autowired
    UserInputService scannerService;

    @Autowired
    StudentDao studentDao;

    @Override
    public Student create() {
        System.out.print("Enter student ID: ");
        int studentId = scannerService.getInt();
        System.out.print("Enter student Name: ");
        String studentName = scannerService.getString();

        return new Student(studentId, studentName);
    }

    @Override
    public Student save(Student student) {
        studentDao.save(student);
        return student;
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
       return studentDao.delete(id);

    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {

        System.out.println("Enter new ID: ");
        student.setId(scannerService.getInt());
        System.out.println("Enter new Name: ");
        student.setName(scannerService.getString());

        return student;

    }
}
