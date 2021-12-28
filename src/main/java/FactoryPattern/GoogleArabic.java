package FactoryPattern;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleArabic extends GoogleEnglish {

    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private WebElement language;

    @FindBy(css = "span.ly0Ckb")
    private WebElement keyboardbtn;

    @FindBy(id = "kbd")
    private WebElement keyboard;

    @FindBy(css = "div.tF2Cxc")
    private List<WebElement> results;


    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com.sa");
        this.language.click();
    }

    @Override
    public void search(String keyword) {
        this.wait.until((d) -> this.keyboardbtn.isDisplayed());
        this.keyboardbtn.click();
        this.wait.until((d) -> this.keyboard.isDisplayed());
        for (Character ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
        this.searchBox.sendKeys(Keys.ENTER);
    }

    @Override
    public int getResultCount() {
        this.wait.until((d) -> this.results.size() > 1);
        return this.results.size();
    }
}
