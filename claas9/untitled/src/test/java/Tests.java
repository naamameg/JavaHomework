import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;


import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Tests {

    private static WebDriver driver;
    private static String calculatorURL = "https://dgotlieb.github.io/WebCalculator/";
    private static String options = "https://dgotlieb.github.io/Actions/";

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
        assertEquals(six,true);
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
        ChromeDriver driver = Helpers.openChromeDriver(options);
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
        ChromeDriver driver = Helpers.openChromeDriver(options);
        Actions click = new Actions(driver);
        WebElement doubleClick = driver.findElement(By.xpath("/html/body/p[2]"));
        click.doubleClick(doubleClick);
        click.perform();
    }

    @Test
    public void mouseHover(){
        ChromeDriver driver = Helpers.openChromeDriver(options);
        Actions hoverMouse = new Actions(driver);
        WebElement xIcon = Helpers.findByID(driver, "close");
        hoverMouse.moveToElement((xIcon)).perform();
    }

    @Test
    public void selectItems(){
        ChromeDriver driver = Helpers.openChromeDriver(options);
        Actions action = new Actions(driver);
        List<WebElement> optionsList = driver.findElements(By.name("kind"));
        action.clickAndHold(optionsList.get(1)).moveToElement(optionsList.get(2));
        action.build().perform();
    }
    @Test
    public void uploadFile(){
        ChromeDriver driver = Helpers.openChromeDriver(options);
        Actions action = new Actions(driver);
        WebElement chooseFile = driver.findElement(By.tagName("input"));
        action.click(chooseFile);
        action.perform();
        action.sendKeys(chooseFile, "\\C:\\Users\\naama\\OneDrive\\Desktop\\picture.png");
//        driver.findElement(By.)

    }

}


