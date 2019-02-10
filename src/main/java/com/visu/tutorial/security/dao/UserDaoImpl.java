package com.visu.tutorial.security.dao;

import org.springframework.stereotype.Repository;
import com.visu.tutorial.security.model.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private final Map<String, User> users;

    public UserDaoImpl() {
        users = new HashMap<>();
        users.put("user", new User("user", "password", Arrays.asList("ROLE_USER")));
        users.put("admin", new User("admin", "password", Arrays.asList("ROLE_USER", "ROLE_ADMIN")));
    }

    @Override
    public User findByName(String name) {
        return users.get(name);
    }
}
