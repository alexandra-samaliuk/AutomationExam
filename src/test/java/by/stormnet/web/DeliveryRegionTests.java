package by.stormnet.web;

import by.stormnet.automation.core.utils.IOUtils;
import by.stormnet.web.helpers.AccsHelper;
import by.stormnet.web.helpers.CartHelper;
import by.stormnet.web.helpers.DeliveryRegionHelper;
import by.stormnet.web.helpers.LamodaHomeHelper;
import by.stormnet.web.pages.DeliveryRegionPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeliveryRegionTests {
    private LamodaHomeHelper lamodaHomeHelper = new LamodaHomeHelper();
    private DeliveryRegionHelper deliveryRegionHelper = new DeliveryRegionHelper();

    @BeforeClass
    public void setUp() {
        lamodaHomeHelper.openLamodaHomeHelper();
    }

    @Test(priority = 301)
    public void checkElementsOnDeliveryPopUp() {
        Assert.assertTrue(deliveryRegionHelper.checkDeliveryElements());
    }

    @Test(priority = 302)
    public void selectMinskAsDeliveryPoint() {
        Assert.assertTrue(deliveryRegionHelper.checkMinskIsSelectedAsDeliveryPoint());
    }

    @Test(priority = 303)
    public void checkErrorMessageForWrongCityName() {
        Assert.assertTrue(deliveryRegionHelper.checkErrorMessageForWrongCityName());
    }

}
