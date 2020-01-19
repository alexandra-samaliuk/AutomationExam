package by.stormnet.web.helpers;

import by.stormnet.web.pages.LoginPage;

public class LoginHelper extends AbsractHelper {
    LoginPage loginPage = new LoginPage();

    public void login(String email, String password){
        loginPage.clickLoginButton();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginBtnInPopUp();
    }

    public void clickRegister() {
        loginPage.clickLoginButton();
        loginPage.clickCreateAccountButton();
    }

    public boolean validateAllFields(String errorMessage) {
        loginPage.clickSubmitRegistrationButton();
        if (validateEmailField(errorMessage) && validatePasswordField(errorMessage) && validateConfirmPasswordField(errorMessage) && validateNameField(errorMessage)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateEmailField(String errorMessage) {
        if (loginPage.getErrorForEmail().compareTo(errorMessage) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validatePasswordField(String errorMessage) {
        if (loginPage.getErrorForPassword().compareTo(errorMessage) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateConfirmPasswordField(String errorMessage) {
        if (loginPage.getErrorForConfirmPassword().compareTo(errorMessage) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateNameField(String errorMessage) {
        if (loginPage.getErrorForName().compareTo(errorMessage) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateOnlyEmail(String errorMessage, String email) {
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField("Test1234");
        loginPage.fillConfirmPasswordField("Test1234");
        loginPage.fillNameField("Test");
        loginPage.clickSubmitRegistrationButton();
        if (validateEmailField(errorMessage)) {
            return true;
        } else {
            return false;
        }
    }

    public void closeRegistrationPopUp() {
        loginPage.clickCloseRegistrationPopUp();
    }

    public boolean validateConfirmPassword(String errorMessage) {
        loginPage.fillEmailField("email");
        loginPage.fillPasswordField("Test1234");
        loginPage.fillConfirmPasswordField("Test123");
        loginPage.fillNameField("Test");
        if (validateConfirmPasswordField(errorMessage)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateBothPasswordd(String errorMessage) {
        loginPage.fillEmailField("email");
        loginPage.fillPasswordField("1234");
        loginPage.fillConfirmPasswordField("1234");
        loginPage.fillNameField("Test");
        if (validatePasswordField(errorMessage) && validateConfirmPasswordField(errorMessage)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validationForLogin(String errorMessage, String email, String password){
        login(email, password);
        if (loginPage.getErrorLoginPopUp().compareTo(errorMessage) == 0) {
            return true;
        } else {
            return false;
        }
    }

}
