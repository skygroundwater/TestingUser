package com.testing.dao;

import com.testing.models.User;
import com.testing.util.exceptions.NotFoundInDataBaseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

class UserDAOTest {

    private static final UserDAOImpl userDAO = new UserDAOImpl();

    private static final User IVAN = new User("Ivan");

    private static final User ALEKSEY = new User("Aleksey");

    private static final User ARSENIY = new User("Arseniy");

    private static final User SEMEN = new User("Semen");

    private static final User MEFODIY = new User("Mefodiy");

    private static List<User> wholeListUsersForTesting;

    @BeforeAll
    public static void fillWholeListUsersForTesting() {
        wholeListUsersForTesting = new ArrayList<>(List.of(ALEKSEY, SEMEN, ARSENIY, IVAN));
    }

    @Test
    public void shouldReturnTrueAfterCompareUsersByName() {
        Assertions.assertEquals(IVAN, userDAO.getUserByName(IVAN.getName()));
    }

    @Test
    public void shouldThrowExceptionAfterSearchingUsersByName() {
        Assertions.assertThrows(NotFoundInDataBaseException.class, () -> userDAO.getUserByName(MEFODIY.getName()));
    }

    @Test
    public void shouldCompareTestingListAndActualList(){
        Assertions.assertEquals(wholeListUsersForTesting, userDAO.findAllUsers());
    }


}