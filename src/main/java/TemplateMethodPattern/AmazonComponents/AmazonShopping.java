package TemplateMethodPattern.AmazonComponents;

import TemplateMethodPattern.ShoppingTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonShopping extends ShoppingTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    private SearchPage searchPage;
    private DetailsPage detailsPage;
    private SearchResultPage searchResultPage;

    public AmazonShopping(final WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.searchPage = PageFactory.initElements(driver, SearchPage.class);
        this.detailsPage = PageFactory.initElements(driver, DetailsPage.class);
        this.searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
    }

    @Override
    public void launchSite() {
        this.searchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        this.searchPage.search(product);
    }

    @Override
    public void selectProduct() {
        this.searchResultPage.selectProduct();
    }

    @Override
    public void extractPrice() {
        this.detailsPage.extractPrice();
    }
}
