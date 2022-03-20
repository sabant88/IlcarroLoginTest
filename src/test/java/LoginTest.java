import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @BeforeMethod
    public void preConditionMethod() {
        if (app.getUserHelper().isLogged()) {
            app.getUserHelper().logOut();
        }
    }

    @Test
    public void LoginPositiveTest() {
        loger.info("Login Positive Test");
        User user = new User().setWitheMail("noa@gmail.com").setPassword("Nnoa12345$");
        loger.info("Login Positive Test");

        app.getUserHelper().openLoginForm();
     //   app.getUserHelper().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitLogin();
        //  app.getUserHelper().okSubmit();


        //  Assert.assertTrue(wd.findElement(By.xpath("//*[@href='/logout?url=%2Fsearch']")).isDisplayed());
        Assert.assertTrue(app.getUserHelper().isLogged());

    }


    @Test
    public void LoginPositiveTest2() {

        String eMail = "noa@gmail.com";
        String password = "Nnoa12345$";
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(eMail, password);
        app.getUserHelper().submitLogin();
        //   app.getUserHelper().okSubmit();

        //  Assert.assertTrue(isElementPresent(By.xpath("//*[@href='/logout?url=%2Fsearch']")));
        Assert.assertTrue(app.getUserHelper().isLogged());

    }


    @Test
    public void LoginWrongPassword() {
        String eMail = "noa@gmail.com";
        String password = "noa12345";
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(eMail, password);
        app.getUserHelper().submitLogin();

        //   Assert.assertTrue(isElementPresent(By.xpath("//h2[@class='message']")));
        Assert.assertFalse(app.getUserHelper().isLogged());

    }

    @AfterMethod
    public void postCondition() {
        app.getUserHelper().okSubmit();
    }


}