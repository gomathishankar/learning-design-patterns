package TemplateMethodPattern.AmazonComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "input#twotabsearchtextbox")
    private WebElement searchBar;

    @FindBy(css = "input#nav-search-submit-button")
    private WebElement searchButton;

     public SearchPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected void goTo(){
        this.driver.get("https://www.amazon.in");
    }

    protected void search(String product){
        this.wait.until((d)->this.searchBar.isDisplayed());
        this.searchBar.sendKeys(product);
        this.searchButton.click();
    }
}
