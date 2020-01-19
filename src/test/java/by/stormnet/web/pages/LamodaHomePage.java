package by.stormnet.web.pages;

public class LamodaHomePage extends AbstractPage {
    private static String searchField = "//input[contains(@class, 'text-field text-field_large search__input js-search-field')]";
    private String EnterBtn = "//span[@class='link user-nav__link js-auth-button'][text()='Войти']";
    private String emailField = "//form[contains(@class,'login-form')]//input[contains(@name,'email')]";
    private String passField = "//form[contains(@class,'login-form')]//input[contains(@name,'password')]";
    private String submitBtn = "//div[@class='form__controls']//button[contains(@type,'submit')][text()='Войти']";

    public static LamodaHomePage getLamodaHomePage() {
        LamodaHomePage loginPage = new LamodaHomePage();
        waitForElementVisible(getElementBy(searchField));
        return loginPage;
    }

    public LamodaHomePage navigateToLamodaHomePage() {
        openUrl(lamodaUrl);
        return getLamodaHomePage();
    }

    public LamodaHomePage clickEnterBtn() {
        waitForElementVisible(getElementBy(EnterBtn));
        getElement(EnterBtn).click();
        return getLamodaHomePage();
    }

    public LamodaHomePage fillEmailField(String LamodaEmail) {
        waitForElementVisible(getElementBy(emailField));
        getElement(emailField).sendKeys(LamodaEmail);
        return getLamodaHomePage();
    }

    public LamodaHomePage fillPassField(String LamodaPassword) {
        waitForElementVisible(getElementBy(passField));
        getElement(passField).sendKeys(LamodaPassword);
        return getLamodaHomePage();
    }

    public LamodaHomePage clickSubmit() {
        getElement(submitBtn).click();
        return getLamodaHomePage();
    }
}
