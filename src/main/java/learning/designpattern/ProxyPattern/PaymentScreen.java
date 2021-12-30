package learning.designpattern.ProxyPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentScreen {

    private WebDriver driver;
    private UserInformation userInformation;
    private OrderComponent order;
    private PaymentOption paymentOption;

    public PaymentScreen(final WebDriver driver) {
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver, UserInformation.class);
        this.order = new OrderComponentProxy(driver);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInformation getUserInformation(){
        return userInformation;
    }

    public OrderComponent getOrder(){
        return order;
    }

    public void setPaymentOption(PaymentOption paymentOption){
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver,this.paymentOption);
    }

    public PaymentOption getPaymentOption(){
        return this.paymentOption;
    }

}
