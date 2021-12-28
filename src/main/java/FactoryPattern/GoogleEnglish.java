package FactoryPattern;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleEnglish extends GooglePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "q")
    protected WebElement searchBox;

    @FindBy(name = "btnk")
    protected WebElement searchBtn;

    @FindBy(css = "div.vJOb1e")
    private List<WebElement> results;

    public GoogleEnglish(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);

    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        for (Character ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
        this.searchBox.sendKeys(Keys.ENTER);
  //     this.wait.until((d) -> this.searchBtn.isDisplayed());
//        this.searchBtn.click();
    }

    @Override
    public int getResultCount() {
        this.wait.until((d) -> this.results.size() > 1);
        return this.results.size();
    }
}
