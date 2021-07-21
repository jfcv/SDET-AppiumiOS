import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseiOSTest {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"14.4");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
        /*
         * XCUI TEST framework used by appium for automating apps on iOS
         */
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        /*
         * waits for the app before starting the test
         */
        caps.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 50000);
        /*
         * waits at each command execution
         */
        caps.setCapability("commandTimeouts", "12000");
        caps.setCapability(MobileCapabilityType.APP, "/Users/juanfernando.cuadros/code/AppiumiOS/app/UIKitCatalog.app");

        IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
    }
}
