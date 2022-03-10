import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class calculator {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    By D5 = By.id("com.google.android.calculator:id/digit_5");
    By D1 = By.id("com.google.android.calculator:id/digit_1");
    By D0 = By.id("com.google.android.calculator:id/digit_0");
    By signPlus = By.id("com.google.android.calculator:id/op_add");
    By equals = By.id("com.google.android.calculator:id/eq");
    By result = By.id("com.google.android.calculator:id/result_final");
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 30");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void Test() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(D5)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signPlus)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(D1)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(D0)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(equals)).click();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(result)).getText(),"15");
    }
    @AfterMethod
    public void close() {
        driver.quit();
    }
}