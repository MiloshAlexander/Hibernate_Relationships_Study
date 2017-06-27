package by.it.milosh.controllers;

import by.it.milosh.entity.single.User;
import by.it.milosh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /* работает */
    @RequestMapping(value = {"/addUser"}, method = RequestMethod.GET)
    public String addUser() {
        User user = new User("Timur");
        userService.addUser(user);
        System.out.println("Add user.");
        return "user";
    }

    /* работает */
    @RequestMapping(value = {"/getUser"}, method = RequestMethod.GET)
    public String getUser() {
        User user = userService.getUser(2L);
        System.out.println("User: " + user.getUsername() + " was found.");
        return "user";
    }

    /* этот метод не работает, потому что мы находим юзера вне транзакции, то есть юзер - detached объект
     * getUser(1L) нужно делать внутри транзакции (то есть внутри UserDao)
     * см. метод deleteUserById */
    @RequestMapping(value = {"/deleteUser"}, method = RequestMethod.GET)
    public String deleteUser() {
        User user = userService.getUser(1L);
        userService.deleteUser(user);
        System.out.println("User:" + user.getUsername() + " was deleted.");
        return "user";
    }

    /* работает */
    @RequestMapping(value = {"/deleteUserById"}, method = RequestMethod.GET)
    public String deleteUserById() {
        userService.deleteUserById(1L);
        System.out.println("User was deleted.");
        return "user";
    }




}
