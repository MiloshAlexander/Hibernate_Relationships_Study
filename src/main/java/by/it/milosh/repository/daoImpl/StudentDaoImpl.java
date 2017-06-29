package by.it.milosh.repository.daoImpl;

import by.it.milosh.entity.manyToMany.Course;
import by.it.milosh.entity.manyToMany.Student;
import by.it.milosh.repository.dao.StudentDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addStudent(Student student) {
        getSession().save(student);
    }

    @Override
    public Student getStudent(Long student_id) {
        return (Student) getSession().get(Student.class, student_id);
    }

    @Override
    public void deleteStudent(Student student) {

    }

    @Override
    public void deleteStudentById(Long student_id) {
        Student student = getSession().get(Student.class, student_id);
        getSession().delete(student);
    }

    @Override
    public void addCourseToStudent(Long student_id, Long course_id) {
        Student student = getSession().get(Student.class, student_id);
        Course course = getSession().get(Course.class, course_id);
        student.getCourses().add(course);
        getSession().save(student);
    }

    @Override
    public void deleteStudentByIdCustom(Long student_id) {
        Student student = getSession().get(Student.class, student_id);
        student.setCourses(null);
        getSession().save(student);
        Course course = getSession().get(Course.class, 1L);
        getSession().delete(student);
        System.out.println("OK");
        Course course1 = getSession().get(Course.class, 1L);
        System.out.println("DEL");

    }
}
