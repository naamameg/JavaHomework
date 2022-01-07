import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirfoxTest {

    private static WebDriver firefoxDriver;

    @BeforeClass
    public void openDrives() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\naama\\geckodriver-v0.30.0-win32\\geckodriver.exe");
    }

    @BeforeMethod
    public void createObject(){
        firefoxDriver = new FirefoxDriver();
    }

    @AfterMethod
    private void closeDrivers(){
        firefoxDriver.close();
    }

    @Test(priority = 1)
    public void ynetInfirefox() {
        firefoxDriver.get("http://ynet.co.il");
    }

    @Test(priority = 2)
    public void openYoutube() {
        firefoxDriver.get(("https://www.youtube.com/"));
        Helpers.youtubeButton(firefoxDriver, "logo-icon");
    }

    @Test(priority = 3)
    public void openSeleniumq(){

        firefoxDriver.get("https://www.selenium.dev/");
        System.out.println(firefoxDriver.findElement(By.xpath("/html/body/header/nav/div/div/span/input")));
    }

    @Test(priority = 4)
    public void searchSong(){
        firefoxDriver.get(("https://www.youtube.com/"));
        firefoxDriver.findElement(By.name("search_query")).click();
        firefoxDriver.findElement(By.name("search_query")).sendKeys("Let it be");
        firefoxDriver.findElement(By.xpath("//*[@id='search-icon-legacy']")).click();
    }
}