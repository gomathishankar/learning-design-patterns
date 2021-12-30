package learning.designpattern.ProxyPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponentReal implements OrderComponent{

    @FindBy(css = "#buy")
    private WebElement buyNowCTA;

    @FindBy(css = "#ordernumber")
    private WebElement orderNumber;

    public OrderComponentReal(final WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @Override
    public String placeOrder() {
        this.buyNowCTA.click();
        return this.orderNumber.getText();
    }
}
