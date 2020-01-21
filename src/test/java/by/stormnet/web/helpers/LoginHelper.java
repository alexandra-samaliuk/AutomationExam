package by.stormnet.web.helpers;

import by.stormnet.web.pages.LoginPage;

public class LoginHelper extends AbsractHelper {
    LoginPage loginPage = new LoginPage();

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
        return (validateEmailField(errorMessage));
    }

    public void closeRegistrationPopUp() {
        loginPage.clickCloseRegistrationPopUp();
    }

    public boolean validateConfirmPassword(String errorMessage) {
        loginPage.fillEmailField("email");
        loginPage.fillPasswordField("Test1234");
        loginPage.fillConfirmPasswordField("Test123");
        loginPage.fillNameField("Test");
        return validateConfirmPasswordField(errorMessage);
    }

    public boolean validateBothPasswordd(String errorMessage, String password) {
        loginPage.fillEmailField("email");
        loginPage.fillPasswordField(password);
        loginPage.fillConfirmPasswordField(password);
        loginPage.fillNameField("Test");
        if (validatePasswordField(errorMessage) && validateConfirmPasswordField(errorMessage)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateIncorrectSymbolsPassword(String errorMessage, String password) {
        loginPage.fillPasswordField(password);
        loginPage.fillConfirmPasswordField(password);
        return validatePasswordField(errorMessage);
    }

    public boolean validateIncorrectName(String errorMessage, String name) {
        loginPage.fillNameField(name);
        loginPage.fillEmailField("email");
        return validateNameField(errorMessage);
    }
}
