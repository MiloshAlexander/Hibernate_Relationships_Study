package by.it.milosh.controllers;

import by.it.milosh.entity.manyToOne.Person;
import by.it.milosh.service.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    /* работает */
    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.GET)
    public String addPerson() {
        Person person = new Person("Miller");
        personService.addPerson(person);
        System.out.println("Add user.");
        return "person";
    }

    /* работает */
    @RequestMapping(value = {"/getPerson"}, method = RequestMethod.GET)
    public String getPerson() {
        Person person = personService.getPerson(1L);
        System.out.println("User: " + person.getPersonName() + " was found.");
        return "person";
    }

    @RequestMapping(value = {"/deletePerson"}, method = RequestMethod.GET)
    public String deletePerson() {
        return "person";
    }

    /* 1. Когда нет связей, то работает. */
    /* 2. У перзона один адресс, у адреса один перзон. Перзон удаляется, от адреса уходит перзон.*/
    /* 3. У перзона один адресс, у адреса много перзонов. Перзон удаляется, от адреса уходит перзон, а остальные остаются*/
    @RequestMapping(value = {"/deletePersonById"}, method = RequestMethod.GET)
    public String deletePersonById() {
        personService.deletePersonById(1L);
        System.out.println("User was deleted.");
        return "person";
    }

    /* работает */
    @RequestMapping(value = {"/addAddressToPerson"}, method = RequestMethod.GET)
    public String addAddressToPerson() {
        personService.addAddressToPerson(1L, 1L);
        System.out.println("Address was added to person.");
        return "person";
    }

}
