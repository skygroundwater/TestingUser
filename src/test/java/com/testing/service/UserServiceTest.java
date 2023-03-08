package com.testing.service;

import com.testing.dao.UserDAOImpl;
import com.testing.models.User;
import com.testing.util.exceptions.NotFoundInDataBaseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDAOImpl userDAO;

    @InjectMocks
    private UserServiceImpl userService;

    private static final User IVAN = new User("Ivan");

    private static final User MEFODIY = new User("Mefodiy");



    @Test
    void shouldReturnTrueGetUserByName() {
        when(userDAO.getUserByName(IVAN.getName())).thenReturn(IVAN);
        Assertions.assertTrue(userService.checkUserExist(IVAN));
    }

    @Test
    void shouldThrowExceptionNotFoundInDataBase(){
        when(userDAO.getUserByName(MEFODIY.getName())).thenThrow(NotFoundInDataBaseException.class);
        Assertions.assertFalse(userService.checkUserExist(MEFODIY));
    }
}