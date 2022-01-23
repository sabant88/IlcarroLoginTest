import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    WebDriver wd;

    @BeforeMethod
    public void preCondition(){
    wd = new ChromeDriver();
    wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.manage().window().maximize();

}
    @Test
    public void LoginPositiveTest(){

        WebElement log=wd.findElement(By.linkText("Log in"));
        log.click();

        //find e-mail input
        WebElement einput = wd.findElement(By.id("email"));
        einput.click();
        einput.clear();
        einput.sendKeys("noa@gmail.com");

        //find password input
        WebElement pasInput=wd.findElement(By.id("password"));
        pasInput.click();
        pasInput.clear();
        pasInput.sendKeys("Nnoa12345$");

        //find Login-yalla button
        wd.findElement(By.xpath("//button[@type]")).click();

        //find OK button
        wd.findElement(By.xpath("//*[text()='Ok']")).click();


        Assert.assertTrue(wd.findElement(By.xpath("//*[@href='/logout?url=%2Fsearch']")).isDisplayed());

    }

    @AfterMethod
    public void postCondition(){
        wd.quit();
    }

}