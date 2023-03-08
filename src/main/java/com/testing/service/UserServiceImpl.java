package com.testing.service;

import com.testing.models.User;
import com.testing.dao.UserDAO;
import com.testing.util.exceptions.NotFoundInDataBaseException;

public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean checkUserExist(User user){
        try{
            userDAO.getUserByName(user.getName());
        }catch (NotFoundInDataBaseException e){
            return false;
        }
        return true;
    }


}
