package by.stormnet.web.pages;

public class DeliveryRegionPage extends AbstractPage {
    private String deliveryRegionBtn = "//span[@class='header__top-description-region']";
    private String inputField = "//input[@class='text-field text-field_large']";
    private String autoSelect = "//span[@class='link link_blue js-set-auto-city']";
    private String closeBtn = "//div[@class='modal__close']";
    private String cancelBtn = "//span[@class='link link_blue geo__button-cancel js-geo-button-cancel']";
    private String remindDeliveryRegion = "//span[@class='button__title'][text()='Запомнить выбор']";
    private String selectMinsk = "//span[text()='Минск']";
    private String wrongCityName = "//div[text()='Проверьте написание и воспользуйтесь подсказкой']";
    private String checkMinskIsSelected = "//span[@class='header__top-description-region-name arrow-bottom arrow-bottom_geo'][text()='г. Минск']";

    public void clickOnDeliveryRegionBtn() {
        openUrl(lamodaUrl);
        waitForElementClickable(getElementBy(deliveryRegionBtn));
        getElement(deliveryRegionBtn).click();
    }

    public boolean checkInputField() {
        waitForElementVisible(getElementBy(inputField));
        return getElement(inputField).isDisplayed();
    }

    public void typeWrongCityInInputField() {
        waitForElementVisible(getElementBy(inputField));
        getElement(inputField).sendKeys("abc");
    }

    public boolean checkAutoSelect() {
        waitForElementVisible(getElementBy(autoSelect));
        return getElement(autoSelect).isDisplayed();
    }

    public boolean checkCloseBtn() {
        waitForElementVisible(getElementBy(closeBtn));
        return getElement(closeBtn).isDisplayed();
    }

    public boolean checkCancelBtn() {
        waitForElementVisible(getElementBy(cancelBtn));
        return getElement(cancelBtn).isDisplayed();
    }

    public boolean checkRemindDeliveryRegion() {
        waitForElementVisible(getElementBy(remindDeliveryRegion));
        return getElement(remindDeliveryRegion).isDisplayed();
    }

    public void clickRemindDeliveryRegion() {
        waitForElementVisible(getElementBy(remindDeliveryRegion));
        getElement(remindDeliveryRegion).click();
    }

    public void selectMinsk() {
        waitForElementVisible(getElementBy(selectMinsk));
        getElement(selectMinsk).click();
    }

    public boolean checkWrongCityNameIsDisplayed() {
        waitForElementVisible(getElementBy(wrongCityName));
        return getElement(wrongCityName).isDisplayed();
    }

    public boolean verifyMinskIsSelected() {
        waitForElementVisible(getElementBy(checkMinskIsSelected));
        return getElement(checkMinskIsSelected).isDisplayed();
    }
}
