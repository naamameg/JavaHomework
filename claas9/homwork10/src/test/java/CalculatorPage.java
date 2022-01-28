import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {

    private WebDriver driver;

    public CalculatorPage(){
        this.driver = SingletonDriver.getDriverInstance();
        this.driver.get(Constants.calculatorURL);
    }

//    public void openCalculatorPage(){
//        driver.get(Constants.calculatorURL);
//    }
    public WebElement findElementInPage(String value){
        return driver.findElement(By.id(value));

    }

    public void clickElementInPage(String element){
        WebElement web_Element = findElementInPage(element);
        web_Element.click();
    }

    public String getElementText(String element){
        return findElementInPage(element).getText();
    }


}
