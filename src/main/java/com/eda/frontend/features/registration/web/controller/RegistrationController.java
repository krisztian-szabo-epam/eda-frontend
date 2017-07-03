package com.eda.frontend.features.registration.web.controller;

import com.eda.frontend.features.regisration.facade.UserRegistrationFacade;
import com.eda.frontend.features.registration.web.domain.UserRegistrationViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    public static final String BASE_TEMPLATE_NAME = "registration";

    @Autowired
    private UserRegistrationFacade facade;

    @ModelAttribute
    public void addEmptyModelObject(Model model) {
        model.addAttribute("data", new UserRegistrationViewModel());
    }

    @GetMapping
    public String index() {
        return BASE_TEMPLATE_NAME;
    }

    @PostMapping
    public String registration(@ModelAttribute("data") @Valid UserRegistrationViewModel viewModel, Errors errors) {
        if (existPasswords(viewModel) && isNotSamePassword(viewModel)) {
            errors.rejectValue("samePassword", "password.no.match", "Passwords must be the same!");
        } else if(! errors.hasErrors()) {
            facade.send(viewModel);
        }
        return BASE_TEMPLATE_NAME;
    }

    private boolean existPasswords(@ModelAttribute("data") @Valid UserRegistrationViewModel viewModel) {
        return viewModel.getRePassword() != null && viewModel.getPassword() != null;
    }

    private boolean isNotSamePassword(@ModelAttribute("data") @Valid UserRegistrationViewModel viewModel) {
        return ! viewModel.getRePassword().equals(viewModel.getPassword());
    }

}
