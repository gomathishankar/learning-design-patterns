package org.designpatterns.learning.SingleresponsibilityPrinciple.Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchSuggestion extends AbstractComponent {

    @FindBy(css = "div.acp-wrap > .acp")
    private List<WebElement> autoSuggestedResult;

    public SearchSuggestion(WebDriver driver) {
        super(driver);
    }

    public void clickSuggestItemByIndex(int itemToSelect) {
        this.autoSuggestedResult.get(itemToSelect - 1).click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.autoSuggestedResult.size() > 2);
    }
}
