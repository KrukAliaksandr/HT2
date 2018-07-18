
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class JenkinsTest {

    private ChromeDriver driver;

    private LogInPage log_in;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\librariesforEPAMprojects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log_in = PageFactory.initElements(driver, LogInPage.class);
        log_in.logIn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        log_in.manageJenkins_click();
    }


    @Test()
    public void firstTest_1() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean k = log_in.manageUsers_exist();
        Assert.assertTrue(k);

    }

    @Test()
    public void firstTest_2() {
        boolean a = log_in.ddEl_1_exist();
        Assert.assertTrue(a);
    }


    @Test
    public void secondTest() {
        log_in.manageLink_click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean f = log_in.createUserLink_exist();
        Assert.assertTrue(f);
    }


    @Test
    public void thirdTest() {
        log_in.manageLink_click();
        log_in.createUserLink_click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean l = log_in.numberOfFields();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(l);
    }


    @Test
    public void fourthTest() {
        log_in.manageLink_click();
        log_in.createUserLink_click();
        log_in.createNewUser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean h = log_in.someUser_exist();
        boolean g = log_in.deleteUser();
        boolean f = log_in.yesButton();
        Assert.assertTrue(h);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void fifthTest() {
        log_in.manageLink_click();
        log_in.createUserLink_click();
        log_in.createNewUser();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        boolean g = log_in.deleteUser();
        boolean f = log_in.yesButton();
        Assert.assertTrue(g);
    }

    @Test
    public void sixthTest() {
        log_in.manageLink_click();
        log_in.createUserLink_click();
        log_in.createNewUser();
        boolean g = log_in.deleteUser();
        boolean f = log_in.yesButton();
        Assert.assertFalse(f);
    }

    @Test
    public void seventhTest() {
        log_in.manageLink_click();
        log_in.createUserLink_click();
        log_in.createNewUser();
        boolean g = log_in.deleteUser();
        boolean f = log_in.yesButton();
        boolean k = log_in.absent();
        Assert.assertFalse(k);
    }

    @AfterTest
    public void exit() {
        driver.quit();
    }

}
