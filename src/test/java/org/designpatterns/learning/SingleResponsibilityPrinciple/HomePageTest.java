package org.designpatterns.learning.SingleResponsibilityPrinciple;

import org.assertj.core.api.Assertions;
import org.designpatterns.learning.SingleresponsibilityPrinciple.domain.HomePage;
import org.designpatterns.learning.SingleresponsibilityPrinciple.domain.ResultPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HomePageTest extends BaseTest{

    private HomePage homePage;
    private ResultPage resultPage;

    @BeforeEach
    public void setupPage(){
        this.homePage = new HomePage(driver);
        this.resultPage = new ResultPage(driver);
    }

    @Test
    public void duckDuckGoflow(){
        String keyword = "Selenium WebDriver";
        int index = 3;
        homePage.goTo();
        Assertions.assertThat(homePage.getSearchWidget().isDisplayed());
        homePage.getSearchWidget().enterKeyWord(keyword);
        homePage.getSearchSuggestion().clickSuggestItemByIndex(index);
        resultPage.getSearchFilter().setRegionSwitchToIndia();
        resultPage.getNavigationBar().goToNews();
    }




}
