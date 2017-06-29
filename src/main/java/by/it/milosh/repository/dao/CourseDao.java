package by.it.milosh.repository.dao;

import by.it.milosh.entity.manyToMany.Course;

public interface CourseDao {

    void addCourse(Course course);

    Course getCourse(Long course_id);

    void deleteCourse(Course course);

    void deleteCourseById(Long course_id);



}
