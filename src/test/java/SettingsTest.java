import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SettingsTest {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setAppPackage("com.android.settings")
                .setAppActivity(".Settings")
                .setNewCommandTimeout(Duration.ofSeconds(120));

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Test
    public void clickNetworkAndInternet() throws InterruptedException {
        Thread.sleep(2000);
        WebElement networkOption = driver.findElement(
                AppiumBy.xpath("//*[@text='Network & internet']")
        );
        networkOption.click();
        Thread.sleep(2000);
        System.out.println("Clicked. Current activity: " + driver.currentActivity());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
