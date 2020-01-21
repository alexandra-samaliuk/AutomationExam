package by.stormnet.web;

import by.stormnet.web.helpers.FiltrHelper;
import by.stormnet.web.helpers.LamodaHomeHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FiltrationTests {
    private FiltrHelper mainHelper = new FiltrHelper();
    private LamodaHomeHelper lamodaHomeHelper = new LamodaHomeHelper();

    @Test(dataProvider = "searchText", priority = 101)
    public void searchOnLamoda(String data) {
        lamodaHomeHelper.openLamodaHomeHelper();
        mainHelper.search(data);
        Assert.assertTrue(mainHelper.resultsNumber() > 0);
    }

    @Test(priority = 102, dependsOnMethods = {"searchOnLamoda"})
    public void selectSubCategory() {
        System.out.println("selectSubCategory test");
        mainHelper.search();
        Assert.assertTrue(mainHelper.checkCategory());
    }

    @Test(priority = 103, dependsOnMethods = {"searchOnLamoda", "selectSubCategory"})
    public void applySoring() {
        mainHelper.applySorting();
        System.out.println("applySoring test");
        Assert.assertTrue(mainHelper.checkPriceSorting());
    }

    @Test(priority = 104, dependsOnMethods = {"searchOnLamoda", "selectSubCategory"})
    public void sortingIsSaved() {
        System.out.println("sortingIsSaved test");
        String before = mainHelper.sortingText();
        mainHelper.nextSearch();
        String after = mainHelper.sortingText();
        Assert.assertTrue(after.compareTo(before) == 0);
    }

    @Test(priority = 105, dependsOnMethods = {"searchOnLamoda", "selectSubCategory"})
    public void applySaleFilter() {
        System.out.println("applySaleFilter test");
        mainHelper.salesFilter();
        Assert.assertTrue(mainHelper.salesFilterCheck());
    }

    @Test(priority = 106, dependsOnMethods = {"searchOnLamoda", "selectSubCategory", "applySaleFilter"})
    public void saleFilterStays() {
        System.out.println("saleFilterStays test");
        mainHelper.nextSearch();
        Assert.assertTrue(mainHelper.salesFilterCheck());
    }

    @Test(priority = 107, dependsOnMethods = {"searchOnLamoda", "selectSubCategory"})
    public void applyPriceFilter() {
        System.out.println("applyPriceFilter test");
        mainHelper.priceFilter();
        Assert.assertTrue(mainHelper.priceFilterCheck());
    }

    @Test(priority = 108, dependsOnMethods = {"searchOnLamoda"})
    public void searchByText() {
        System.out.println("searchByText test");
        mainHelper.searchField(1);
        Assert.assertTrue(mainHelper.checkEnteredCategory());
    }

    @Test(priority = 109, dependsOnMethods = {"searchOnLamoda"})
    public void searchByWrongText() {
        System.out.println("searchByWrongText test");
        mainHelper.searchField(2);
        Assert.assertTrue(mainHelper.checkInvalidCategory());
    }

    @Test(priority = 110, dependsOnMethods = {"searchOnLamoda", "searchByWrongText"})
    public void navigationFromTopMenu() {
        System.out.println("navigationFromTopMenu test");
        mainHelper.searchFromBottom();
        Assert.assertTrue(mainHelper.checkCategory());
    }

    @AfterClass
    public void tearDown() {
        mainHelper.quite();
    }

    @DataProvider(name = "searchText")
    public Object[][] providerData() {
        return new Object[][]{{"Новинки"}, {"Обувь"}, {"Одежда"}};
    }
}
