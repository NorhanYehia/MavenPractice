package passangerApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Base {

    public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\mavenTest\\global.properties");
        Properties prob =new  Properties();
        prob.load(fis);

        File f = new File("src");

        File fs = new File(f, (String) prob.get(appName));
        DesiredCapabilities cap= new DesiredCapabilities();
        String device = (String) prob.get("deviceName");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

        AndroidDriver<AndroidElement> driver ;
//        TouchAction t = new TouchAction(driver);
//        WebElement allow = driver.findElementByXPath("//android.widget.Button[@text='ALLOW']");
//        t.tap(tapOptions().withElement(element(allow))).perform();
        driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        return driver;
    }
}
