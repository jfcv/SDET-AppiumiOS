import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.util.HashMap;

public class ScrollTest extends BaseiOSTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
        /*
         * must wait right after changing to the webview
         * so It can find the element
         */
        int SECONDS = 5;
        int MILISECS = 1000;
        Thread.sleep(SECONDS*MILISECS);
        driver.findElementByIosClassChain("**/XCUIElementTypeButton[`label == \"UIKitCatalog\"`]").click();
        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByAccessibilityId("Red color component value").sendKeys("80");
        driver.findElementByAccessibilityId("Green color component value").sendKeys("220");
        driver.findElementByAccessibilityId("Blue color component value").sendKeys("105");
        System.out.println(driver.findElementByAccessibilityId("Blue color component value").getText());
    }
}
