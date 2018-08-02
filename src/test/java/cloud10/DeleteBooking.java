package cloud10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeleteBooking
{
    WebDriver driver;

    public DeleteBooking(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteBookings(String FlightID) throws InterruptedException {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));

        int rowID = -1;
        for(int i =1; i<rows.size(); i++){

            String flightIDNum = rows.get(i).findElements(By.tagName("td")).get(3).getText();
            if(flightIDNum.equals(FlightID)){
                rowID = i;
                break;
            }

        }
        List<WebElement> colVals2 = rows.get(rowID).findElements(By.tagName("td"));
        colVals2.get(0).findElement(By.linkText("Delete")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/center/a")).click();
    }

}
