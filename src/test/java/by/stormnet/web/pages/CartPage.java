package by.stormnet.web.pages;

public class CartPage extends AbstractPage {
    private String checkItemsList = "//a[@class='checkout-header__cartlink js-cart-link']";
    private String emptyCart = "//h2[text()='В вашей корзине пока нет товаров']";
    private String checkItemInCart = "//div[@data-sku='ZA004DWFVEB6NS00']";
    private String deleteItemFromCart = "//button[@class='checkout__button cpi__action cpi__action_remove']";
    private String lamodaCartWithItemUrl = "https://www.lamoda.by/checkout/cart/?add=ZA004DWFVEB6NS00&popup=y";
    private String emptyPhoneField = "//label[@class='checkout__control-error'][text()='Пожалуйста, укажите номер Вашего мобильного телефона. Например, +375 (99) 999-99-99']";
    private String emptyCityField = "//label[@class='checkout__control-error'][text()='Это поле необходимо заполнить']";
    private String sendOrderBtn = "//button[@class='checkout__button checkout__button_lead']";
    private String confirmationPopUp = "//div[@class='modal__header'][text()='Подтверждение номера телефона']";
    private String closeConfirmationPopUp = "//div[contains(@class, 'visible')]//div[@class='modal__close']";
    private String oneItemInCart = "//span[@class='cpi__qty qty'][text()='1']";
    private String twoItemsInCart = "//span[@class='cpi__qty qty'][text()='2']";
    private String addOneItem = "//button[@class='checkout__button checkout__button_round checkout__button_round-plus cpi__action']";
    private String removeOneItem = "//button[@class='checkout__button checkout__button_round checkout__button_round-minus cpi__action']";
    private String deliveryPointsPopUp = "//div[@class='pickup-select-v2__tryon-prompt-h']";
    private String selectAddress = "//div[@class='pickup-select-v2__list-item-details'][text()='Минск, Куйбышева, 69 (Площадь Якуба Коласа) ']";
    private String selectPointBtn = "//div[@class='pickup-select-v2__details-submit button button_l button_blue'][text()='Выбрать этот пункт и условия']";
    private String selectedPointInCart = "//span[@class='checkout__pup-name'][text()='Lamoda | ул. Куйбышева, 69']";
    private String deliveryPoint = "//label[@class='checkout__radio checkout__radio-delivery-label'][text()=' Пункт доставки заказов ']";
    private String phoneField = "id_phone";
    private String cityField = "id_city_name";
    private String streetField = "id_street";
    private String houseField = "id_house";
    private String flatField = "id_flat";
    private String lastName = "id_last_name";
    private String suggestCity = "//div[contains(@style, 'block')]//div[@class='checkout__suggest-node']";
    private String firstName = "id_first_name";
    private String email = "id_email";
    private String cartBtn = "//span[@class='link user-nav__link user-nav__link_cart']";

    public CartPage navigateToCart() {
        openUrl(lamodaCartWithItemUrl);
        return navigateToCart();
    }

    public void clickCartBtn() {
        waitForElementVisible(getElementBy(cartBtn));
        getElement(cartBtn).click();
    }

    public void clickCheckItemsList() {
        waitForElementVisible(getElementBy(checkItemsList));
        getElement(checkItemsList).click();
    }

    public boolean checkItemslist() {
        return getElement(checkItemInCart).isDisplayed();
    }

    public boolean checkCartHasOneItem() {
        waitForElementVisible(getElementBy(oneItemInCart));
        return getElement(oneItemInCart).isDisplayed();
    }

    public boolean checkCartHasTwoItems() {
        waitForElementVisible(getElementBy(twoItemsInCart));
        return getElement(twoItemsInCart).isDisplayed();
    }

    public void clickAddItemBtn() {
        waitForElementVisible(getElementBy(addOneItem));
        setCursorOnElement(addOneItem);
        getElement(addOneItem).click();
    }

    public void clickRemoveItemBtn() {
        waitForElementVisible(getElementBy(removeOneItem));
        setCursorOnElement(removeOneItem);
        getElement(removeOneItem).click();
    }

