package by.stormnet.web;

import by.stormnet.automation.core.utils.IOUtils;
import by.stormnet.web.helpers.AccsHelper;
import by.stormnet.web.helpers.CartHelper;
import by.stormnet.web.helpers.LamodaHomeHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTests {
    private LamodaHomeHelper lamodaHomeHelper = new LamodaHomeHelper();
    private AccsHelper lamodaAccsHelper = new AccsHelper();
    private CartHelper cartOnLamodaHelper = new CartHelper();
    private String LamodaEmail, LamodaPassword;

    @BeforeClass
    public void setUp() {
        lamodaHomeHelper.openLamodaHomeHelper();
        LamodaEmail = IOUtils.loadGenericProperties("LamodaEmail", "configuration");
        LamodaPassword = IOUtils.loadGenericProperties("LamodaPassword", "configuration");
        lamodaHomeHelper.LogInToAccount(LamodaEmail, LamodaPassword);
    }

    @Test(priority = 201)
    public void addAndCheckItemInCart() {
        lamodaAccsHelper.openLamodaAccsPage();
        lamodaAccsHelper.addItemToCart();
        Assert.assertTrue(cartOnLamodaHelper.checkItemInCart());
    }

    @Test(priority = 202)
    public void checkRequiredFieldsAreEmpty() {
        Assert.assertTrue(cartOnLamodaHelper.checkCityFieldIsEmpty() && cartOnLamodaHelper.checkPhoneFieldIsEmpty());
    }

    @Test(priority = 203)
    public void addOneMoreItemInCart() {
        Assert.assertTrue(cartOnLamodaHelper.checkItemIsAddedToCart());
    }

    @Test(priority = 204)
    public void removeOneItemFromCart() {
        Assert.assertTrue(cartOnLamodaHelper.checkItemIsRemovedFromCart());
    }

    @Test(priority = 205)
    public void removeItemAndCheckEmptyCart() {
        Assert.assertTrue(cartOnLamodaHelper.removeAndCheckCartIsEmpty());
    }

    @Test(priority = 206, groups = {"DeliveryType"})
    public void fillOrderFieldsAndCheckConfirmation() {
        lamodaAccsHelper.openLamodaAccsPage();
        lamodaAccsHelper.addItemToCart();
        Assert.assertTrue(cartOnLamodaHelper.fillOrderFieldsAndCheckConfirmation());
    }

    @AfterMethod(onlyForGroups = {"DeliveryType"})
    public void tearDownTest6() {
        cartOnLamodaHelper.closeConfirmationPopUp();
    }

    @Test(priority = 207)
    public void checkOrderPointIsChosen() {
        Assert.assertTrue(cartOnLamodaHelper.checkSelectedOrderPoint());
    }
}
