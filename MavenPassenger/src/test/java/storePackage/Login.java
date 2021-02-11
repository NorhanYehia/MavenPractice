package storePackage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Login extends BaseStore {

    AndroidDriver<AndroidElement> driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
    }

    @Test(dataProvider = "getData")
    public void login(String username) throws InterruptedException {
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"El Salvador\"));");
        driver.findElementByXPath("//android.widget.TextView[@text='Egypt']").click();
        driver.findElementByXPath("//android.widget.EditText[@text = 'Enter name here']").sendKeys(username);


        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        Thread.sleep(3000);

        if (username.isEmpty()){
            String ToastActual = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
            String expected = "Please enter your name";
            Assert.assertEquals(expected , ToastActual);
            System.out.println("login failed");
        }else {
            System.out.println("Login Successfully");
        }
    }

    @DataProvider
    public Object[] getData() {
        Object[] data = new Object[2];

        data[0] = "";
        data[1] = "norhan2";
        return data;
    }
}
