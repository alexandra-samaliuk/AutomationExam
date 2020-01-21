package by.stormnet.web;

import by.stormnet.web.helpers.BlogHelper;
import by.stormnet.web.helpers.LamodaHomeHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BlogTest {
    private LamodaHomeHelper lamodaHomeHelper = new LamodaHomeHelper();
    private BlogHelper blogHelper = new BlogHelper();

    @BeforeClass
    public void setUp() {
        lamodaHomeHelper.openLamodaHomeHelper();
    }

    @Test(priority = 501)
    public void checkInstaShoppingPageFromBlog() {
        Assert.assertTrue(blogHelper.checkSalesBanner());
    }

    @Test(priority = 502)
    public void checkBlogMenu() {
        Assert.assertTrue(blogHelper.checkBlogTopics());
    }

    @Test(priority = 503)
    public void checkBlogBeauty() {
        Assert.assertTrue(blogHelper.checkBeautyTopics());
    }

    @Test(priority = 504)
    public void checkBlogStyle() {
        Assert.assertTrue(blogHelper.openAndCheckBlogItem());
    }

}
