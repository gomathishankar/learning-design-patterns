package learning.designpattern.ProxyPattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class PayPal implements PaymentOption {


    @FindBy(css = "#paypal_username")
    private WebElement paypalUserName;

    @FindBy(css = "#paypal_password")
    private WebElement paypalPassword;


    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        this.paypalUserName.sendKeys(paymentDetails.get("paypalUserName"));
        this.paypalPassword.sendKeys(paymentDetails.get("paypalPassword"));
    }
}
