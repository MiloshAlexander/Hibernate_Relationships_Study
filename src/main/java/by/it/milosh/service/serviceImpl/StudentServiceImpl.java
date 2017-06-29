package by.it.milosh.service.serviceImpl;

import by.it.milosh.entity.manyToMany.Student;
import by.it.milosh.repository.dao.StudentDao;
import by.it.milosh.service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public Student getStudent(Long student_id) {
        return studentDao.getStudent(student_id);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteStudent(student);
    }

    @Override
    public void deleteStudentById(Long student_id) {
        studentDao.deleteStudentById(student_id);
    }

    @Override
    public void addCourseToStudent(Long student_id, Long course_id) {
        studentDao.addCourseToStudent(student_id, course_id);
    }

    @Override
    public void deleteStudentByIdCustom(Long student_id) {
        studentDao.deleteStudentByIdCustom(student_id);
    }
}
