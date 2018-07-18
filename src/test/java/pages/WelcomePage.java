package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WelcomePage extends BasePage {


    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    private WebElement manageJenkinsLink = driver.findElement(By.xpath("//a[@href=\"/manage\"][@class=\"task-link\"]"));

    public void clickManageJenkinsLink(){
        manageJenkinsLink.click();
    }

}
