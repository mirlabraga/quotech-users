package com.quotech.quotechusers;

import static org.assertj.core.api.Assertions.assertThat;

import com.quotech.quotechusers.models.User;
import com.quotech.quotechusers.models.UserId;
import com.quotech.quotechusers.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository users;

    @Test
    public void testFindAll() {
        UserId userId = new UserId("quotech", "nick");
        User user = new User(userId,"Nick Melis", "nick@quotech.io", "CTO");
        entityManager.persist(user);

        Iterable<User> usersAll = users.findAll();
        usersAll.iterator().next().getName();

        assertThat(usersAll).extracting(User::getName).containsOnly("Nick Melis");

    }

    @Test
    public void testUpdate() {
        UserId userId = new UserId("quotech", "mirla");
        User user = new User(userId,"Mirla Chucre", "mirlabraga@gmail.com", "DEV");
        entityManager.persist(user);

        Iterable<User> usersAll = users.findAll();
        usersAll.iterator().next().getName();

        assertThat(usersAll).extracting(User::getName).containsOnly(user.getName());

        user.setName("Mirla Braga");
        entityManager.merge(user);
        assertThat(usersAll).extracting(User::getName).containsOnly("Mirla Braga");
        assertThat(usersAll).extracting(User::getEmail).containsOnly("mirlabraga@gmail.com");

    }
}
