import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Tests {

    private static WebDriver driver;
    private static String synchronization = "https://dgotlieb.github.io/Selenium/synchronization.html";


    @Test
    public void removeCheckBox(){
        ChromeDriver driver = Helpers.openChromeDriver(synchronization);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement removeButton = Helpers.findByID(driver, "btn");
        removeButton.click();
        List<WebElement> newElements = driver.findElements(By.id("checkBox"));
    }

    @Test
    public void showHidden() throws InterruptedException{
        ChromeDriver driver = Helpers.openChromeDriver(synchronization);
        Thread.sleep(5000);
        WebElement hiddenButton = Helpers.findByID(driver, "hidden");
        hiddenButton.click();
        Helpers.findByID(driver, "finish1");

    }

    @Test
    public void render(){
        ChromeDriver driver = Helpers.openChromeDriver(synchronization);
        WebElement renderButton = Helpers.findByID(driver, "rendered");
        renderButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
        Helpers.findByID(driver, "finish2");
    }

    @Test
    public void NGWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\naama\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        NgWebDriver ngWebDriver = new NgWebDriver(driver);
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.get("https://dgotlieb.github.io/AngularJS/main.html");


    }

}