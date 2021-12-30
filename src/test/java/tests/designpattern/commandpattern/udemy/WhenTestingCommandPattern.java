package tests.designpattern.commandpattern.udemy;

import learning.designpattern.CommandPattern.udemy.HomePage;
import org.assertj.core.api.Assertions;
import tests.designpattern.BaseTest;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


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
