import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helpers {

    public static WebElement findWritingBoxClassName(WebDriver driver, String className) {
        WebElement element = driver.findElement(By.className(className));
        System.out.println(element);
        return element;
    }


    public static WebElement findWritingBoxTagName(WebDriver driver, String tagName) {
        WebElement element = driver.findElement(By.tagName(tagName));
        System.out.println(element);
        return element;
    }


    public static void youtubeButton(WebDriver driver, String id) {
        System.out.println(driver.findElement(By.id(id)));
    }

    public static void openAmazon(WebDriver driver){
        driver.get("https://www.amazon.com/");

    }
}
