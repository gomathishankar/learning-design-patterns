package learning.designpattern.TemplateMethodPattern.AmazonComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "[data-component-type=\"s-search-results\"] div.a-section h2 a")
    private List<WebElement> searchResults;

    public SearchResultPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void selectProduct() {
        this.wait.until((d)->this.searchResults.get(0).isDisplayed());
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

}
