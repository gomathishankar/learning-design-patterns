package learning.designpattern.SingleResponsibilityPrinciple.domain;

import learning.designpattern.SingleResponsibilityPrinciple.Component.SearchSuggestion;
import learning.designpattern.SingleResponsibilityPrinciple.Component.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;

    public HomePage(final WebDriver driver){
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver,SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver,SearchSuggestion.class);
    }

    public void goTo(){
        this.driver.get("https://www.duckduckgo.com");
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }
}
