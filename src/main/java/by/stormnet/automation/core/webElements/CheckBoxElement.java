package by.stormnet.automation.core.webElements;

import org.openqa.selenium.WebDriver;

import javax.jws.WebResult;

public class CheckBoxElement extends WebElement {

    public CheckBoxElement(String xpath, WebDriver driver) {
        super(xpath, driver);
    }

    public void setState(boolean b) {
        if (b) {
            if (!isSelected()) {
                click();
            }
        } else {
            if (isSelected()) {
                click();
            }
        }
    }

    public boolean getState() {
        return isSelected();
    }
}
