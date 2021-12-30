package tests.designpattern.FactoryPattern;

import learning.designpattern.FactoryPattern.GoogleFactory;
import learning.designpattern.FactoryPattern.GoogleLanguageSites;
import learning.designpattern.FactoryPattern.GooglePage;
import tests.designpattern.BaseTest;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static learning.designpattern.FactoryPattern.GoogleLanguageSites.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WhenTestingForFactoryDesignPattern extends BaseTest {

    private GooglePage googlePage;


    @ParameterizedTest
    @MethodSource("siteLanguageAndKeywordToTest")
    public void shouldTestFactoryPattern(GoogleLanguageSites lang, String keyword) {
        this.googlePage = GoogleFactory.get(lang, driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultCount();
        System.out.println(resultCount);
    }

    public static Object[][] siteLanguageAndKeywordToTest() {
        return new Object[][]{
                {ENGLISH, "2022"},
                {FRENCH, "Eiffel Tower"},
                {ARABIC, "iPhone"}
        };
    }
}
