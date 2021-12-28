package org.designpatterns.learning.SingleresponsibilityPrinciple.Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractComponent {
    public abstract boolean isDisplayed();

    protected WebDriverWait wait;

    public AbstractComponent(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
}
