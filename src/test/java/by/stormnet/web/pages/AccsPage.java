package by.stormnet.web.pages;

public class AccsPage extends AbstractPage {
    private static String addToCart = "//span[@class='button__title'][text()='Добавить в корзину']";
    private String PopUpAddedToCart = "//div[@class='h2 post-cart-add__title'][text()='Товар добавлен в корзину']";
    private String moveToCartBtn = "//a[@class='button button_blue button_big post-cart-add__basket']"; // - перейти в корзину


    public static AccsPage getLamodaAccsPage() {
        AccsPage lamodaAccsPage = new AccsPage();
        waitForElementVisible(getElementBy(addToCart));
        return lamodaAccsPage;
    }

    public AccsPage navigateToLamodaAccsPage() {
        openUrl(lamodaAccsUrl);
        return getLamodaAccsPage();
    }

    public void clickOnAddToCart() {
        waitForElementClickable(getElementBy(addToCart));
        getElement(addToCart).click();
    }

    public void clickOnMoveToCartBtn() {
        waitForElementVisible(getElementBy(PopUpAddedToCart));
        getElement(moveToCartBtn).click();
    }

}
