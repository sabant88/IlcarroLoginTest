package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
//        WebElement log=wd.findElement(By.linkText("Log in"));
//        log.click();

        click(By.xpath("//a[@href='/login?url=%2Fsearch']"));
    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.geteMail());
        type(By.id("password"), user.getPassword());

    }

    public void fillLoginForm(String eMail, String password) {
        type(By.id("email"), eMail);
        type(By.id("password"), password);

    }


    public void okSubmit() {

        click(By.xpath("//*[text()='Ok']"));
    }


    public void fillRegForm(String name, String lastName, String eMail, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), eMail);
        type(By.id("password"), password);


    }

    public void submitRegForm() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void submitCheckBox() {

        click(By.xpath("//label[@for = 'terms-of-use']"));

    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[contains(.,'Delete account')]"));
    }


    public void logOut() {
        click(By.xpath("//a[@href='/logout?url=%2Fsearch']"));
    }


    public void openRegistrationForm() {
        click(By.cssSelector("[href$='/registration?url=%2Fsearch']"));
    }


    public void submitCheckBoxXY() {

        WebElement label = wd.findElement(By.xpath("//label[@for = 'terms-of-use']"));

        Rectangle rectangle = label.getRect();

        Actions actions = new Actions(wd);

        actions.moveToElement(label).release().build().perform();

        int offSetX = rectangle.getWidth() / 2;
        int offSetY = rectangle.getHeight() / 2;

        actions.moveByOffset(-offSetX, -offSetY).click().release().build().perform();


        //   click(By.cssSelector("label.checkbox-label.terms-label::before"));
    }


    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        okSubmit();
        pause(2000);
    }
}
