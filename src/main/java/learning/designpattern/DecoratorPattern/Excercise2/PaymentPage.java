package learning.designpattern.DecoratorPattern.Excercise2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    private WebDriver driver;

    @FindBy(id = "coupon")
    private WebElement coupon;

    @FindBy(id = "couponbtn")
    private WebElement couponButton;

    @FindBy(css = "#cc")
    private WebElement creditCardNumber;

    @FindBy(css = "#year")
    private WebElement year;

    @FindBy(css = "#cvv")
    private WebElement cvv;

    @FindBy(id = "price")
    private WebElement price;

    @FindBy(id = "buy")
    private WebElement buyNowCTA;

    @FindBy(id = "status")
    private WebElement paymentStatus;

    public PaymentPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public void buyNow() {
        this.buyNowCTA.click();
    }

    public void enterPayment(String cc, String year, String cvv) {
        this.creditCardNumber.sendKeys(cc);
        this.year.sendKeys(year);
        this.cvv.sendKeys(cvv);
    }

    public void enterCoupon(String coupon) {
        this.coupon.sendKeys(coupon);
        this.couponButton.click();
    }

    public String getStatus(){
        var status = this.paymentStatus.getText();
        return status;
    }

}
