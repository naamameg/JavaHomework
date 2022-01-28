import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {

    private static ChromeDriver driver;

    public static ChromeDriver getDriverInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\naama\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }


}
