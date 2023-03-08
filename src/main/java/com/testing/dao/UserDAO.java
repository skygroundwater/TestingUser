package com.testing.dao;

import com.testing.models.User;

import java.util.List;

public interface UserDAO {

    User getUserByName(String name);

    List<User> findAllUsers();

    User save(User user);

    User delete(User user);
}
