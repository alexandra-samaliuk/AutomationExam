package by.stormnet.web.helpers;

import by.stormnet.web.pages.AccsPage;

public class AccsHelper {
    AccsPage lamodaAccsPage = new AccsPage();

    public void openLamodaAccsPage() {
        lamodaAccsPage.navigateToLamodaAccsPage();
    }

    public void addItemToCart() {
        lamodaAccsPage.clickOnAddToCart();
        lamodaAccsPage.clickOnMoveToCartBtn();
    }
}
