package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }


    public void type(By locator, String text) {
        if (text != null && !text.isEmpty()) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }


    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void takeScreenShots(String link) {
        File temp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshots = new File(link);

        try {
            Files.copy(temp, screenshots);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

