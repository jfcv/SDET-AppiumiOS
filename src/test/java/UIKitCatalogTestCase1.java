import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;

import java.net.MalformedURLException;

public class UIKitCatalogTestCase1 extends BaseiOSTest {
    public static void main(String[] args) throws MalformedURLException {
        IOSDriver driver = Capabilities();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Text Entry").click();
        driver.findElementByIosNsPredicate("type == \"XCUIElementTypeTextField\"").sendKeys("hello");
        driver.findElementByAccessibilityId("OK").click();
        driver.findElementByAccessibilityId("Confirm / Cancel").click();
        String message = driver.findElementByAccessibilityId("A message should be a short, complete sentence.").getText();
        System.out.println(message);
        driver.findElementByAccessibilityId("Confirm").click();
        Assert.assertEquals(message, "A message should be a short, complete sentence.");
    }
}
