package com.visu.tutorial.security.dao;

import com.visu.tutorial.security.model.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import com.visu.tutorial.security.model.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private final Map<String, User> users;

    public UserDaoImpl() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(encoder.encode("admin"));
        admin.setRoles(Collections.singleton(Role.ROLE_ADMIN));

        User user = new User();
        user.setUsername("user");
        user.setPassword(encoder.encode("user"));
        user.setRoles(Collections.singleton(Role.ROLE_USER));

        users = new HashMap<>();
        users.put(admin.getUsername(), admin);
        users.put(user.getUsername(), user);
    }

    @Override
    public User findByUsername(String username) {
        return users.get(username);
    }
}
