package by.stormnet.web.helpers;

import by.stormnet.web.pages.LamodaHomePage;

public class LamodaHomeHelper extends AbsractHelper {
    LamodaHomePage lamodaHomePage = new LamodaHomePage();

    public LamodaHomeHelper openLamodaHomeHelper() {
        System.out.println("Navigate to lamoda page ...");
        lamodaHomePage.navigateToLamodaHomePage();
        return this;
    }

    public boolean searchAndCheckResult(String searchParameter) {
        System.out.println("Search data by " + searchParameter);
        lamodaHomePage.fillSearchField(searchParameter);
        lamodaHomePage.submitSearchField();
        String result = lamodaHomePage.getSearchResult();
        result = result.split(" ")[0];
        System.out.println("found - " + result + " results");
        boolean checkSearch;
        if (Integer.parseInt(result) > 0) {
            checkSearch = true;
        } else {
            checkSearch = false;
        }
        return checkSearch;
    }

    public boolean openPageAndCheck(String page) {
        lamodaHomePage.navigateToPage(page);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String page1 = lamodaHomePage.checkActivePage();
        if (page.equals(page1)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean openNextPageAndCheck() {
        String page1 = lamodaHomePage.checkActivePage();
        lamodaHomePage.clickNextButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String page2 = lamodaHomePage.checkActivePage();
        if (page1.equals(page2)) {
            return false;
        } else {
            return true;
        }
    }
    public boolean openPrevPageAndCheck() {
        String page1 = lamodaHomePage.checkActivePage();
        lamodaHomePage.clickBackButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String page2 = lamodaHomePage.checkActivePage();
        if (page1.equals(page2)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkColor(){
        lamodaHomePage.clickColorFilter();

        lamodaHomePage.selectExactColor();
        return lamodaHomePage.getColorState();
    }

}
