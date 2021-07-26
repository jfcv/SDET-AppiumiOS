import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.Assert;

import java.net.MalformedURLException;

public class SlidersTest extends BaseiOSTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        IOSDriver driver = Capabilities();
        driver.findElementByAccessibilityId("Sliders").click();
        /*
         * you must cast the element to an IOSElement
         * so you can access the method .setValue()
         */
        IOSElement slider = (IOSElement) driver.findElementByXPath("//XCUIElementTypeSlider");
        slider.setValue("0");
        slider.setValue("1");
        Assert.assertEquals(slider.getText(), "50%");
    }
}
