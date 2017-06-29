package by.it.milosh.service.service;

import by.it.milosh.entity.manyToMany.Course;

public interface CourseService {

    void addCourse(Course course);

    Course getCourse(Long course_id);

    void deleteCourse(Course course);

    void deleteCourseById(Long course_id);

}
