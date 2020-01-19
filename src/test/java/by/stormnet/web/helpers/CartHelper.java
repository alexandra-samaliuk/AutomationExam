package by.stormnet.web.helpers;

import by.stormnet.web.pages.CartPage;

public class CartHelper extends AbsractHelper {
    CartPage cartOnLamoda = new CartPage();

    public boolean checkItemInCart() {
        cartOnLamoda.clickCheckItemsList();
        return cartOnLamoda.checkItemslist();
    }

    public boolean removeAndCheckCartIsEmpty() {
        cartOnLamoda.removeItemFromCart();
        return cartOnLamoda.verifyCartIsEmpty();
    }

    public boolean checkPhoneFieldIsEmpty() {
        cartOnLamoda.clickOnSendOrderBtn();
        return cartOnLamoda.verifyPhoneFieldIsEmpty();
    }

    public boolean checkCityFieldIsEmpty() {
        cartOnLamoda.clickOnSendOrderBtn();
        return cartOnLamoda.verifyCityFieldIsEmpty();
    }

    public boolean fillOrderFieldsAndCheckConfirmation() {
        cartOnLamoda.fillPhoneField("441111111");
        cartOnLamoda.fillCityField("Минск");
        cartOnLamoda.clickSuggest();
        cartOnLamoda.fillStreetField("ул.Ленина");
        cartOnLamoda.fillHouseField("15");
        cartOnLamoda.fillFlatField("5");
        cartOnLamoda.fillFirstNameField("TestUser");
        cartOnLamoda.fillLastNameField("TestUser");
        cartOnLamoda.fillEmailField("test_email@gmail.com");
        cartOnLamoda.waitAndClickOnSendOrderBtn();
        return cartOnLamoda.checkConfirmationPopUp();
    }

    public boolean checkItemIsAddedToCart() {
        cartOnLamoda.checkCartHasOneItem();
        cartOnLamoda.clickAddItemBtn();
        return cartOnLamoda.checkCartHasTwoItems();
    }

    public boolean checkItemIsRemovedFromCart() {
        cartOnLamoda.checkCartHasTwoItems();
        cartOnLamoda.clickRemoveItemBtn();
        return cartOnLamoda.checkCartHasOneItem();
    }

    public boolean checkSelectedOrderPoint() {
        cartOnLamoda.clickCartBtn();
        cartOnLamoda.selectDeliveryPoint();
        cartOnLamoda.checkDeliveryPointsPopUp();
        cartOnLamoda.selectPointAddress();
        cartOnLamoda.clickOnSelectPointBtn();
        return cartOnLamoda.checkSelectedPointInCart();
    }

    public void closeConfirmationPopUp() {
        cartOnLamoda.clickCloseConfirmationPopUp();
    }

}

