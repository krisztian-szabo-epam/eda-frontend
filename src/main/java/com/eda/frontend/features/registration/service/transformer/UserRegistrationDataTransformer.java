package com.eda.frontend.features.registration.service.transformer;

import com.eda.frontend.features.registration.domain.UserRegistrationModel;
import com.eda.frontend.features.registration.web.domain.UserRegistrationViewModel;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDataTransformer {

    public UserRegistrationModel transform(UserRegistrationViewModel model) {
        return new UserRegistrationModel(model.getUserName(), model.getEmailAddress(), model.getPassword());
    }

}
