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
        Assert.assertTrue(mainHelper.resultsNumber() > 0, "Goods are NOT found");
    }

    @Test(priority = 102)
    public void selectSubCategory() {
        mainHelper.search();
        Assert.assertTrue(mainHelper.checkCategory(), "Wrong category");
    }

    @Test(priority = 103)
    public void applySoring() {
        mainHelper.applySorting();
        System.out.println("Filtration are applied");
        Assert.assertTrue(mainHelper.checkPriceSorting(), "Filtration are NOT applied");
    }

    @Test(priority = 104)
    public void sortingIsSaved() {
        String before = mainHelper.sortingText();
        System.out.println(before);
        mainHelper.nextSearch();
        String after = mainHelper.sortingText();
        System.out.println(after);
        Assert.assertTrue(after.compareTo(before) == 0, "Filtration in reset");
    }

    @Test(priority = 105)
    public void applyByBrendFilter() {
        mainHelper.brendFilter();
        Assert.assertTrue(mainHelper.brendFilterCheck(), "Filter not applied");
    }

    @Test(priority = 106)
    public void clearBrendFilter() {
        int before = mainHelper.resultsNumber();
        mainHelper.brendFilterCleared();
        Assert.assertTrue(before < mainHelper.resultsNumber(), "Filter not cleared");
    }

    @Test(priority = 107)
    public void applySaleFilter() {
        mainHelper.salesFilter();
        Assert.assertTrue(mainHelper.salesFilterCheck(), "Filter not applied");
    }

    @Test(priority = 108)
    public void saleFilterStays() {
        mainHelper.nextSearch();
        Assert.assertTrue(mainHelper.salesFilterCheck(), "Filter is reset");
    }

    @Test(priority = 109)
    public void applyPriceFilter() {
        mainHelper.priceFilter();
        Assert.assertTrue(mainHelper.priceFilterCheck(), "Filter is NOT applied");
    }

    @Test(priority = 110)
    public void clearAllFilters() {
        int before = mainHelper.resultsNumber();
        mainHelper.AllFiltersCleared();
        Assert.assertTrue(before < mainHelper.resultsNumber(), "Filter not cleared");
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
