package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private List<User> getData(){
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setId(1l);
        user1.setAge(20);
        user1.setName("john");
        User user2 = new User();
        user2.setId(2l);
        user2.setAge(30);
        user2.setName("Terry");
        list.add(user1);
        list.add(user2);
       return  list;
    }
    @GetMapping("/getAllUsers")
    @ResponseStatus(HttpStatus.OK)
    public Object getAllUsers(){
        return getData();
    }
    @GetMapping("/getUser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser(@PathVariable("id") String id){
        if(null==id){
            return null;
        }
        List<User> list = getData();
        return list.stream().filter( user -> id.equals(user.getId().toString()) ).findAny().get();
    }
}
