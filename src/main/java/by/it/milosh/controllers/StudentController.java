package by.it.milosh.controllers;

import by.it.milosh.entity.manyToMany.Course;
import by.it.milosh.entity.manyToMany.Student;
import by.it.milosh.service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    /* работает */
    @RequestMapping(value = {"/addStudent"}, method = RequestMethod.GET)
    public String addStudent() {
        Student student = new Student("st1");
        studentService.addStudent(student);
        System.out.println("Add student.");
        return "student";
    }

    /* работает */
    @RequestMapping(value = {"/getStudent"}, method = RequestMethod.GET)
    public String getStudent() {
        Student student = studentService.getStudent(1L);
        System.out.println("Student: " + student.getStudentName() + " was found.");
        return "student";
    }

    @RequestMapping(value = {"/deleteStudent"}, method = RequestMethod.GET)
    public String deleteStudent() {

        System.out.println("Delete student.");
        return "student";
    }

    /* удалил студента и по каскаду все курсы */
    @RequestMapping(value = {"/deleteStudentById"}, method = RequestMethod.GET)
    public String deleteStudentById() {
        studentService.deleteStudentById(1L);
        System.out.println("Delete Student By Id.");
        return "student";
    }

    /* один студент - один курс работает
     * многие ко многим - работает
     * */
    @RequestMapping(value = {"/deleteStudentByIdCustom"}, method = RequestMethod.GET)
    public String deleteStudentByIdCustom() {
        studentService.deleteStudentByIdCustom(1L);
        System.out.println("Delete Student By Id Custom.");
        return "student";
    }

    /* работает */
    @RequestMapping(value = {"/addCourseToStudent"}, method = RequestMethod.GET)
    public String addCourseToStudent() {
        studentService.addCourseToStudent(1L, 1L);
        System.out.println("Add course to Student.");
        return "student";
    }

}
