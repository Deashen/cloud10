package cloud10.StepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFeatureStepDefs
{







    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By bodyTextLocator = By.tagName("body");
    private String cloud9WelcomeHeader = "Welcome ";
    WebDriver driver;

    @Given("^A cloud login page with text boxes to enter details$")
    public void a_cloud_login_page_with_text_boxes_to_enter_details() {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();

        System.setProperty("webdriver.chrome.driver", "C:/Drivers/ChromeDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        String baseURL = "http://10.9.10.139:81/sqlite/Main/login.html";
        this.driver.get(baseURL);
    }

    @When("^I add email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iAddEmailAsAndPasswordAs(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(this.emailLocator).sendKeys(arg0);
        driver.findElement(this.passwordLocator).sendKeys(arg1);
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @Then("the login should be successful and redirect me to the welcome page")
    public void the_login_should_be_successful_and_redirect_me_to_the_welcome_page() {
        // Write code here that turns the phrase above into concrete actions
        //

        String bodyText = driver.findElement(this.bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(this.cloud9WelcomeHeader));
        //Thread.sleep(2000L);
        driver.findElement(By.xpath("/html/body/center[3]/a")).click();
    }



}
