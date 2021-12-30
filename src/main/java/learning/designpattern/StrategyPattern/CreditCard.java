package learning.designpattern.StrategyPattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CreditCard implements PaymentOption{


    @FindBy(css = "#cc")
    private WebElement creditCardNumber;

    @FindBy(css = "#year")
    private WebElement year;

    @FindBy(css = "#cvv")
    private WebElement cvv;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        this.creditCardNumber.sendKeys(paymentDetails.get("cc"));
        this.year.sendKeys(paymentDetails.get("year"));
        this.cvv.sendKeys(paymentDetails.get("cvv"));
    }
}
