package com.quicksilver.getmydrivercard;

import com.quicksilver.getmydrivercard.entities.Role;
import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.repositories.UserRepository;
import com.quicksilver.getmydrivercard.services.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTests {
    private static final String TRUE_EMAIL = "samuil_96@mail.com";
    private static final String TRUE_PASSWORD = "22334455";
    private static final String FALSE_EMAIL = "false@abv.bg";

    @Mock
    UserRepository mockRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserServiceImpl userService;


    User user = new User(TRUE_EMAIL, TRUE_PASSWORD);

    @Test
    public void getByEmail_ShouldReturnMatchingUser_WhenMatchingExist() {
        //Arrange
        Mockito.when(userService.getByEmail(TRUE_EMAIL))
                .thenReturn(user);

        // Act
        User result = userService.getByEmail(TRUE_EMAIL);

        // Assert
        Assert.assertEquals(user, result);
    }

    @Test
    public void getByEmail_ShouldReturnNull_WhenMatchingNotExist() {
        //Arrange
        Mockito.when(userService.getByEmail(FALSE_EMAIL))
                .thenReturn(null);

        // Act
        User result = userService.getByEmail(FALSE_EMAIL);

        // Assert
        Assert.assertNull(result);
    }

    @Test
    public void register_ShouldReturnUser_WhenSave() {
        //Arrange
        Mockito.when(mockRepository.save(user))
                .thenReturn(user);

        // Act
        User result = userService.register(user);

        // Assert
        Assert.assertEquals(user, result);
    }

    @Test
    public void login_ShouldReturnTrue_WhenMatchingExist() {
        //Arrange
        Mockito.when(mockRepository.findFirstByEmail(user.getEmail()))
                .thenReturn(user);

        Mockito.when(userService.login(user))
                .thenReturn(true);

        // Act
        boolean result = userService.login(user);

        // Assert
        Assert.assertTrue(result);
    }
}
