package com.eda.frontend.features.regisration.facade;

import com.eda.frontend.features.registration.domain.UserRegistrationModel;
import com.eda.frontend.features.registration.service.RegistrationService;
import com.eda.frontend.features.registration.service.transformer.UserRegistrationDataTransformer;
import com.eda.frontend.features.registration.web.domain.UserRegistrationViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationFacade {

    @Autowired
    private RegistrationService service;

    @Autowired
    private UserRegistrationDataTransformer transformer;

    public void send(UserRegistrationViewModel viewModel) {
        UserRegistrationModel model = transformer.transform(viewModel);
        service.send(model);
    }

}
