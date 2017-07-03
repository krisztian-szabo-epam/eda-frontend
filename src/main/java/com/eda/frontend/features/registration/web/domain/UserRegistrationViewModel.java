package com.eda.frontend.features.registration.web.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class UserRegistrationViewModel {

    @Size(min = 6, max = 32, message = "Username must be between {min} and {max} character!")
    private String userName;

    @NotEmpty(message = "Email field is mandatory!")
    @Email(message = "Email address is not valid!")
    private String emailAddress;

    @Size(min = 8, message = "Password must be at least {min} character!")
    private String password;
    private String rePassword;

    private boolean samePassword;

    public boolean isSamePassword() {
        return samePassword;
    }

    public void setSamePassword(boolean samePassword) {
        this.samePassword = samePassword;
    }

    public UserRegistrationViewModel() {};

    public UserRegistrationViewModel(String userName, String password, String rePassword, String emailAddress) {
        this.userName = userName;
        this.password = password;
        this.rePassword = rePassword;
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
