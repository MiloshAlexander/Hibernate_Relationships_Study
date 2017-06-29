package by.it.milosh.controllers;

import by.it.milosh.entity.manyToMany.Course;
import by.it.milosh.entity.manyToOne.Person;
import by.it.milosh.service.service.CourseService;
import by.it.milosh.service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    /* работает */
    @RequestMapping(value = {"/addCourse"}, method = RequestMethod.GET)
    public String addCourse() {
        Course course = new Course("java");
        courseService.addCourse(course);
        System.out.println("Add course.");
        return "course";
    }

    /* работает */
    @RequestMapping(value = {"/getCourse"}, method = RequestMethod.GET)
    public String getCourse() {
        Course course = courseService.getCourse(1L);
        System.out.println("Course: " + course.getCourseName() + " was found.");
        return "course";
    }

    @RequestMapping(value = {"/deleteCourse"}, method = RequestMethod.GET)
    public String deleteCourse() {

        System.out.println("Delete course.");
        return "course";
    }

    @RequestMapping(value = {"/deleteCourseById"}, method = RequestMethod.GET)
    public String deleteCourseById() {

        System.out.println("Delete Course By Id.");
        return "course";
    }

    @RequestMapping(value = {"/deleteCourseByIdCustom"}, method = RequestMethod.GET)
    public String deleteCourseByIdCustom() {

        System.out.println("Delete Course By Id Custom.");
        return "course";
    }

}
