package learning.designpattern.ProxyPattern;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderComponentProxy implements OrderComponent {

    private OrderComponent orderComponent;
    private static final List<String> EXCLUDED = Arrays.asList("PROD", "STAGE");

    public OrderComponentProxy(WebDriver driver) {
        String currenEnv = System.getProperty("env");
        if (!EXCLUDED.contains(currenEnv))
            this.orderComponent = new OrderComponentReal(driver);
    }

    @Override
    public String placeOrder() {
        if (Objects.nonNull(this.orderComponent)) {
            return this.orderComponent.placeOrder();
        } else {
            return "SKIPPED";
        }
    }
}
