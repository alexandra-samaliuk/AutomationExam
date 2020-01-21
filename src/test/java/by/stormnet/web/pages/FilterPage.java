package by.stormnet.web.pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilterPage extends AbstractPage {
    private static String checkElementOnOpening = "//div[@class='tizer-gender-select']";
    private String categoryMainPageX = "//span[contains(text(),'";
    private String searchResultCheckX = "//span[@class='products-catalog__head-counter']";
    private String goodsItem = "//a[@class='products-list-item__link link']";
    private String subCategory = "//li[@class='cat-nav-item dt102_li2']";
    private String categoryName;
    private String initHendler;
    private String subCategoryTitle = "//div[@class='title']";
    private String sorting = "//span[@class='button button_right button_wo-pdng-r']";
    private String checkForSortingDropdown = "//ul[@class='dropdown']";
    private String byPriceSorting = "//li[@data-order='price_asc']";
    private String prices = "//span[@class='price__actual']";
    private String toClose = "//div[@class='sub-popup-feb18__close']";
    private String byBrend = "//span[@class='button button_left button_s arrow-bottom multifilter__button']/span[text()='Бренд']";
    private String byPrice = "//span[@class='button button_left button_s arrow-bottom multifilter__button']/span[text()='Цена']";
    private String checkForFilterDropdown = "//div[@class='button-dropdown button-dropdown_open']/div[@class='dropdown']";
    private String brendCheckbox = "//div[@class='button-dropdown button-dropdown_open']/div/div[2]/div/label";
    private String applyButton = "//span[@class='button button_s button_blue multifilter-actions__apply']";
    private String brendName;
    private String goodsBrend = "//div[@class='products-list-item__brand']";
    private String clearFilter = "//div[contains(@class, 'multifilter_active')]/span[@class='button button_right button_s multifilter__reset']";
    private String salesFilter = "//label[contains(text(), 'Только со скидкой')]";
    private String salePrices = "//span[@class='price__old']";
    private String discauntPrices = "//span[@class='js-cd-discount price__action']";
    private String minPrice = "//input[@class='text-field range__value range__value_left']";
    private String maxPrice = "//input[@class='text-field range__value range__value_right']";
    private String clearAll = "//div[contains(@class, 'multifilter__button-reset-all')]";
    private int checkPrice;

    Random obj = new Random();

    public static FilterPage getLamodaMainPage() {
        FilterPage onLM = new FilterPage();
        waitForElementVisible(getElementBy(checkElementOnOpening));
        System.out.println("Lamoda is opened");
        return onLM;
    }

    public FilterPage searchOnMainPage(String data) {
        String str = categoryMainPageX + data + "')]";
        setCursorOnElement(str);
        getElement(str).click();
        waitForElementVisible(getElementBy(searchResultCheckX));
        return getLamodaMainPage();
    }

    public String getCategoryFromList() {
        int n = obj.nextInt(10);
        return (subCategory + "[" + n + "]");
    }

    public void closePopUp() {
        waitForElementVisible(getElementBy(toClose));
        getElement(toClose).click();
    }

    public FilterPage searchBySubCategory(String str) {
        setCursorOnElement(str);
        getElement(str).click();
        waitForElementVisible(getElementBy(searchResultCheckX));
        categoryName = getElement(str).getText();
        return getLamodaMainPage();
    }

    public String getName() {
        return getCategoryText(categoryName);
    }

    public String getGoodsCategoryTitle() {
        return getElement(subCategoryTitle).getText();
    }

    public int resultsNumber() {
        return getNumber(searchResultCheckX);
    }

    public void openPopUp(int identificator) {
        switch (identificator) {
            case 1:
                getElement(sorting).click();
                waitForElementVisible(getElementBy(checkForSortingDropdown));
                break;
            case 2:
                getElement(byBrend).click();
                waitForElementVisible(getElementBy(checkForFilterDropdown));
                break;
            case 3:
                getElement(byPrice).click();
                waitForElementVisible(getElementBy(checkForFilterDropdown));
                break;
        }
    }

    public FilterPage chooseSorting() {
        getElement(byPriceSorting).click();
        return getLamodaMainPage();
    }

    public float[] priceCheck() {
        List<WebElement> pricesList = getElements(prices);
        float[] forPriceCheck = new float[2];
        for (int i = 0; i < 2; i++) {
            forPriceCheck[i] = getNumber(pricesList.get(i));
        }
        return forPriceCheck;
    }

    public String sortingCheck() {
        return getElement(sorting).getText();
    }

    public void chooseBrendFilter() {
        List<WebElement> checkboxes = getElements(brendCheckbox);
        brendName = checkboxes.get(1).getText();
        checkboxes.get(1).click();
    }

    public FilterPage pressApplyButton() {
        getElement(applyButton).click();
        return getLamodaMainPage();
    }

    public String getBrendName() {
        return brendName;
    }

    public String getGoodsBrend() {
        List<WebElement> goods = getElements(goodsBrend);
        return getCategoryText(goods.get(0).getText());
    }

    public FilterPage clearBrend() {
        getElement(clearFilter).click();
        return getLamodaMainPage();
    }

    public FilterPage chooseSaleFilter() {
        getElement(salesFilter).click();
        return getLamodaMainPage();
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

    public FilterPage clearAll() {
        getElement(clearAll).click();
        return getLamodaMainPage();
    }
}
