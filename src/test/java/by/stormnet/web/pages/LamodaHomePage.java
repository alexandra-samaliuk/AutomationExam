package by.stormnet.web.pages;

import by.stormnet.automation.core.webElements.CheckBoxElement;
import by.stormnet.automation.core.webElements.WebElement;

public class LamodaHomePage extends AbstractPage {
    private static String searchField = "//input[contains(@class, 'text-field text-field_large search__input js-search-field')]";
    private String searchResult = "//span[@class='products-catalog__head-counter']";
    private String searchButton = "//div[@class='button button_blue search__button js-search-button']";
    private String searchNumber;
    private String page = "//a[contains(@class, 'paginator__num') and contains(text(), '";
    private String activePage = "//a[contains(@class, 'paginator__num') and contains(@class, 'button_toggled')]";
    private String backButton = "//span[contains(@class, 'paginator__prev')]";
    private String nextButton = "//span[contains(@class, 'paginator__next')]";
    private String colorFilter = "//span[@class = 'multifilter__title' and contains(text(), 'Цвет')]";
    private String exactColorChbx = "//div[@class = 'multifilter multifilter_colors']//input[@class = 'checkbox']";



    public static LamodaHomePage getLamodaHomePage() {
        LamodaHomePage loginPage = new LamodaHomePage();
        waitForElementVisible(getElementBy(searchField));
        System.out.println("Login page is opened");
        return loginPage;
    }

    public LamodaHomePage navigateToLamodaHomePage() {
        openUrl(lamodaUrl);
        return getLamodaHomePage();
    }

    public void fillSearchField(String searchParameter) {
        getElement(searchField).sendKeys(searchParameter);
    }

    public void submitSearchField() {
        getElement(searchButton).click();
        waitForElementVisible(getElementBy(searchResult));
    }

    public String getSearchResult() {
        searchNumber = getElement(searchResult).getText();
        return searchNumber;
    }

    public void navigateToPage(String pageNumber) {
        String page1 = (page + pageNumber + "')]");
        getElement(page1).click();
    }

    public String checkActivePage() {
        waitForElementVisible(getElementBy(activePage));
        String activePage1 = getElement(activePage).getText();
        return activePage1;
    }

    public void clickNextButton (){
        getElement(nextButton).click();
    }

    public void clickBackButton (){
        getElement(backButton).click();
    }


    private CheckBoxElement checkBoxElement = new CheckBoxElement(exactColorChbx, getDriver());
    public void checkbox(){
        checkBoxElement.getState();
        checkBoxElement.setState(true);
    }

    public void clickColorFilter(){
        waitForElementVisible(getElementBy(colorFilter));
        getElement(colorFilter).click();
    }

    public void selectExactColor(){
        checkBoxElement.setState(true);
    }

    public boolean getColorState(){
        return checkBoxElement.getState();
    }

}
