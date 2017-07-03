package com.eda.frontend.features.registration.web.controller;

import com.eda.frontend.features.regisration.facade.UserRegistrationFacade;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    private static final String BASE_CONTROLLER_URL = "/registration";
    public static final String BASE_VIEW_NAME = "registration";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRegistrationFacade facade;

    @Test
    public void indexShouldLoadThePageWithDefaultTemplate() throws Exception {
        // GIVEN
        MockHttpServletRequestBuilder content = get(BASE_CONTROLLER_URL).accept(MediaType.TEXT_PLAIN);

        // WHEN
        ResultActions result = mockMvc.perform(content);

        // THEN
        result.andExpect(status().isOk());
        result.andExpect(view().name(BASE_VIEW_NAME));
    }

    @Test
    public void registrationWhenEmailAddressIsShortShouldDisplayErrorMessage() throws Exception {
        // GIVEN
        MockHttpServletRequestBuilder content = post(BASE_CONTROLLER_URL);
        content.param("emailAddress", "")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);

        // WHEN
        ResultActions result = mockMvc.perform(content);

        // THEN
        result.andExpect(content().string(Matchers.containsString("Email field is mandatory!")));
    }

    @Test
    public void registrationWhenEmailAddressIsNotValidShouldDisplayErrorMessage() throws Exception {
        // GIVEN
        MockHttpServletRequestBuilder content = post(BASE_CONTROLLER_URL);
        content.param("emailAddress", "invalidEmailAddress")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);

        // WHEN
        ResultActions result = mockMvc.perform(content);

        // THEN
        result.andExpect(content().string(Matchers.containsString("Email address is not valid!")));
    }

    @Test
    public void registrationWhenPasswordIsNotEqualToRepassworFieldShouldDisplayErrorMessage() throws Exception {
        // GIVEN
        MockHttpServletRequestBuilder content = post(BASE_CONTROLLER_URL);
        content.param("password", "password")
                .param("rePassword", "notpassword")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);

        // WHEN
        ResultActions result = mockMvc.perform(content);

        // THEN
        result.andExpect(content().string(Matchers.containsString("Passwords must be the same!")));
    }

    @Test
    public void registrationWhenPasswordIsShortShouldDisplayErrorMessage() throws Exception {
        // GIVEN
        MockHttpServletRequestBuilder content = post(BASE_CONTROLLER_URL);
        content.param("password", "short")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);

        // WHEN
        ResultActions result = mockMvc.perform(content);

        // THEN
        result.andExpect(content().string(Matchers.containsString("Password must be at least 8 character!")));
    }

    @Test
    public void registerWhenUserNameIsShortShouldDisplayErrorMessage() throws Exception {
        // GIVEN
        MockHttpServletRequestBuilder content = post(BASE_CONTROLLER_URL);
        content.param("userName", "short")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);

        // WHEN
        ResultActions result = mockMvc.perform(content);

        // THEN
        result.andExpect(content().string(Matchers.containsString("Username must be between 6 and 32 character!")));
    }

    @Test
    public void registerWhenUserNameIsLongShouldDisplayErrorMessage() throws Exception {
        // GIVEN
        MockHttpServletRequestBuilder content = post(BASE_CONTROLLER_URL);
        content.param("userName", "123456789012345678901234567890123")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);

        // WHEN
        ResultActions result = mockMvc.perform(content);

        // THEN
        result.andExpect(content().string(Matchers.containsString("Username must be between 6 and 32 character!")));
    }
}
