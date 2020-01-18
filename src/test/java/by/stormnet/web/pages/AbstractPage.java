package by.stormnet.web.pages;

import by.stormnet.automation.core.FrameworkCore;
import by.stormnet.automation.core.utils.PauseLenght;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage extends FrameworkCore {
    private static WebDriver driver = getInstance();
    Actions actions = new Actions(driver);

    public WebDriver getDriver() {
        return driver;
    }

    public void openUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);

    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLenght.MAX.value());
            waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLenght.MAX.value());
            waiter.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    public static By getElementBy(String element) {
        return By.xpath(element);
    }

    public WebElement getElement(String element) {
        return driver.findElement(By.xpath(element));
    }

    public List<WebElement> getElements(String element) {
        return driver.findElements(By.xpath(element));
    }

    public void setCursorOnElement(String locator) {
        actions.moveToElement(driver.findElement(By.xpath(locator)));
        actions.perform();
    }
}
