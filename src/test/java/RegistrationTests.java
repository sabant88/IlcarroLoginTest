import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preConditionMethod() {
        if (app.getUserHelper().isLogged()) {
            app.getUserHelper().logOut();
        }
    }


    @Test
    public void regTestPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String eMail = "noa" + i + "@gmail.com";
        String password = "Nnoa$" + i;
        String name = "Galina";
        String lastName = "Petrovna";
        System.out.println("Email: " + eMail);


        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegForm(name, lastName, eMail, password);
        app.getUserHelper().submitCheckBoxXY();
        app.getUserHelper().submitRegForm();

        Assert.assertTrue(app.getUserHelper().isLogged());

    }

    @Test
    public void regTestNegativeWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String eMail = "noa" + i + "gmail.com";
        String password = "Nnoa12345$";
        String name = "Galina";
        String lastName = "Petrovna";
        System.out.println("Email: " + eMail);

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegForm(name, lastName, eMail, password);
        app.getUserHelper().submitCheckBoxXY();
     //   app.getUserHelper().submitRegForm();

        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//div[text()='Wrong email format']")));
    }


    @Test
    public void regTestNegativeWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String eMail = "noa" + i + "@gmail.com";
        String password = "noa12345" + i;
        String name = "Galina";
        String lastName = "Petrovna";


        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegForm(name, lastName, eMail, password);
        app.getUserHelper().submitCheckBoxXY();

        Assert.assertFalse(app.getUserHelper().isLogged());

    }


}
