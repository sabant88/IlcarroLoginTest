package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    CarHelper carHelper;
    DataSearchHelper dataSearchHelper;
    String browser;

    Logger loger = LoggerFactory.getLogger(ApplicationManager.class);
    public ApplicationManager(String browser) {
        this.browser=browser;
    }

    public void init() {
    //    wd = new ChromeDriver();
    //   wd=new FirefoxDriver();
        if(browser.equals(BrowserType.CHROME)){
            wd =  new EventFiringWebDriver(new ChromeDriver());
            loger.info("All tests starts in 'Chrome' browser");
        } else if(browser.equals(BrowserType.EDGE)){
            wd =  new EventFiringWebDriver(new EdgeDriver());
            loger.info("All tests starts in 'Edge' browser");
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd =  new EventFiringWebDriver(new FirefoxDriver());
            loger.info("All tests starts in 'Firefox' browser");
        }

        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);
        dataSearchHelper = new DataSearchHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public CarHelper getCarHelper() {
        return carHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public DataSearchHelper getDataSearchHelper() {
        return dataSearchHelper;
    }
}
