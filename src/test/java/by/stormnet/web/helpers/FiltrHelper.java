package by.stormnet.web.helpers;

import by.stormnet.web.pages.FilterPage;

import java.util.ArrayList;

public class FiltrHelper extends AbsractHelper {
    private FilterPage onLM = new FilterPage();

    public FiltrHelper search(String data) {
        onLM.searchOnMainPage(data);
        return this;
    }

    public FiltrHelper search() {
        onLM.closePopUp();
        onLM.searchBySubCategory(onLM.getCategoryFromList(1));
        return this;
    }

    public FiltrHelper searchField(int n) {
        switch (n) {
            case 1:
                onLM.searchByText("юбки");
                break;
            case 2:
                onLM.searchByText("tester");
                break;
        }
        return this;
    }

    public int resultsNumber() {
        return onLM.resultsNumber();
    }

    public boolean checkEnteredCategory() {
        String init = onLM.getGoodsCategoryTitle().toLowerCase();
        return init.contains("юбки");
    }

    public boolean checkInvalidCategory() {
        return onLM.getNoResultsTitle().isDisplayed();
    }

    public boolean checkCategory() {
        String init = onLM.getGoodsCategoryTitle().toLowerCase();
        String subs = onLM.getName().toLowerCase();
        return init.contains(subs);
    }

    public FiltrHelper applySorting() {
        onLM.openPopUp(1);
        onLM.chooseSorting();
        return this;
    }

    public boolean checkPriceSorting() {
        float[] forPriceCheck = onLM.priceCheck();
        return forPriceCheck[0] <= forPriceCheck[forPriceCheck.length - 1];
    }

    public FiltrHelper nextSearch() {
        String nextCategory = onLM.getCategoryFromList(1);
        while (nextCategory.contains(onLM.getName())) {
            nextCategory = onLM.getCategoryFromList(1);
        }
        onLM.searchBySubCategory(nextCategory);
        return this;
    }

    public String sortingText() {
        return onLM.sortingCheck();
    }


    public FiltrHelper salesFilter() {
        onLM.chooseSaleFilter();
        return this;
    }

    public boolean salesFilterCheck() {
        return onLM.checkGoodsNumber() == onLM.checkSalesGoodsNumber();
    }

    public FiltrHelper priceFilter() {
        onLM.openPopUp(3);
        onLM.setMinPrice();
        onLM.pressApplyButton();
        return this;
    }

    public boolean priceFilterCheck() {
        int forCheck = 0;
        float limitation = (float) onLM.getCheckPrice();
        ArrayList<Float> list = onLM.getGoodsPrices();
        for (Float a : list) {
            if (a < limitation) {
                forCheck++;
            }
        }
        return forCheck == 0;
    }

    public FiltrHelper searchFromBottom() {
        onLM.searchBySubCategory(onLM.getCategoryFromList(2));
        return this;
    }
}
