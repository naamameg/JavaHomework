import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
//import org.openqa.selenium.support.locators.RelativeLocator;

public class Tests {

    private static WebDriver driver;
    private static String calculatorURL = "https://dgotlieb.github.io/WebCalculator/";
    private static String optionsURL = "https://dgotlieb.github.io/Actions/";
    private static String controllersURL = "https://dgotlieb.github.io/Controllers/";

    @Test
    public void printSevenDimension() {
        ChromeDriver driver = Helpers.openChromeDriver(calculatorURL);
        Helpers.findByID(driver, "seven").getSize();
        driver.close();
    }


    @Test
    public void isSixDisplayed() {
        boolean six;
        six = Helpers.openChromeDriver(calculatorURL).findElement(By.id("six")).isDisplayed();
        driver.close();
    }

    @Test
    public void mathematicalFormula(){
        ChromeDriver driver = Helpers.openChromeDriver(calculatorURL);
        String number = "2";
        WebElement equal = Helpers.findByID(driver, "equal");
        WebElement screen = Helpers.findByID(driver, "screen");
        WebElement minus = Helpers.findByID(driver, "minus");
        WebElement four = Helpers.findByID(driver, "four");
        WebElement two = Helpers.findByID(driver, "two");
        String result;

        four.click();
        minus.click();
        two.click();
        equal.click();
        result = screen.getText();
        assertEquals(number, result);
        driver.close();

    }

//    @Test
//    public void TestURL(){
//        String url = driver.getCurrentUrl();
//
//    }

    @Test
    public void openYouTube(){
        ChromeDriver driver = Helpers.openChromeDriver("https://www.youtube.com/");
        String firstTitle = driver.getTitle();
        driver.navigate().refresh();
        String secondTitle = driver.getTitle();
        assertEquals(firstTitle, secondTitle);
        driver.close();
    }

    @Test
    public void getScreenShot() throws IOException {
        ChromeDriver driver = Helpers.openChromeDriver(optionsURL);
        WebElement box = Helpers.findByID(driver, "div1");
        File screenShotFile = box.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("box-screenshot.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }


     }

     @Test
    public void doubleClick(){
        ChromeDriver driver = Helpers.openChromeDriver(optionsURL);
        Actions click = new Actions(driver);
        WebElement doubleClick = driver.findElement(By.xpath("/html/body/p[2]"));
        click.doubleClick(doubleClick);
        click.perform();
     }

     @Test
    public void mouseHover(){
        ChromeDriver driver = Helpers.openChromeDriver(optionsURL);
        Actions hoverMouse = new Actions(driver);
        WebElement xIcon = Helpers.findByID(driver, "close");
        hoverMouse.moveToElement((xIcon)).perform();
     }

     @Test
    public void selectItems(){
         ChromeDriver driver = Helpers.openChromeDriver(optionsURL);
         Actions action = new Actions(driver);
         List<WebElement> optionsList = driver.findElements(By.name("kind"));
         action.clickAndHold(optionsList.get(1)).moveToElement(optionsList.get(2));
         action.build().perform();
     }
    @Test
    public void uploadFile(){
        ChromeDriver driver = Helpers.openChromeDriver(optionsURL);
        Actions action = new Actions(driver);
        WebElement chooseFile = driver.findElement(By.tagName("input"));
        action.click(chooseFile);
        action.perform();
        action.sendKeys(chooseFile, "\\C:\\Users\\naama\\OneDrive\\Desktop\\picture.png");

    }

    @Test
    public void scrollToElement(){
        ChromeDriver driver = Helpers.openChromeDriver(optionsURL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement clickMe = Helpers.findByID(driver, "clickMe");
        js.executeScript("arguments[0].scrollIntoView(true);", clickMe);
    }

    @Test
    public void scrollToLocation(){
    ChromeDriver driver = Helpers.openChromeDriver(optionsURL);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(70.87, 21)");
    }

    @Test
    public void selectChoices(){
        ChromeDriver driver = Helpers.openChromeDriver(controllersURL);
        WebElement cheese = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/input[3]"));
        cheese.click();
        WebElement milk = driver.findElement(By.xpath("/html/body/div/select/option[3]"));
        WebElement butter = driver.findElement(By.xpath("/html/body/div/select/option[1]"));
        WebElement chesseOption = driver.findElement(By.xpath("/html/body/div/select/option[2]"));
        milk.click();
        System.out.println(milk.getText() + "\n" + butter.getText() + "\n" + chesseOption.getText() );
    }

    @Test
    public void heightAndWidth(){
        ChromeDriver driver = Helpers.openChromeDriver(calculatorURL);
        WebElement two = Helpers.findByID(driver, "two");
        Dimension twoHeight = two.getSize();
        WebElement six = Helpers.findByID(driver, "six");
        Dimension sixWidth = six.getSize();
        System.out.println("Two height is: " + twoHeight.height + "\n" + "Six width is: " + sixWidth.width);
    }






    }





