package by.stormnet.web;

import by.stormnet.web.helpers.LamodaHomeHelper;
import by.stormnet.web.helpers.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.*;

public class LamodaTests {
    private LamodaHomeHelper lamodaHomeHelper = new LamodaHomeHelper();
    private LoginHelper loginHelper = new LoginHelper();

    @BeforeClass
    public void setUp() {
        lamodaHomeHelper.openLamodaHomeHelper();
    }

    @Test (priority = 1, groups = {"registrationValidation"})
    public void validationWithEmptyFields() {
        loginHelper.clickRegister();
        Assert.assertTrue(loginHelper.validateAllFields("Это поле необходимо заполнить."));
    }

    @Test (priority = 2, groups = {"registrationValidation"})
    public void validationInvalidEmail(){
        loginHelper.clickRegister();
        Assert.assertTrue(loginHelper.validateOnlyEmail("Пожалуйста, введите действительный адрес электронной почты. Например, johndoe@domain.com", "test"));
    }

    @Test (priority = 3, groups = {"registrationValidation"})
    public void validationShortPassword(){
        loginHelper.clickRegister();
        Assert.assertTrue(loginHelper.validateBothPasswordd("Минимальная длина пароля 6 символов"));
    }
    @Test (priority = 4, groups = {"registrationValidation"})
    public void validationDifferentPasswords(){
        loginHelper.clickRegister();
        Assert.assertTrue(loginHelper.validateConfirmPassword("Пожалуйста, убедитесь, что Ваши пароли совпадают"));
    }

    @Test (priority = 5, groups = {"registrationValidation"})
    public void validationLogin(){
        Assert.assertTrue(loginHelper.validationForLogin("Неверный адрес e-mail или пароль. Проверьте, нет ли опечаток.","automation_courses@mail.ru", "123456"));
    }

    @AfterMethod (onlyForGroups = {"registrationValidation"})
    public void tearDownValidationRegistration(){
        loginHelper.closeRegistrationPopUp();
    }

    @AfterClass
    public void tearDown() {
        lamodaHomeHelper.quite();
    }
}

