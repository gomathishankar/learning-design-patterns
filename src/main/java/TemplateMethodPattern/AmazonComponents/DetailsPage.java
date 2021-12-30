package TemplateMethodPattern.AmazonComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailsPage {

    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "span.apexPriceToPay")
    private WebElement priceOfProduct;

    public DetailsPage(final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void extractPrice() {
        this.wait.until((d)->this.priceOfProduct.isDisplayed());
        System.out.println(this.priceOfProduct.getText());
    }
}
