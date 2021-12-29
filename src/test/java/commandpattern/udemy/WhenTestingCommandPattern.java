package commandpattern.udemy;

import CommandPattern.udemy.HomePage;
import org.assertj.core.api.Assertions;
import org.designpatterns.learning.SingleResponsibilityPrinciple.BaseTest;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.NoSuchElementException;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WhenTestingCommandPattern extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    public void setHomePage(){
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest(){
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .map(elementValidator -> elementValidator.validate())
                .forEach(b -> Assertions.assertThat(b));
    }



}
