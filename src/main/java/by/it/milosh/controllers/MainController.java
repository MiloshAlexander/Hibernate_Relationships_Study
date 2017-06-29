package by.it.milosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String hello() {
        return "index";
    }

    @RequestMapping(value = {"/goUser"}, method = RequestMethod.GET)
    public String goUser() {
        return "user";
    }

    @RequestMapping(value = {"/goAddress"}, method = RequestMethod.GET)
    public String goAddress() {
        return "address";
    }

    @RequestMapping(value = {"/goPerson"}, method = RequestMethod.GET)
    public String goPerson() {
        return "person";
    }

    @RequestMapping(value = {"/goStudent"}, method = RequestMethod.GET)
    public String goStudent() {
        return "student";
    }

    @RequestMapping(value = {"/goCourse"}, method = RequestMethod.GET)
    public String goCourse() {
        return "course";
    }

}
