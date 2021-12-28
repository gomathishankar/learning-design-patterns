package org.designpatterns.learning.SingleresponsibilityPrinciple.domain;

import org.designpatterns.learning.SingleresponsibilityPrinciple.Component.NavigationBar;
import org.designpatterns.learning.SingleresponsibilityPrinciple.Component.SearchFilter;
import org.designpatterns.learning.SingleresponsibilityPrinciple.Component.SearchSuggestion;
import org.designpatterns.learning.SingleresponsibilityPrinciple.Component.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {

    private WebDriver driver;
    private NavigationBar navigationBar;
    private SearchSuggestion searchSuggestion;
    private SearchFilter searchFilter;
    private SearchWidget searchWidget;

    public ResultPage(final WebDriver driver) {
        this.driver = driver;
        this.searchFilter = PageFactory.initElements(driver, SearchFilter.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);

    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }


    public SearchFilter getSearchFilter() {
        return searchFilter;
    }


}
