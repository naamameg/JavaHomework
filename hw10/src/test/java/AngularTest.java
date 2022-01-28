import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class AngularTest {
    private static ChromeDriver driver;


    @BeforeClass
    public void NGWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\naama\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        NgWebDriver ngWebDriver = new NgWebDriver(driver);
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.get("https://dgotlieb.github.io/AngularJS/main.html");
    }

    @Test
    public void clearFirstName(){
        Actions action = new Actions(driver);
        WebElement firstName = driver.findElement(ByAngular.model("firstName"));
        action.doubleClick(firstName).perform();
        firstName.clear();
        firstName.sendKeys("Naama");
        WebElement newName = driver.findElement(By.xpath("/html/body/span[1]"));
        assertEquals(newName.getText(), "Naama");
    }

//    @Test
//    public void
}
