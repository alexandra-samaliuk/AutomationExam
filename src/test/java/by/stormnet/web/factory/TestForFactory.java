package by.stormnet.web.factory;

import by.stormnet.web.helpers.LamodaHomeHelper;
import by.stormnet.web.helpers.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestForFactory {
    private LamodaHomeHelper lamodaHomeHelper = new LamodaHomeHelper();
    private LoginHelper loginHelper = new LoginHelper();
    String name;

    public TestForFactory(String name) {
        this.name = name;
    }

    @BeforeClass
    public void setUp() {
        lamodaHomeHelper.openLamodaHomeHelper();
    }

    @Test
    public void validationInvalidName() {
        loginHelper.clickRegister();
        Assert.assertTrue(loginHelper.validateIncorrectName("В поле введены некорректные символы. Можно вводить буквы и символы: ` ~ - '", name));
    }

    @AfterMethod
    public void tearDownValidationRegistration() {
        loginHelper.closeRegistrationPopUp();
    }
}
