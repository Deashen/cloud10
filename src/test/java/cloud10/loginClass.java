package cloud10;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginClass
{

    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By bodyTextLocator = By.tagName("body");
    private String cloud9WelcomeHeader = "Welcome ";

    public loginClass() {
    }

    public void loginUserTest(WebDriver driver, User obj) throws InterruptedException {
        driver.findElement(this.emailLocator).sendKeys(new CharSequence[]{obj.getEmail()});
        driver.findElement(this.passwordLocator).sendKeys(new CharSequence[]{obj.getPassword()});
        Thread.sleep(2000L);
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        this.assertLogin(driver);
    }

    public void assertLogin(WebDriver driver) throws InterruptedException {
        String bodyText = driver.findElement(this.bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(this.cloud9WelcomeHeader));
        Thread.sleep(2000L);
        System.out.println("Click on Homepage");
        driver.findElement(By.xpath("/html/body/center[3]/a")).click();
    }
}

