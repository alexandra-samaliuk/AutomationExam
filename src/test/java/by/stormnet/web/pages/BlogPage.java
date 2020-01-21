package by.stormnet.web.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public class BlogPage extends AbstractPage {
    private String blogButton = "//span[contains(text(), 'Блог')]";
    private String instaShopping = "//a[@class = 'tilda__insta-logo']";
    private String instaImg = "//img[@alt= 'InstaShopping']";
    private String blogMenu = "//span[@class= 'tilda__burger js-mgz-burger']";
    private String topicInMenu = "//a[@class= 'tilda__menu_item']";
    private String beautyTopic = "//h1[@class = 'tilda-blog_filter__title']";
    private String blogItemTitle = "//h1[@class = 'tilda__main-banner_title']//a";
    private String blogItemImg = "//img[@class = 'tilda__slider_list-item_img']";
    private String blogItemAfterOpen = "//div[@class = 'tn-atom']";


    public void clickBlogButton() {
        waitForElementClickable(getElementBy(blogButton));
        getElement(blogButton).click();
    }

    public void clickInstaShoping() {
        waitForElementClickable(getElementBy(instaShopping));
        getElement(instaShopping).click();
    }

    public boolean verifyInstaPage() {
        waitForElementClickable(getElementBy(instaImg));
        return getElement(instaImg).isDisplayed();
    }

    public void clickBlogMenu() {
        waitForElementClickable(getElementBy(blogMenu));
        getElement(blogMenu).click();
    }

    public String[] checkListOfTopics() {
        waitForElementClickable(getElementBy(topicInMenu + "[1]"));
        String[] topicsLabels = new String[3];
        for (int i = 1; i < 4; i++) {
            topicsLabels[i - 1] = getElement(topicInMenu + "[" + i + "]").getText();
        }
        return topicsLabels;
    }

    public void clickBlogMenuBeauty() {
        waitForElementClickable(getElementBy(topicInMenu + "[1]"));
        getElement(topicInMenu + "[1]").click();
    }

    public String getBeautyTopics() {
        waitForElementClickable(getElementBy(beautyTopic));
        return getElement(beautyTopic).getText();
    }

    public String getBlogItemTopics() {
        waitForElementClickable(getElementBy(blogItemTitle));
        return getElement(blogItemTitle).getText();
    }

    public void clickBlogItemImg() {
        waitForElementClickable(getElementBy(blogItemImg));
        getElement(blogItemImg).click();
    }

    public String getBlogItemTopicsAfterOpen() {
        waitForElementClickable(getElementBy(blogItemAfterOpen));
        return getElement(blogItemAfterOpen).getText();
    }

}
