import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseiOSRealDevice {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"14.5"); //not specifying this parameter could lead to unexpected behavior
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Globant iPhone"); //it won't work without a device name
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        caps.setCapability(MobileCapabilityType.APP, "/Users/juanfernando.cuadros/Downloads/Play Disney Parks.ipa"); //indicating which app is gonna be automated
        caps.setCapability("udid", "00008020-00125D463AC1002E"); //for indicating appium the test is running on a real device
        caps.setCapability("noReset", true); //for avoiding re-installing always the app
        /* TODO : find out if these caps are really needed for launching an iOS application
         * testing the application without these works good
        caps.setCapability("xcodeOrgId", "86BD45EKTC");
        caps.setCapability("xcodeSigningId", "iPhone Developer");
        caps.setCapability("bundleId", "com.disney.PlayApp");
         */
        IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        Thread.sleep(2000); //so it can wait for the new view
        driver.findElementByXPath("//XCUIElementTypeButton").click();
    }
}
