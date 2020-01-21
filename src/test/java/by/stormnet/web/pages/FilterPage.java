package by.stormnet.web.pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilterPage extends AbstractPage {
    private String checkElementOnFilter1 = "//div[@class='unipop__item unipop__item_subs']";
    private String checkElementOnFilter2 = "//div[@class='unipop__item unipop__item_chat js-chat-button']";
    private String categoryMainPageX = "//span[contains(text(),'";
    private String searchResultCheckX = "//span[@class='products-catalog__head-counter']";
    private String goodsItem = "//a[@class='products-list-item__link link']";
    private String subCategory = "//li[@class='cat-nav-item dt102_li2']";
    private String categoryName;
    private String subCategoryTitle = "//div[@class='title']";
    private String sorting = "//span[@class='button button_right button_wo-pdng-r']";
    private String checkForSortingDropdown = "//ul[@class='dropdown']";
    private String byPriceSorting = "//li[@data-order='price_asc']";
    private String toClose = "//div[@class='sub-popup-feb18__close']";
    private String byPrice = "//span[contains(@class,'button')]/span[contains(text(), 'Цена')]/../..";
    private String checkForFilterDropdown = "//div[@class='button-dropdown button-dropdown_open']/div[@class='dropdown']";
    private String applyButton = "//span[@class='button button_s button_blue multifilter-actions__apply']";
    private String salesFilter = "//label[contains(text(), 'Только со скидкой')]";
    private String salePrices = "//span[@class='price__old']";
    private String discauntPrices = "//span[@class='js-cd-discount price__action']";
    private String minPrice = "//input[@class='text-field range__value range__value_left']";
    private String maxPrice = "//input[@class='text-field range__value range__value_right']";
    private String searchField = "//input[contains(@class, 'text-field text-field_large search__input js-search-field')]";
    private String bottomSubCategory = "//a[contains(@class, 'sm-link')]";
    private String noResultsTitle = "//div[@class='catalog-empty-search__subtitle']";
    private int checkPrice;

    private void waitForBar() {
        waitForElementClickable(getElementBy(checkElementOnFilter1));
        waitForElementClickable(getElementBy(checkElementOnFilter2));
    }

    public static FilterPage getLamodaMainPage() {
        FilterPage onLM = new FilterPage();
        return onLM;
    }

    public FilterPage searchOnMainPage(String data) {
        String str = categoryMainPageX + data + "')]";
        setCursorOnElement(str);
        waitForElementClickable(getElementBy(str));
        getElement(str).click();
        waitForElementVisible(getElementBy(searchResultCheckX));
        return getLamodaMainPage();
    }

    public void searchByText(String data) {
        WebElement search = getElement(searchField);
        search.clear();
        search.sendKeys(data + "\n");
        waitForElementVisible(getElementBy(subCategoryTitle));
    }

    public String getCategoryFromList(int m) {
        int n = randomInt();
        while (n == 0) {
            n = randomInt();
        }
        switch (m) {
            case 1:
                return (subCategory + "[" + n + "]/span/a");
            case 2:
                return (bottomSubCategory + "[" + (n + 1) + "]");
        }
        return "Error";
    }

    public void closePopUp() {
        waitForElementVisible(getElementBy(toClose));
        getElement(toClose).click();
    }

    public void searchBySubCategory(String str) {
        setCursorOnElement(str);
        getElement(str).click();
        waitForElementVisible(getElementBy(searchResultCheckX));
        categoryName = getElement(str).getText();
        waitForBar();
    }

    public String getName() {
        return getCategoryText(categoryName);
    }

    public String getGoodsCategoryTitle() {
        return getElement(subCategoryTitle).getText();
    }

    public WebElement getNoResultsTitle() {
        return getElement(noResultsTitle);
    }

    public int resultsNumber() {
        waitForBar();
        waitForElementVisible(getElementBy(searchResultCheckX));
        return getNumber(searchResultCheckX);
    }

    public void openPopUp(int identificator) {
        switch (identificator) {
            case 1:
                waitForElementClickable(getElementBy(sorting));
                getElement(sorting).click();
                waitForElementVisible(getElementBy(checkForSortingDropdown));
                break;
            case 3:
                refresh();
                waitForElementClickable(getElementBy(byPrice));
                getElement(byPrice).click();
                waitForElementVisible(getElementBy(checkForFilterDropdown));
                break;
        }
    }

    public void chooseSorting() {
        getElement(byPriceSorting).click();
        waitForBar();
    }

    public float[] priceCheck() {
        List<WebElement> pricesList = getElements(salePrices);
        float[] forPriceCheck = new float[2];
        for (int i = 0; i < 2; i++) {
            forPriceCheck[i] = getNumber(pricesList.get(i));
        }
        return forPriceCheck;
    }

    public String sortingCheck() {
        return getElement(sorting).getText();
    }

    public void pressApplyButton() {
        waitForElementClickable(getElementBy(applyButton));
        getElement(applyButton).click();
        waitForElementClickable(getElementBy(goodsItem + "[1]"));
        waitForBar();
    }

    public void chooseSaleFilter() {
        refresh();
        waitForElementClickable(getElementBy(salesFilter));
        getElement(salesFilter).click();
        waitForBar();
    }

    public int checkGoodsNumber() {
        List<WebElement> goods = getElements(goodsItem);
        return goods.size();
    }

    public int checkSalesGoodsNumber() {
        List<WebElement> goods = getElements(salePrices);
        return goods.size();
    }

    public void setMinPrice() {
        int min = Integer.valueOf(getElement(minPrice).getAttribute("placeholder"));
        int max = Integer.valueOf(getElement(maxPrice).getAttribute("placeholder"));
        checkPrice = ((max - min) / 3) + min;
        getElement(minPrice).clear();
        getElement(minPrice).sendKeys(Integer.toString(checkPrice));
    }

    public int getCheckPrice() {
        return checkPrice;
    }

    public ArrayList<Float> getGoodsPrices() {
        List<WebElement> list = getElements(discauntPrices);
        ArrayList<Float> prices = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            prices.add(getNumber(list.get(i)));
        }
        return prices;
    }
}
