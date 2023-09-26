package Alternative;

import org.accio.FirstAPIProject.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class APIsClass {
    HashMap<Integer, UserInfo> userInfoDB = new HashMap<>();

    @PostMapping("/addUserViaReqBody")
    public String addUserToDB(@RequestBody UserInfo obj) {
        userInfoDB.put(obj.getUserId(), obj);

        return "The user has been added via Postman obj";
    }

    @PostMapping("/addUser")
    public String addUserToDB(@RequestParam("userId") Integer userId, @RequestParam("name") String name, @RequestParam("age") Integer age, @RequestParam("emailId") String emailId) {
        userInfoDB.put(userId, new UserInfo(userId, name, age, emailId));

        return "User has been added to the DB successfully";
    }

    @GetMapping("/getUser/{userId}")
    public UserInfo getUserInfo(@PathVariable("userId") Integer userId) {
        return userInfoDB.get(userId);
    }

    @GetMapping("/getUserInfoByUserId")
    public UserInfo getUserInfoByUserId(@RequestParam("userId") Integer userId) {
        return userInfoDB.get(userId);
    }

    @GetMapping("/getUsers/{minAge}/{maxAge}")
    public List<UserInfo> getUsers(@PathVariable("minAge") Integer minAge, @PathVariable("maxAge") Integer maxAge) {
        List<UserInfo> list = new ArrayList<>();

        for (UserInfo obj : userInfoDB.values())
            if (obj.getAge() >= minAge && obj.getAge() <= maxAge)
                list.add(obj);

        return list;
    }

    @GetMapping("/findAllUsers")
    public List<UserInfo> findAllUsers() {
        return new ArrayList<>(userInfoDB.values());
    }

    @GetMapping("/findNames")
    public List<String> findNames() {
        List<String> list = new ArrayList<>();
        for (UserInfo obj : userInfoDB.values())
            list.add(obj.getName());
        
        return list;
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello World!";
    }
}