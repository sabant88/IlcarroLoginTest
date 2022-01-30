import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{



    @Test
    public void regTestPositive () {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String eMail = "noa" + i + "@gmail.com";
        String password = "Nnoa12345$";
        String name = "Galina";
        String lastName = "Petrovna";
        System.out.println("Email: " + eMail);


        openRegistrationForm();
        fillRegForm(name,lastName,eMail,password);
        submitCheckBox();
        submitRegForm();

    }

}
