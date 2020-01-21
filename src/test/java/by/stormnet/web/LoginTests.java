package by.stormnet.web;

import by.stormnet.web.helpers.LamodaHomeHelper;
import by.stormnet.web.helpers.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests {
    private LamodaHomeHelper lamodaHomeHelper = new LamodaHomeHelper();
    private LoginHelper loginHelper = new LoginHelper();

    @BeforeClass
    public void setUp() {
        lamodaHomeHelper.openLamodaHomeHelper();
    }

    @Test(priority = 401)
    public void validationWithEmptyFields() {
        loginHelper.clickRegister();
        Assert.assertTrue(loginHelper.validateAllFields("Это поле необходимо заполнить."));
    }

    @Test(priority = 402)
    public void validationInvalidEmail() {
        loginHelper.clickRegister();
        Assert.assertTrue(loginHelper.validateOnlyEmail("Пожалуйста, введите действительный адрес электронной почты. Например, johndoe@domain.com", "test"));
    }

    @Test(priority = 403)
    public void validationShortPassword() {
        loginHelper.clickRegister();
        Assert.assertTrue(loginHelper.validateBothPasswordd("Минимальная длина пароля 6 символов", "123"));
    }

    @Test(priority = 404)
    public void validationDifferentPasswords() {
        loginHelper.clickRegister();
        Assert.assertTrue(loginHelper.validateConfirmPassword("Пожалуйста, убедитесь, что Ваши пароли совпадают"));
    }

    @Test(priority = 405)
    public void validationInvalidSymbolsPassword() {
        loginHelper.clickRegister();
        Assert.assertTrue(loginHelper.validateIncorrectSymbolsPassword("В поле присутствуют некорректные символы: пробелы", "123 123"));
    }

    @AfterMethod
    public void tearDownValidationRegistration() {
        loginHelper.closeRegistrationPopUp();
    }

}

