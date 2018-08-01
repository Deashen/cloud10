package cloud10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cloudApp
{

        WebDriver driver;

        public cloudApp() {
        }

        @Before
        public void setUpBeforeTest()
        {
            System.setProperty("webdriver.chrome.driver", "C:/Drivers/ChromeDriver/chromedriver.exe");
            this.driver = new ChromeDriver();
            String baseURL = "http://10.9.10.139:81/sqlite/Main/login.html";
            this.driver.get(baseURL);
        }

        @Test
        public void registerUserTest() throws InterruptedException
        {
            registerClass regObj = new registerClass();
            User userObj = new User();
            regObj.registerUser(this.driver, userObj);
        }

        @Test
        public void loginUserTest() throws InterruptedException
        {
            loginClass loginObj = new loginClass();
            User userObj = new User();
            loginObj.loginUserTest(this.driver, userObj);
        }

        @Test
        public void makeBooking() throws InterruptedException
        {
            this.loginUserTest();
            BookingClass objBooking = new BookingClass();
            objBooking.makeBooking(this.driver);
        }

        @After
        public void tearDownTest()
        {
            this.driver.quit();
        }
}

