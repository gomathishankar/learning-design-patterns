package StrategyPattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInformation {

    @FindBy(css = "#fn")
    private WebElement firstName;

    @FindBy(css = "#ln")
    private WebElement lastName;

    @FindBy(css = "#email")
    private WebElement email;

    public void enterUserInformation(String firstName, String lastName, String email) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
    }

}
