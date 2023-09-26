package org.accio.FirstAPIProject;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RepositoryLayer {
    Map<Integer, UserInfo> userInfoDB = new HashMap<>();

    public void addUserToDB(UserInfo obj) {
        userInfoDB.put(obj.getUserId(), obj);
    }

    public UserInfo getUserInfo(Integer userId) {
        return userInfoDB.get(userId);
    }

    public List<UserInfo> getAllUsers() {
        return new ArrayList<>(userInfoDB.values());
    }
}