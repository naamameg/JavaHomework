import io.netty.util.Constant;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNG {

    ChromeDriver driver;
    @BeforeClass
    public void openChrome(){
       driver = SingletonDriver.getDriverInstance();
    }

    @Test
    public void printSeven(){
        driver.get(Constants.calculatorURL);
        System.out.println(driver.findElement(By.id(Constants.seven)).getSize());

    }

    @Test
    public void sixDisplay(){
        driver.get(Constants.calculatorURL);
        driver.findElement(By.id(Constants.six)).isDisplayed();
    }

    @Test
    public void mathematicalFormula(){
        CalculatorPage page = new CalculatorPage();
//        page.openCalculatorPage();
        page.clickElementInPage(Constants.seven);
        page.clickElementInPage(Constants.minus);
        page.clickElementInPage(Constants.four);
        page.clickElementInPage(Constants.equal);
        assertEquals(Integer.parseInt(page.getElementText(Constants.screen)), Constants.number);;



//        driver.get(Constants.calculatorURL);
//        driver.findElement(By.id(Constants.seven)).click();
//        driver.findElement(By.id(Constants.minus)).click();
//        driver.findElement(By.id(Constants.four)).click();
//        driver.findElement(By.id(Constants.equal)).click();
//        int result = Integer.parseInt(driver.findElement(By.id("screen")).getText());
//        assertEquals(result, Constants.number);

    }

    }






