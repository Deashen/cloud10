package cloud10;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BookingClass
{
    private By bodyTextLocator = By.tagName("body");

    public BookingClass()
    {
    }

    public void makeBooking(WebDriver driver) throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div/div/div[1]/ul/li[1]/a")).click();
        Select originSelect = new Select(driver.findElement(By.id("Origin")));
        Select destSelect = new Select(driver.findElement(By.id("Destination")));
        driver.findElement(By.id("seat")).sendKeys(new CharSequence[]{"A43"});
        Select flightSelect = new Select(driver.findElement(By.id("Flightclass")));
        originSelect.selectByIndex(2);
        destSelect.selectByIndex(2);
        flightSelect.selectByIndex(1);
        Thread.sleep(5000L);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/form/button")).click();
        this.assertBooking(driver);
    }

    public void assertBooking(WebDriver driver) throws InterruptedException
    {
        String bodyText = driver.findElement(this.bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("Flight booked successfully"));
    }
}
