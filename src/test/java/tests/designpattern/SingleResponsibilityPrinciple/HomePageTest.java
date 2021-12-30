package tests.designpattern.SingleResponsibilityPrinciple;

import org.assertj.core.api.Assertions;
import learning.designpattern.SingleResponsibilityPrinciple.domain.HomePage;
import learning.designpattern.SingleResponsibilityPrinciple.domain.ResultPage;
import tests.designpattern.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HomePageTest extends BaseTest {

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
