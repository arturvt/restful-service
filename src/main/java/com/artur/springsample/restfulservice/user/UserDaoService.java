package com.artur.springsample.restfulservice.user;

import com.artur.springsample.restfulservice.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        int indexId = 1;
        users.add(new User(indexId++, "Adam", new Date()));
        users.add(new User(indexId++, "Eve", new Date()));
        users.add(new User(indexId++, "Jack", new Date()));
        users.add(new User(indexId++, "Doug", new Date()));
        users.add(new User(indexId, "Michael", new Date()));
    }

    List<User> findAll() {
        return users;
    }

    User save(User user) {
        users.add(user);
        user.setId(users.size() + 1);
        return user;
    }

    public User findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow(ResourceNotFoundException::new);
    }
}
