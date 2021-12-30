package learning.designpattern.ProxyPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class NetBanking implements PaymentOption {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#bank")
    private WebElement bankInformation;

    @FindBy(css = "#acc_number")
    private WebElement accountNumber;

    @FindBy(css = "#pin")
    private WebElement pin;

    private void selectBank(String bankName) {
        Select bankDropDown = new Select(bankInformation);
        bankDropDown.selectByVisibleText(bankName);
    }

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        this.selectBank(paymentDetails.get("bankName"));
        this.accountNumber.sendKeys(paymentDetails.get("account"));
        this.pin.sendKeys(paymentDetails.get("pin"));
    }
}
