import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeSuite
    public void preCondition() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @BeforeMethod
    public void preConditionMethod(){
        if (isLogged()){
            logOut();
        }
    }



    @AfterSuite
    public void postCondition() {
     //   wd.quit();
    }

    //===============================================================

    public void openRegistrationForm(){
       click(By.cssSelector("[href$='/registration?url=%2Fsearch']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        if(text!=null && !text.isEmpty()){
            WebElement element =  wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }

    public void fillRegForm(String name,String lastName, String eMail, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"),lastName);
        type(By.id("email"), eMail);
        type(By.id("password"), password);


    }

    public void submitRegForm() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void submitCheckBox(){

        click(By.xpath("//label[@for = 'terms-of-use']"));
        //   click(By.cssSelector("label.checkbox-label.terms-label::before"));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //===============================LOGIN==================================

    public void openLoginForm() {
        click(By.xpath("//a[@href='/login?url=%2Fsearch']"));
    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void fillLoginForm(String eMail, String password) {
        type(By.id("email"), eMail);
        type(By.id("password"), password);

    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[contains(.,'Delete account')]"));
    }

    public void logOut(){
        click(By.xpath("//a[@href='/logout?url=%2Fsearch']"));
    }


}
