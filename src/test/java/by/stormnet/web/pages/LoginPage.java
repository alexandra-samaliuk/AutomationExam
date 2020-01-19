package by.stormnet.web.pages;

public class LoginPage extends AbstractPage {
    private String loginButton = "//span[@class = 'link user-nav__link js-auth-button']";
    private String createAccount = "//span[@class = 'link_blue login-form__register link']";
    private String emailField = "//form[contains(@style, 'block')]//input[@name = 'email']";
    private String passwordField = "//form[contains(@style, 'block')]//input[@name = 'password']";
    private String confirmPasswordField = "//input[@name = 'password2']";
    private String nameField = "//input[@name = 'first_name']";
    private String submitRegistration = "//button[@class= 'button button_blue js-registration-button']";
    private String errorForEmail = "//div[@data-form-error='email' and @style = 'display: block;']";
    private String errorForPassword = "//div[@data-form-error='password' and @style = 'display: block;']";
    private String errorForConfirmPassword = "//div[@data-form-error='password2' and @style = 'display: block;']";
    private String errorForName = "//div[@data-form-error='first_name' and @style = 'display: block;']";
    private String closeRegistrationPopUp = "//div[contains(@class, 'visible')]//span[ @class= 'popup__close']";
    private String login = "//button[@class= 'button button_blue js-login-button login-form__login']";
    private String errorLoginPopUp = "//div[@class= 'login-form__error js-form-error-message']";


    public void fillEmailField(String email) {
        getElement(emailField).clear();
        getElement(emailField).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        getElement(passwordField).clear();
        getElement(passwordField).sendKeys(password);
    }

    public void fillConfirmPasswordField(String password) {
        getElement(confirmPasswordField).clear();
        getElement(confirmPasswordField).sendKeys(password);
    }

    public void fillNameField(String name) {
        getElement(nameField).clear();
        getElement(nameField).sendKeys(name);
    }

    public void clickLoginButton() {
        waitForElementClickable(getElementBy(loginButton));
        getElement(loginButton).click();
    }

    public void clickCreateAccountButton() {
        waitForElementClickable(getElementBy(createAccount));
        getElement(createAccount).click();
    }

    public void clickSubmitRegistrationButton() {
        waitForElementClickable(getElementBy(submitRegistration));
        getElement(submitRegistration).click();
    }

    public String getErrorForEmail() {
        waitForElementVisible(getElementBy(errorForEmail));
        return getElement(errorForEmail).getText();
    }

    public String getErrorForPassword() {
        waitForElementVisible(getElementBy(errorForPassword));
        return getElement(errorForPassword).getText();
    }

    public String getErrorForConfirmPassword() {
        waitForElementVisible(getElementBy(errorForConfirmPassword));
        return getElement(errorForConfirmPassword).getText();
    }

    public String getErrorForName() {
        waitForElementVisible(getElementBy(errorForName));
        return getElement(errorForName).getText();
    }

    public String getErrorLoginPopUp() {
        waitForElementVisible(getElementBy(errorLoginPopUp));
        return getElement(errorLoginPopUp).getText();
    }

    public void clickCloseRegistrationPopUp() {
        getElement(closeRegistrationPopUp).click();
    }

    public void clickLoginBtnInPopUp() {
        waitForElementClickable(getElementBy(login));
        getElement(login).click();
    }

}
