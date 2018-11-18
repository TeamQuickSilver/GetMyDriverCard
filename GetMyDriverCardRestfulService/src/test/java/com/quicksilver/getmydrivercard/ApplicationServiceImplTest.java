package com.quicksilver.getmydrivercard;

import com.quicksilver.getmydrivercard.entities.*;
import com.quicksilver.getmydrivercard.repositories.ApplicationRepository;
import com.quicksilver.getmydrivercard.services.ApplicationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceImplTest {

//    @Mock
//    ApplicationRepository mockRepository;
//
//    @InjectMocks
//    ApplicationServiceImpl applicationService;
//
//    private static Date date = new Date();
//
//    private static Date issuedOn = new Date();
//
////    private static Date dateOfBird = (Timestamp) new Date("1994-05-11 00:00:00");
//
//    private static Address address = new Address("Sofia", "Sofia", "Moskovska Str.22");
//
//    private static User user = new User("samuilzahariev96@abv.bg", "123456789");
//
//    private static DrivingLicense drivingLicense = new DrivingLicense(643232190L, 622098695L, issuedOn, "MVR LOVECH");
//
//    private static IdentityCard identityCard = new IdentityCard(622098695L, 9610098695L, date, "MVR LOVECH", "Georgi", "Ivanov", "Petkov", address);
//
//    private static Person person = new Person(identityCard, 892123211L, "samuil_1996@abv.bg", drivingLicense);
//
//    private static List<Application> defaultMockRepositoryContent = Arrays.asList(
//
//            new Application(),
//            new Application()
//    );

//    @Test
//    public void getAllByUserEmailOrderById() {
//        //Arrange
//        Mockito.when(mockRepository.findAllByUserEmail("samuil_1996@abv.bg"))
//                .thenReturn(defaultMockRepositoryContent);
//
//        // Act
//        List<Application> result = applicationService.getAllByUserEmail("samuil_1996@abv.bg");
//
//        // Assert
//        Assert.assertEquals(result, "samuil_1996@abv.bg");
//    }

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
}
