package TemplateMethodPattern.EbayComponents;

import TemplateMethodPattern.ShoppingTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EbayShopping extends ShoppingTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(css = "[type='text']")
    private WebElement searchBar;

    @FindBy(css = "#gh-btn")
    private WebElement searchButton;

    @FindBy(css = "ul li.s-item h3")
    private List<WebElement> searchResults;

    @FindBy(css = "span#prcIsum")
    private WebElement priceOfProduct;

    public EbayShopping(final WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.ebay.com/");
    }

    @Override
    public void searchForProduct() {
        this.wait.until((d) -> this.searchBar.isDisplayed());
        this.searchBar.sendKeys(product);
        this.searchButton.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until((d) -> this.searchResults.get(0).isDisplayed());
        this.searchResults.get(0).click();
        var mainWindow = this.driver.getWindowHandle();
        var windows = this.driver.getWindowHandles();
        var iterators = windows.iterator();
        while (iterators.hasNext()){
            var requiredWindow = iterators.next();
            if (!mainWindow.equalsIgnoreCase(requiredWindow)) {
                this.driver.switchTo().window(requiredWindow);
            }
        }
    }

    @Override
    public void extractPrice() {
        this.wait.until((d) -> this.priceOfProduct.isDisplayed());
        System.out.println(this.priceOfProduct.getText());
    }
}
