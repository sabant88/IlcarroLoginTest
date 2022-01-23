import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexLogin {
    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        wd = new ChromeDriver();
        wd.navigate().to("https://mail.yandex.com/?noretpath=1");
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
        WebElement pasInput=wd.findElement(By.xpath("//*[@id='passp:sign-in']"));
        pasInput.click();

      WebElement inp = wd.findElement(By.xpath("//*[@type='password']"));
//      inp.click();
//      inp.clear();
//      inp.sendKeys("Miledi88");

        wd.findElement(By.xpath("//*[@id='passp:sign-in']")).click();




    }


    @AfterMethod
    public void postCon(){
     //  wd.quit();
    }

}