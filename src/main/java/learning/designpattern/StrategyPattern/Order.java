package learning.designpattern.StrategyPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Order {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#buy")
    private WebElement buyNowCTA;

    @FindBy(css = "#ordernumber")
    private WebElement orderNumber;


    public Order(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void buy() {
        this.wait.until((d) -> this.buyNowCTA.isDisplayed());
        this.buyNowCTA.click();
    }

    public void getOrder() {
        this.wait.until((d) -> this.orderNumber.isDisplayed());
        System.out.println(this.orderNumber.getText());
    }

}
