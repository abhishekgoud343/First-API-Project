package org.accio.FirstAPIProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceLayer {
    @Autowired
    private RepositoryLayer repositoryLayerObj;

    public String addUserToDB(UserInfo obj) {
        repositoryLayerObj.addUserToDB(obj);

        return "The user has been added via Postman object";
    }

    public String addUserToDB(Integer userId, String name, Integer age, String emailId) {
        repositoryLayerObj.addUserToDB(new UserInfo(userId, name, age, emailId));

        return "User has been added to the DB successfully";
    }

    public UserInfo getUserInfo(Integer userId) {
        return repositoryLayerObj.getUserInfo(userId);
    }

    public List<UserInfo> getUsersFilterByAge(Integer minAge, Integer maxAge) {
        List<UserInfo> allUsers = repositoryLayerObj.getAllUsers();

        List<UserInfo> list = new ArrayList<>();
        for (UserInfo obj : allUsers)
            if (obj.getAge() >= minAge && obj.getAge() <= maxAge) list.add(obj);

        return list;
    }

    public List<UserInfo> getAllUsers() {
        return repositoryLayerObj.getAllUsers();
    }

    public List<String> findNames() {
        List<UserInfo> allUsers = repositoryLayerObj.getAllUsers();

        List<String> list = new ArrayList<>();
        for (UserInfo obj : allUsers)
            list.add(obj.getName());

        return list;
    }

    public String sayHello() {
        return "Hello World!";
    }
}
