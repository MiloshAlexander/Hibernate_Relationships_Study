package by.it.milosh.repository.dao;

import by.it.milosh.entity.manyToMany.Student;

public interface StudentDao {

    void addStudent(Student student);

    Student getStudent(Long student_id);

    void deleteStudent(Student student);

    void deleteStudentById(Long student_id);

    void addCourseToStudent(Long student_id, Long course_id);

    void deleteStudentByIdCustom(Long student_id);


}
