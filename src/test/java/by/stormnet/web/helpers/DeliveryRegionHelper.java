package by.stormnet.web.helpers;

import by.stormnet.web.pages.AbstractPage;
import by.stormnet.web.pages.DeliveryRegionPage;

public class DeliveryRegionHelper extends AbstractPage {
    DeliveryRegionPage lamodaDeliveryRegion = new DeliveryRegionPage();

    public boolean checkDeliveryElements() {
        lamodaDeliveryRegion.clickOnDeliveryRegionBtn();
        if (lamodaDeliveryRegion.checkInputField() && lamodaDeliveryRegion.checkAutoSelect() && lamodaDeliveryRegion.checkCloseBtn()
                && lamodaDeliveryRegion.checkCancelBtn() && lamodaDeliveryRegion.checkRemindDeliveryRegion()) {
            return true;
        } else return false;
    }

    public boolean checkMinskIsSelectedAsDeliveryPoint() {
        lamodaDeliveryRegion.clickOnDeliveryRegionBtn();
        lamodaDeliveryRegion.selectMinsk();
        lamodaDeliveryRegion.clickRemindDeliveryRegion();
        return lamodaDeliveryRegion.verifyMinskIsSelected();
    }

    public boolean checkErrorMessageForWrongCityName() {
        lamodaDeliveryRegion.clickOnDeliveryRegionBtn();
        lamodaDeliveryRegion.typeWrongCityInInputField();
        return lamodaDeliveryRegion.checkWrongCityNameIsDisplayed();
    }

}
