package ru.yandex.code.service.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.yandex.code.service.User;
import ru.yandex.code.service.UserRepository;
import ru.yandex.code.service.UserService;

public class UserServiceTest {

    @Test
    void testGetUserName() {
        // Arrange: create mock and define behavior
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        when(mockRepository.findById(1L)).thenReturn(new User(1L, "Alice"));

        UserService userService = new UserService(mockRepository);

        // Act
        String result = userService.getUserName(1L);

        // Assert
        assertEquals("Alice", result);

        // Verify interaction with mock
        verify(mockRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserName_UserNotFound() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        when(mockRepository.findById(2L)).thenReturn(null);

        UserService userService = new UserService(mockRepository);

        assertEquals("Unknown", userService.getUserName(2L));
    }
}
