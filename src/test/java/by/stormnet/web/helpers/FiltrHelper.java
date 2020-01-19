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
        onLM.searchBySubCategory(onLM.getCategoryFromList());
        return this;
    }

    public int resultsNumber() {
        return onLM.resultsNumber();
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
        return forPriceCheck[0] <= forPriceCheck[1];
    }

    public FiltrHelper nextSearch() {
        String nextCategory = onLM.getCategoryFromList();
        while (nextCategory.contains(onLM.getName())) {
            nextCategory = onLM.getCategoryFromList();
        }
        onLM.searchBySubCategory(nextCategory);
        return this;
    }

    public String sortingText() {
        return onLM.sortingCheck();
    }

    public FiltrHelper brendFilter() {
        onLM.openPopUp(2);
        onLM.chooseBrendFilter();
        onLM.pressApplyButton();
        return this;
    }

    public boolean brendFilterCheck() {
        return onLM.getBrendName().compareTo(onLM.getGoodsBrend()) == 0;
    }

    public FiltrHelper brendFilterCleared() {
        onLM.clearBrend();
        return this;
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
        float limitation = onLM.getCheckPrice();
        ArrayList<Float> list = onLM.getGoodsPrices();
        for (Float a : list) {
            if (a < limitation) {
                forCheck++;
            }
        }
        return forCheck == 0;
    }

    public FiltrHelper AllFiltersCleared() {
        onLM.clearAll();
        return this;
    }
}
