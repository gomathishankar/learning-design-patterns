package tests.designpattern.ProxyPattern;

import learning.designpattern.ProxyPattern.*;
import tests.designpattern.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProxyPatternTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeAll
    public void setPaymentScreen() {
        System.setProperty("env","PROD");
        this.paymentScreen = new PaymentScreen(driver);
    }

    @ParameterizedTest
    @MethodSource("getPaymentParam")
    public void paymentTest(PaymentOption paymentOption, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterUserInformation("GS", "ls", "test@test.com");
        this.paymentScreen.setPaymentOption(paymentOption);
        this.paymentScreen.getPaymentOption().enterPaymentInformation(paymentDetails);
        this.paymentScreen.getOrder().placeOrder();
    }

    public Object[][] getPaymentParam() {
        Map<String, String> cc = Map.of("cc", "1231231231",
                "year", "2023",
                "cvv", "123");

        Map<String, String> nb = Map.of("bankName", "WELLS FARGO",
                "account", "myacc123",
                "pin", "999");

        Map<String, String> pp = Map.of("paypalUserName", "gs",
                "paypalPassword", "myacc123");

        return new Object[][]{
                {new CreditCard(), cc},
                {new NetBanking(), nb},
                {new PayPal(), pp}
        };
    }
}
