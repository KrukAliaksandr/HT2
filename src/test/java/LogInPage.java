import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogInPage {
    WebDriver driver;


    @FindBy(id = "j_username")
    private WebElement login;

    @FindBy(name = "j_password")
    private WebElement password;

    @FindBy(id = "yui-gen1-button")
    private WebElement bSubmitRegister;

    @FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
    WebElement manageJenkins;

    @FindBy(xpath = "//*[@id=\"main-panel\"]/div[16]/a/dl/dt")
    WebElement manageUsers;

    @FindBy(xpath = "//*[@id=\"main-panel\"]/div[16]/a/dl/dd[1]")
    WebElement ddEl_1;

    @FindBy(xpath = "//*[@id=\"main-panel\"]/div[16]/a")
    WebElement manageLink;

    @FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
    WebElement createUserLink;

    @FindBy(css = "input[type='text']")
    List<WebElement> textFields;

    @FindBy(css = "input[type='password']")
    List<WebElement> passwordFields;

    //username для создания пользователя
    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement userName;

    //пароль для создания пользователя
    @FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
    WebElement password_1;

    //подтверждение пароля
    @FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
    WebElement password_2;

    //ФИО
    @FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
    WebElement fullName;

    //e-mail
    @FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
    WebElement email;

    //кнопка создать пользователя
    @FindBy(xpath = "//*[@id=\"yui-gen1-button\"]")
    WebElement buttonCreate;

    //tr c Some USer
    @FindBy(linkText = "someuser")
    WebElement someUser;
    @FindBy(xpath = "//table[class='sortable pane bigtable']/tr[2]/td[2]/a")
    WebElement someUser1;

    //кнопка delete
    @FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[3]/td[4]/a[2]")
    WebElement delete;

    //sure about deleting?
    @FindBy(xpath = "//*[@id=\"main-panel\"]/form")
    WebElement sure;

    //yes
    @FindBy(xpath = "//*[@id=\"yui-gen1-button\"]")
    WebElement yes;

    //exit
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/span/a[2]/b")
    WebElement exit;

    public void exitt() {
        exit.click();
    }


    public boolean absent() {
        try {
            delete.getText();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean yesButton() {
        yes.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            someUser1.getText().equals("krukaliaksandr");
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

    public boolean deleteUser() {
        delete.click();
        return sure.getText().equalsIgnoreCase("Are you sure about deleting the user from Jenkins?\n" +
                "Yes");
    }

    public boolean someUser_exist() {
        return someUser.getText().equals("someuser");
    }

    public void createNewUser() {
        userName.sendKeys("someuser");
        password_1.sendKeys("somepassword");
        password_2.sendKeys("somepassword");
        fullName.sendKeys("Some Full Name");
        email.sendKeys("some@addr.dom");
        buttonCreate.click();
    }

    public boolean numberOfFields() {
        int i = textFields.size();
        int p = passwordFields.size();
        return i == 3 && p == 2;

    }

    public boolean createUserLink_exist() {
        return createUserLink.equals(true) && createUserLink.getText().equals("Create User");

    }

    public void createUserLink_click() {
        createUserLink.click();
    }

    public void manageLink_click() {
        manageLink.click();
    }

    public boolean manageUsers_exist() {
        return manageUsers.getText().equals("Manage Users");
    }

    public boolean ddEl_1_exist() {
        return ddEl_1.getText().equals("Create/delete/modify users that can log in to this Jenkins");
    }

    public void manageJenkins_click() {
        manageJenkins.click();
    }

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:8080");
    }

    public void logIn() {
        login.sendKeys("krukaliaksandr ");
        password.sendKeys("san9san9");
        bSubmitRegister.click();
    }


}
