package passangerApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Login extends Base{
    AndroidDriver<AndroidElement> driver;
    @BeforeTest
    public void setUp() throws IOException {
        driver = Capabilities("PassengerApp");
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);

    }


    @Test(dataProvider = "getData" , enabled = false)
    public void loginWithPhone(String mobile , String password) throws InterruptedException {

        driver.findElementById("com.altawasolgolf.lutfipassenger:id/country_code").click();
        driver.findElementsByClassName("android.widget.RelativeLayout").get(2).click();
        WebElement mob = driver.findElementByXPath("//android.widget.EditText[@text='Mobile Number']");
        mob.sendKeys(mobile);
        WebElement pass =driver.findElementByXPath("//android.widget.EditText[@text='Password']");
        pass.sendKeys(password);
        driver.findElementByXPath("//android.widget.Button[@text='Login']").click();
        Thread.sleep(3000);
        mob.clear();
        pass.clear();
    }
    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];

        data[0][0] ="1286749966";
        data[0][1] ="test1234";

        data[1][0] = "1286749978";
        data[1][1] = "test1234";

        data[2][0] ="1286749995";
        data[2][1] ="test1234";

        return  data;
    }

    @Test(dataProvider = "getEmailData")
    public void loginWithEmailSad_1(String email , String password) throws InterruptedException {
        driver.findElementById("com.altawasolgolf.lutfipassenger:id/btnLoginWithMail").click();
        WebElement mail = driver.findElementByXPath("//android.widget.EditText[@text='Email']");
        mail.sendKeys(email);
        WebElement pass =driver.findElementByXPath("//android.widget.EditText[@text='Password']");
        pass.sendKeys(password);
        driver.findElementByXPath("//android.widget.Button[@text='Login']").click();
        Thread.sleep(3000);
        mail.clear();
        pass.clear();
    }


    @Test(enabled = false)
    public void loginWithEmailHappy_2() throws InterruptedException {
        driver.findElementById("com.altawasolgolf.lutfipassenger:id/btnLoginWithMail").click();
        WebElement mail = driver.findElementByXPath("//android.widget.EditText[@text='Email']");
        mail.sendKeys("norhan1234@test.com");
        WebElement pass =driver.findElementByXPath("//android.widget.EditText[@text='Password']");
        pass.sendKeys("test1234");
        driver.findElementByXPath("//android.widget.Button[@text='Login']").click();
        Thread.sleep(3000);
        String expected = "";
        String actual = "";

        Assert.assertEquals(actual , expected);
    }
}
