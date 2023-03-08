package com.testing.dao;


import com.testing.models.User;
import com.testing.util.exceptions.AlreadyAddedException;
import com.testing.util.exceptions.NotFoundInDataBaseException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{


    public static final String THAT_USER = "That user";

    private final List<User> users;

    public UserDAOImpl(){
        users = new ArrayList<>(List.of(new User("Aleksey"), new User("Semen"),
                new User("Arseniy"), new User("Ivan")));
    }

    @Override
    public User getUserByName(String name){
        return users.stream().filter(user -> user.getName().equals(name))
                .findAny().orElseThrow(() -> new NotFoundInDataBaseException(THAT_USER));
    }

    @Override
    public List<User> findAllUsers(){
        return users;
    }

    @Override
    public User save(User user) {
        if(users.contains(user)) throw new AlreadyAddedException(THAT_USER);
        users.add(user);
        return user;
    }

    @Override
    public User delete(User user) {
        if(!users.contains(user)) throw new NotFoundInDataBaseException(THAT_USER);
        users.remove(user);
        return user;
    }
}
