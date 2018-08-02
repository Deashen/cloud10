package cloud10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UpdateBooking
{
    public UpdateBooking(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public By originLocator = By.id("Origin");
    public By destLocator = By.id("Destination");
    public By seatLocator = By.id("seat");
    public By classLocator = By.id("Flightclass");
    public By submitLocator = By.xpath("/html/body/div/div/div[2]/form/button");
    public By initLocator = By.xpath("/html/body/div/div/div[2]/center/a");

    public void updateBookings (String FlightID) throws InterruptedException {
        System.out.println("In UpdateBookings");
        //Thread.sleep(7000);
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
        ////table[@class='table table-striped']/tbody/tr
        //*   /html/body/div/div/div[2]/div/table
        System.out.println(rows.size());

        int rowNum =  rows.size();
        int rowID = -1;

        for(int i =1; i<rows.size(); i++){

            String flightIDNum = rows.get(i).findElements(By.tagName("td")).get(3).getText();
            if(flightIDNum.equals(FlightID)){
                rowID = i;
                break;
            }

        }

        //List<WebElement> colsVal = rows.get(rowNum-1).findElements(By.tagName("td"));
        //System.out.println(colsVal.get(3).getText());

        // Get booking id for requested booking
        List<WebElement> colVals2 = rows.get(rowID).findElements(By.tagName("td"));
        colVals2.get(0).findElement(By.linkText("Update")).click();

        //the booking part
        Select oselect = new Select(driver.findElement(originLocator));
        oselect.selectByIndex(0);

        Select dselect = new Select(driver.findElement(destLocator));
        dselect.selectByIndex(4);

        driver.findElement(seatLocator).sendKeys(Keys.chord(Keys.CONTROL, "a"), "2777A");

        Select fselect = new Select(driver.findElement(classLocator));
        fselect.selectByIndex(1);
        driver.findElement(submitLocator).click();
        driver.findElement(initLocator).click();


        //List<WebElement> rows2 = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
        //List<WebElement> colVals3 = rows2.get(rowNum-1).findElements(By.tagName("td"));
    }
}
