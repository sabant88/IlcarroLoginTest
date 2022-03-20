package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataSearchHelper extends HelperBase{


    public DataSearchHelper(WebDriver wd) {
        super(wd);
    }

    public void fillSearchCurrentMonth(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom,dateTo);
    }

    public void selectPeriodCurrentMonth(String dateFrom, String dateTo) {
        click(By.id("dates"));

        String[] dataF = dateFrom.split("/");
        String[] dataT = dateTo.split("/");

        String locator = "//div[text()= " + dataF[1] + " ]";
        String loc = String.format("//div[text()= %s ]",dataF[1]);
        click(By.xpath(loc));

        String locator1 = "//div[text()= " + dataT[1] + " ]";
        click(By.xpath(locator1));


//        click(By.xpath("//div[text()= 25 ]"));
//        click(By.xpath("//div[text()= 28 ]"));
        pause(5000);

    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
        //  click(By.cssSelector("div.pack-item"));
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    public boolean isListOfCarApeared(){
        return isElementPresent(By.cssSelector(".search-results"));
    }

    public void returnHome() {
        click(By.id("0"));
    }

    public void fillSearchFutureMonth(String city, String dateFrom, String dateTo) {
        fillInputCity(city);

    }

    public void fillSearchFormInFuture(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        selectAnyDate(dataFrom,dataTo);
    }

    private void selectAnyDate(String dataFrom, String dataTo) {
        LocalDate from= LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/dd/yy"));
        LocalDate to= LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("M/dd/yy"));
        LocalDate now= LocalDate.now();

        click(By.id("dates"));

        int monthDiff = from.getYear() - now.getYear()==0 ? from.getMonthValue() - now.getMonthValue()
                :12 - now.getMonthValue()+from.getMonthValue();

        clickNextMonth(monthDiff);

        String dataLocator = String.format("//div[text()=' %s ']", from.getDayOfMonth());
        click(By.xpath(dataLocator));

        monthDiff = to.getYear() - from.getYear()==0 ? to.getMonthValue() - from.getMonthValue()
                :12 - from.getMonthValue()+to.getMonthValue();
//
        clickNextMonth(monthDiff);

        dataLocator = String.format("//div[text()=' %s ']", to.getDayOfMonth());
        click(By.xpath(dataLocator));

    }

    private void clickNextMonth(int count) {
        for(int i=0;i<count;i++){
            click(By.cssSelector("button[aria-label='Next month']"));
        }
    }
}
