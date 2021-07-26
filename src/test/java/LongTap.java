import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.time.Duration;

public class LongTap extends BaseiOSTest {
    public static void main(String[] args) throws MalformedURLException {
        IOSDriver driver = Capabilities();
        MobileElement title = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Long tap\"]");
        IOSTouchAction action = new IOSTouchAction(driver);
        action.longPress(
                longPressOptions()
                .withElement(element(title))
                .withDuration(Duration.ofSeconds(2)))
                .release()
                .perform();
    }
}
