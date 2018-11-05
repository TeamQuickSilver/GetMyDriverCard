package com.quicksilver.getmydrivercard;

import com.quicksilver.getmydrivercard.repositories.ApplicationRepository;
import com.quicksilver.getmydrivercard.services.ApplicationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceImplTest {

    @Mock
    ApplicationRepository mockRepository;

    @InjectMocks
    ApplicationServiceImpl applicationService;


    @Test
    public void getAllByUserEmailOrderById() {
//        //Arrange
//        Mockito.when(applicationService.getAllByUserEmailOrderById(TRUE_EMAIL))
//                .thenReturn();
//
//        // Act
//        List<Application> result = applicationService.getAllByUserEmailOrderById(TRUE_EMAIL);
//
//        // Assert
//        Assert.assertEquals();
    }

//    @Test
//    public void getAllByStatus() {
//        //Arrange
//        Mockito.when(userService.getByEmail(TRUE_EMAIL))
//                .thenReturn(user);
//
//        // Act
//        User result = userService.getByEmail(TRUE_EMAIL);
//
//        // Assert
//        Assert.assertEquals(user, result);
//    }
//
//    @Test
//    public void getAllOrderByDateOfSubmission() {
//        //Arrange
//        Mockito.when(userService.getByEmail(TRUE_EMAIL))
//                .thenReturn(user);
//
//        // Act
//        User result = userService.getByEmail(TRUE_EMAIL);
//
//        // Assert
//        Assert.assertEquals(user, result);
//    }
//
//    @Test
//    public void getAllOrderByPersonName() {
//        //Arrange
//        Mockito.when(userService.getByEmail(TRUE_EMAIL))
//                .thenReturn(user);
//
//        // Act
//        User result = userService.getByEmail(TRUE_EMAIL);
//
//        // Assert
//        Assert.assertEquals(user, result);
//    }
//
//    @Test
//    public void getById() {
//        //Arrange
//        Mockito.when(userService.getByEmail(TRUE_EMAIL))
//                .thenReturn(user);
//
//        // Act
//        User result = userService.getByEmail(TRUE_EMAIL);
//
//        // Assert
//        Assert.assertEquals(user, result);
//    }
}
