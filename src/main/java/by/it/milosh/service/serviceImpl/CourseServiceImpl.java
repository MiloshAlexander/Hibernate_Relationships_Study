package by.it.milosh.service.serviceImpl;

import by.it.milosh.entity.manyToMany.Course;
import by.it.milosh.repository.dao.CourseDao;
import by.it.milosh.service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;


    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public Course getCourse(Long course_id) {
        return courseDao.getCourse(course_id);
    }

    @Override
    public void deleteCourse(Course course) {
        courseDao.deleteCourse(course);
    }

    @Override
    public void deleteCourseById(Long course_id) {
        courseDao.deleteCourseById(course_id);
    }
}
