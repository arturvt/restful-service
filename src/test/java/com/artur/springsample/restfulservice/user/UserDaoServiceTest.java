package com.artur.springsample.restfulservice.user;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserDaoServiceTest {

    private UserDaoService service = new UserDaoService();

    @Test
    public void findAll() {
        assertTrue(service.findAll().size() > 0);
    }

    @Test
    public void save() {
        int initialSize = service.findAll().size();
        User u = new User(18, "Artur", new Date());
        service.save(u);
        assertTrue(service.findAll().size() > initialSize);
    }

    @Test
    public void findById() {

    }
}