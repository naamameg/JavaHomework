
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DriverTest {

    private static WebDriver chromeDriver;


    @BeforeClass
    public void openDrives() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\naama\\chromedriver_win32\\chromedriver.exe");

    }
    @BeforeMethod
    public void createObjects(){
        chromeDriver = new ChromeDriver();
    }

    @AfterMethod
    public void closeDrivers(){
        chromeDriver.close();
    }

    @Test(priority = 2)
    public void openGoogleTranslateClassName() {
        chromeDriver.get(("https://translate.google.co.il/?hl=iw"));
    }

    @Test(priority = 3)
    public void openGoogleTranslateTagName(){
        chromeDriver.get(("https://translate.google.co.il/?hl=iw"));
        Helpers.findWritingBoxTagName(chromeDriver, "textarea");
    }

    @Test(priority = 4)
    public void writeInGoogleTranslate(){
        chromeDriver.get(("https://translate.google.co.il/?hl=iw"));
        Helpers.findWritingBoxTagName(chromeDriver, "textarea").click();
        Helpers.findWritingBoxTagName(chromeDriver, "textarea").sendKeys("שלום עולם");
    }

    @Test(priority = 1)
    public void wallaInChrome() {
        chromeDriver.get("http://walla.co.il");
    }

    @Test(priority = 5)
    public void getTitleAmazonChrome() {
        Helpers.openAmazon(chromeDriver);
        String title = chromeDriver.getTitle();
        System.out.println("Page title: " + title);
        Assert.assertTrue(title.contains("Amazon"));

    }
    @Test(priority = 6)
    public void searchShoesAmazon() {
        Helpers.openAmazon(chromeDriver);
        chromeDriver.findElement(By.id("twotabsearchtextbox")).click();
        chromeDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("leather shoes");
        chromeDriver.findElement(By.id("nav-search-submit-button")).click();
    }
}
