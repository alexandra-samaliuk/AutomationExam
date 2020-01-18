package by.stormnet.web;

import by.stormnet.web.helpers.LamodaHomeHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LamodaTests {
    private LamodaHomeHelper lamodaHomeHelper = new LamodaHomeHelper();

    @BeforeClass
    public void setUp() {
        lamodaHomeHelper.openLamodaHomeHelper();
    }

    @Test
    public void paginationTest() {
        lamodaHomeHelper.searchAndCheckResult("nike");
        boolean page = lamodaHomeHelper.openPageAndCheck("2");
        boolean pageNext = lamodaHomeHelper.openNextPageAndCheck();
        boolean pageBack = lamodaHomeHelper.openPrevPageAndCheck();

        Assert.assertTrue(page && pageBack && pageNext);
    }

    @AfterClass
    public void tearDown() {
        lamodaHomeHelper.quite();
    }
}

