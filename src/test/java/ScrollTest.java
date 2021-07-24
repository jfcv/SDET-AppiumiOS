import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.util.HashMap;

public class ScrollTest extends BaseiOSTest {
    public static void main(String[] args) throws MalformedURLException {
        IOSDriver driver = Capabilities();
        //scroll using Javascript
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        /*
         * when using the property 'name' didn't work
         * you must use the 'label' property which has
         * the same 'value' than 'name'
         */
        scrollObject.put("label", "Web View");
        driver.executeScript("mobile:scroll", scrollObject);
        driver.findElementByAccessibilityId("Web View").click();
    }
}
