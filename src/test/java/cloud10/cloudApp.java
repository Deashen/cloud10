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
            Thread.sleep(7000);
        }

        @Test
        public void makeBooking() throws InterruptedException
        {
            this.loginUserTest();
            BookingClass objBooking = new BookingClass();
            objBooking.makeBooking(this.driver);
        }

        @Test
        public void updateBookings ()throws InterruptedException
        {
            this.loginUserTest();
            UpdateBooking obj = new UpdateBooking(driver);
            obj.updateBookings("209");

            Thread.sleep(7000);
        }
    @Test
    public void deleteBooking() throws InterruptedException{
        this.loginUserTest();
        DeleteBooking obj = new DeleteBooking(driver);
        obj.deleteBookings("158");
        Thread.sleep(7000);
    }

    @After
        public void tearDownTest()
        {
            this.driver.quit();
        }
}

