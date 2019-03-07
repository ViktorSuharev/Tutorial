package com.visu.persistence;

import com.visu.persistence.dao.UserRepository;
import com.visu.persistence.model.Role;
import com.visu.persistence.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testGetUserById() {
        User persisted = new User();
        persisted.setName("name");


        Role role1 = new Role();
        role1.setName("ADMIN");
        Role role2 = new Role();
        role2.setName("USER");

        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        roles.add(role2);

        persisted.setRoles(roles);

        BigInteger userId = (BigInteger) entityManager.persistAndGetId(persisted);
        User saved = userRepository.findById(userId).get();

        Assert.assertEquals(getRoles(persisted), getRoles(saved));
    }

    private Set<String> getRoles(User user) {
        return user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}