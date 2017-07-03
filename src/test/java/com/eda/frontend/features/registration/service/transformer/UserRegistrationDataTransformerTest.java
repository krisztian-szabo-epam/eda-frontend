package com.eda.frontend.features.registration.service.transformer;

import com.eda.frontend.features.registration.domain.UserRegistrationModel;
import com.eda.frontend.features.registration.web.domain.UserRegistrationViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegistrationDataTransformerTest {

    @Autowired
    private UserRegistrationDataTransformer underTest;

    private UserRegistrationViewModel userRegistrationViewModel;

    @Before
    public void setUp() {
        userRegistrationViewModel = new UserRegistrationViewModel();
        userRegistrationViewModel.setUserName("username");
        userRegistrationViewModel.setPassword("password");
        userRegistrationViewModel.setEmailAddress("email");
    }

    @Test
    public void transformShouldCreateAnImmutableUserRegistrationData() throws Exception {
        // GIVEN in setup

        // WHEN
        UserRegistrationModel actual = underTest.transform(userRegistrationViewModel);

        // THEN
        Assert.assertEquals("username", actual.getUserName());
        Assert.assertEquals("password", actual.getPassword());
        Assert.assertEquals("email", actual.getEmailAddress());
    }

}