    public void removeItemFromCart() {
        waitForElementVisible(getElementBy(deleteItemFromCart));
        setCursorOnElement(deleteItemFromCart);
        getElement(deleteItemFromCart).click();
    }

    public boolean verifyCartIsEmpty() {
        waitForElementVisible(getElementBy(emptyCart));
        return getElement(emptyCart).isDisplayed();
    }

    public boolean verifyPhoneFieldIsEmpty() {
        waitForElementVisible(getElementBy(emptyPhoneField));
        return getElement(emptyPhoneField).isDisplayed();
    }

    public boolean verifyCityFieldIsEmpty() {
        waitForElementVisible(getElementBy(emptyCityField));
        return getElement(emptyCityField).isDisplayed();
    }

    public void fillPhoneField(String phoneFieldValue) {
        waitForElementVisible(getElementById(phoneField));
        getWebElementById(phoneField).sendKeys(phoneFieldValue);
    }

    public void fillCityField(String cityFieldValue) {
        getWebElementById(cityField).click();
        waitForElementClickable(getElementById(cityField));
        getWebElementById(cityField).sendKeys(cityFieldValue);
    }

    public void waitAndClickOnSendOrderBtn() {
        getElement(sendOrderBtn).click();
        waitForElementClickable(getElementBy(sendOrderBtn));
        getElement(sendOrderBtn).click();
    }

    public void clickOnSendOrderBtn() {
        waitForElementClickable(getElementBy(sendOrderBtn));
        setCursorOnElement(sendOrderBtn);
        getElement(sendOrderBtn).click();
    }

    public void fillStreetField(String stretFieldValue) {
        waitForElementClickable(getElementById(streetField));
        getWebElementById(streetField).sendKeys(stretFieldValue);
    }

    public void clickSuggest() {
        waitForElementVisible(getElementBy(suggestCity));
        getElement(suggestCity).click();
    }

    public void fillHouseField(String houseFieldValue) {
        getWebElementById(houseField).click();
        waitForElementClickable(getElementById(houseField));
        getWebElementById(houseField).sendKeys(houseFieldValue);
    }

    public void fillFlatField(String flatFieldValue) {
        getWebElementById(flatField).click();
        waitForElementClickable(getElementById(flatField));
        getWebElementById(flatField).sendKeys(flatFieldValue);
    }

    public void fillFirstNameField(String firstNameValue) {
        waitForElementClickable(getElementById(firstName));
        getWebElementById(firstName).sendKeys(firstNameValue);
    }

    public void fillLastNameField(String lastNameValue) {
        waitForElementClickable(getElementById(lastName));
        getWebElementById(lastName).sendKeys(lastNameValue);
    }

    public void fillEmailField(String emailFieldValue) {
        waitForElementClickable(getElementById(email));
        getWebElementById(email).sendKeys(emailFieldValue);
    }

    public boolean checkConfirmationPopUp() {
        waitForElementVisible(getElementBy(confirmationPopUp));
        return getElement(confirmationPopUp).isDisplayed();
    }

    public void clickCloseConfirmationPopUp() {
        waitForElementClickable(getElementBy(closeConfirmationPopUp));
        getElement(closeConfirmationPopUp).click();
    }

    public void selectDeliveryPoint() {
        waitForElementClickable(getElementBy(deliveryPoint));
        getElement(deliveryPoint).click();
    }

    public void checkDeliveryPointsPopUp() {
        waitForElementVisible(getElementBy(deliveryPointsPopUp));
        getElement(deliveryPointsPopUp).click();
    }

    public void selectPointAddress() {
        waitForElementVisible(getElementBy(selectAddress));
        getElement(selectAddress).click();
    }

    public void clickOnSelectPointBtn() {
        waitForElementVisible(getElementBy(selectPointBtn));
        getElement(selectPointBtn).click();
    }

    public boolean checkSelectedPointInCart() {
        waitForElementVisible(getElementBy(selectedPointInCart));
        return getElement(selectedPointInCart).isDisplayed();
    }

}
