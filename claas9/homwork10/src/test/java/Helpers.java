import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Helpers {

    public static ChromeDriver openChromeDriver(String url){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\naama\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    public static WebElement findByID(ChromeDriver driver, String id) {
        WebElement element = driver.findElement(By.id(id));
        return element;
    }



}
