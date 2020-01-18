package by.stormnet.automation.core.webElements;

import by.stormnet.automation.core.FrameworkCore;
import org.openqa.selenium.*;

import java.util.List;

public class WebElement implements org.openqa.selenium.WebElement {
    private WebDriver driver;
    private String xpath;

    public WebElement(String xpath, WebDriver driver) {
        this.driver = driver;
        this.xpath = xpath;
    }

    private org.openqa.selenium.WebElement get(){
        return driver.findElement(By.xpath(xpath));
    }

    @Override
    public void click() {
        get().click();
    }

    @Override
    public void submit() {
        get().submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        get().sendKeys(charSequences);
    }

    @Override
    public void clear() {
        get().clear();
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return get().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return get().isEnabled();
    }

    @Override
    public String getText() {
        return get().getText();
    }

    @Override
    public List<org.openqa.selenium.WebElement> findElements(By by) {
        return null;
    }

    @Override
    public org.openqa.selenium.WebElement findElement(By by) {
        return get().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return get().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
