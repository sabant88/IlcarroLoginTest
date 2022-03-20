import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger loger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void logerStart(Method m) {
        loger.info("Test name---->" + m.getName());

    }

    @AfterMethod(alwaysRun = true)
    public void endLoger(Method m) {
        loger.info("End of test" + m.getName());
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.init();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}
