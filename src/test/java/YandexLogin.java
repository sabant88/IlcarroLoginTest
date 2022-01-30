import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YandexLogin {
    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        wd = new ChromeDriver();
        wd.navigate().to("https://mail.yandex.com/?noretpath=1");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @Test
    public void LoginPositiveTest() {

        WebElement log = wd.findElement(By.xpath("//*[@class='control button2 button2_view_classic button2_size_mail" +
                "-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']"));
        log.click();

        //find e-mail input
        WebElement einput = wd.findElement(By.xpath("//*[@name='login']"));
        einput.click();
        einput.clear();
        einput.sendKeys("sabant88@yandex.com");

        //find password input
        wd.findElement(By.xpath("//*[@data-t='button:action:passp:sign-in']")).click();



      WebElement inp = wd.findElement(By.xpath("//*[@data-t='field:input-passwd']"));
      inp.click();
      inp.clear();
      inp.sendKeys("Miledi88");

       wd.findElement(By.xpath("//*[@id='passp:sign-in']")).click();

        Assert.assertTrue(wd.findElements(By.xpath("//*[.='sabant88']")).size()>0);




    }


    @AfterMethod
    public void postCon(){
     //  wd.quit();
    }

}