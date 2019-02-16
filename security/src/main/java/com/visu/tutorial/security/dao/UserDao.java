package com.visu.tutorial.security.dao;

import com.visu.tutorial.security.model.User;

public interface UserDao {
    User findByName(String name);
}
