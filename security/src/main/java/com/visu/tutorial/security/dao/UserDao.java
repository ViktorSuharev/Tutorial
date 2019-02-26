package com.visu.tutorial.security.dao;

import com.visu.tutorial.security.model.User;

import java.math.BigInteger;

public interface UserDao {
    User findByUsername(String name);
}
