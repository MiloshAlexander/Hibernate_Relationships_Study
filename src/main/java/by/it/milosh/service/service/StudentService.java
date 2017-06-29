package by.it.milosh.service.service;

import by.it.milosh.entity.manyToMany.Student;

/**
 * Created by USER on 29.06.2017.
 */
public interface StudentService {

    void addStudent(Student student);

    Student getStudent(Long student_id);

    void deleteStudent(Student student);

    void deleteStudentById(Long student_id);

    void addCourseToStudent(Long student_id, Long course_id);

    void deleteStudentByIdCustom(Long student_id);

}
