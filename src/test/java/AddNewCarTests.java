import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    //isLogged?
    //open car form
    //fill form + model Car
    //attach photo
    //submit

    @BeforeMethod
    public void preCondition(){
        if(!app.getUserHelper().isLogged()){
            app.getUserHelper().login(new User().setWitheMail("noa@gmail.com").setPassword("Nnoa12345$"));
            app.getUserHelper().pause(5000);

        }


    }

    @Test
    public void addNewCarPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        Car car = Car.builder()
                .address("Tel Aviv")
                .make("Daewoo")
                .model("Nexia")
                .year("2015")
                .engine("1.6")
                .fuel("Petrol")
                .gear("LX")
                .WD("AWD")
                .doors("4")
                .seats("5")
                .carClass("Suv")
                .fuelConsumption("6.5")
                .price("1000")
                .CarRegistrationNumber("101-102" + i)
                .distanceIncluded("800")
                .typeFeatures("sus")
                .about("fast car")
                .build();

        loger.info("car was added" + car.toString());

        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
       app.getCarHelper().attachPhoto();
        app.getUserHelper().pause(5000);
       app.getUserHelper().submitLogin();


      // Assert.assertTrue(app.getUserHelper().isElementPresent(By.cssSelector(".dialog-container h1")));

        Assert.assertTrue(app.getCarHelper().isCarAdded());
     //   app.getCarHelper().clickSearch();

        app.getCarHelper().clickShowCar();


    }


}
