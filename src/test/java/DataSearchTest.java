import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DataSearchTest extends TestBase {


    @Test
    public void searchDataCurrentMonth() {
    app.getDataSearchHelper().fillSearchCurrentMonth("Tel Aviv, Israel","2/25/22","2/28/22");
    app.getUserHelper().submitRegForm();

        Assert.assertTrue(app.getDataSearchHelper().isListOfCarApeared());
    }


        @Test
        public void searchDataCurrentMonth2() {
            app.getDataSearchHelper().fillSearchCurrentMonth("Haifa, Israel","3/25/22","3/28/22");
            app.getUserHelper().pause(5000);
            app.getUserHelper().submitRegForm();

            Assert.assertTrue(app.getDataSearchHelper().isListOfCarApeared());
        }

        @Test
        public void typePeriodInFuture(){
//            app.getDataSearchHelper().fillSearchFutureMonth("Haifa, Israel","3/25/22","3/28/22");
//            app.getUserHelper().pause(5000);
//            app.getUserHelper().submitRegForm();

        }

        @Test
        public void searchPeriodAnyDataInFuture(){
        app.getDataSearchHelper().fillSearchFormInFuture("Haifa","3/30/22","2/22/23");
        app.getUserHelper().submitRegForm();
        app.getUserHelper().pause(2000);

        Assert.assertTrue(app.getDataSearchHelper().isListOfCarApeared());
        }

    @Test
    public void typePeriodInPast(){

    }

        @AfterMethod
    public void postCondition(){
        app.getDataSearchHelper().returnHome();

        }
}
