package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start find element with 'locator' --->" +by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("End of find element with 'locator' --->" +by);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);

        logger.info("Something went wrong");
        logger.info(throwable.getMessage());
        logger.info(String.valueOf(throwable.fillInStackTrace()));

        //screenshots
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String link = "src/test/screenshots"+i+".png";
        HelperBase baseHelper = new HelperBase(driver);
        baseHelper.takeScreenShots(link);
        logger.info("this link to screenshots with error ---------->"+link);
    }
}
