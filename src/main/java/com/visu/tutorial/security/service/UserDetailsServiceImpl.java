package com.visu.tutorial.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.visu.tutorial.security.dao.UserDao;
import com.visu.tutorial.security.model.User;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = this.userDao.findByName(name);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRoles().toArray(new String[0])));
    }

}