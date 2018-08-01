package cloud10;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerClass
{
    private By firstNameLocator = By.name("firstname");
    private By lastNameLocator = By.name("lastname");
    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By registerButtonLocator = By.xpath("/html/body/div/form/button");
    private By bodyTextLocator = By.tagName("body");
    private String cloud9RegisterHeader = "Cloud9 - Register";

    public registerClass() {
    }

    public void registerUser(WebDriver driver, User obj) throws InterruptedException {
        this.assertRegister(driver);
        Thread.sleep(2000L);
        Thread.sleep(2000L);
        driver.findElement(this.firstNameLocator).sendKeys(new CharSequence[]{obj.getFirstName()});
        Thread.sleep(1000L);
        driver.findElement(this.lastNameLocator).sendKeys(new CharSequence[]{obj.getLastName()});
        Thread.sleep(1000L);
        driver.findElement(this.emailLocator).sendKeys(new CharSequence[]{obj.getEmail()});
        Thread.sleep(1000L);
        driver.findElement(this.passwordLocator).sendKeys(new CharSequence[]{obj.getPassword()});
        Thread.sleep(2000L);
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath("/html/body/center/a")).click();
        Thread.sleep(1000L);
    }

    public void assertRegister(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        String bodyText = driver.findElement(this.bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(this.cloud9RegisterHeader));
    }
}
