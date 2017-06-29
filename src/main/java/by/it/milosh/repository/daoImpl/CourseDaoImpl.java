package by.it.milosh.repository.daoImpl;

import by.it.milosh.entity.manyToMany.Course;
import by.it.milosh.repository.dao.CourseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCourse(Course course) {
        getSession().save(course);
    }

    @Override
    public Course getCourse(Long course_id) {
        return (Course) getSession().get(Course.class, course_id);
    }

    @Override
    public void deleteCourse(Course course) {

    }

    @Override
    public void deleteCourseById(Long course_id) {

    }
}
