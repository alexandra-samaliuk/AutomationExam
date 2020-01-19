package by.stormnet.automation.core;

import by.stormnet.automation.core.utils.BrowserConstants;
import by.stormnet.automation.core.utils.IOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkCore {
    private static WebDriver webDriver;
    private static String browser = IOUtils.loadGenericProperties("browser", "configuration");
    public static String lamodaUrl = IOUtils.loadGenericProperties("lamodaUrl", "configuration");

    public static WebDriver getInstance(){
        if(browser.equals(BrowserConstants.CHROME)){
            webDriver= new ChromeDriver();
        }else{
            if(browser.equals(BrowserConstants.FIREFOX)){
                webDriver = new FirefoxDriver();
            }else{
                throw new IllegalArgumentException("Browser value from property file is incorrect!");
            }
        }
        return webDriver;
    }
}
