package org.designpatterns.learning.SingleresponsibilityPrinciple.Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent{

    @FindBy(name="q")
    private WebElement searchBarOnResultPage;

    @FindBy(css="[data-zci-link='images']")
    private WebElement imageLink;

    @FindBy(css="[data-zci-link='news']")
    private WebElement newsLink;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToImages(){
        this.imageLink.click();
    }

    public void goToNews(){
        this.newsLink.isDisplayed();
        this.newsLink.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(((driver) -> imageLink.isDisplayed() && newsLink.isDisplayed()));
    }
}
