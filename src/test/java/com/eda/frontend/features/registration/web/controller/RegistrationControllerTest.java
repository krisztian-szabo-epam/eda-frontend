package com.eda.frontend.features.registration.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    private static final String BASE_URL = "/registration";
    public static final String BASE_VIEW_NAME = "registration";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void index() throws Exception {
        MockHttpServletRequestBuilder content = get(BASE_URL).accept(MediaType.TEXT_PLAIN);
        mockMvc.perform(content)
                .andExpect(status().isOk())
                .andExpect(view().name(BASE_VIEW_NAME));
    }

}
