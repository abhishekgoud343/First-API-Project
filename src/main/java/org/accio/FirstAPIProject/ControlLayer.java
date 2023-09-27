package org.accio.FirstAPIProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ControlLayer {
    @Autowired
    private ServiceLayer serviceLayerObj;

    @PostMapping("/addUserViaReqBody")
    public String addUserToDB(@RequestBody UserInfo obj) {
        return serviceLayerObj.addUserToDB(obj);
    }

    @PostMapping("/addUser")
    public String addUserToDB(@RequestParam("userId") Integer userId, @RequestParam("name") String name, @RequestParam("age") Integer age, @RequestParam("emailId") String emailId) {
        return serviceLayerObj.addUserToDB(userId, name, age, emailId);
    }

    @GetMapping("/getUser/{userId}")
    public UserInfo getUserInfo(@PathVariable("userId") Integer userId) {
        return serviceLayerObj.getUserInfo(userId);
    }

    @GetMapping("/getUserInfoByUserId")
    public UserInfo getUserInfoByUserId(@RequestParam("userId") Integer userId) {
        return serviceLayerObj.getUserInfo(userId);
    }

    @GetMapping("/getUsers/{minAge}/{maxAge}")
    public List<UserInfo> getUsers(@PathVariable("minAge") Integer minAge, @PathVariable("maxAge") Integer maxAge) {
        return serviceLayerObj.getUsersFilterByAge(minAge, maxAge);
    }

    @GetMapping("/findAllUsers")
    public List<UserInfo> findAllUsers() {
        return serviceLayerObj.getAllUsers();
    }

    @GetMapping("/findNames")
    public List<String> findNames() {
        return serviceLayerObj.findNames();
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        return serviceLayerObj.sayHello();
    }
}