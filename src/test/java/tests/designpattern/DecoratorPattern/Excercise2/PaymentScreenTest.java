package tests.designpattern.DecoratorPattern.Excercise2;

import learning.designpattern.DecoratorPattern.Excercise2.PaymentPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import tests.designpattern.BaseTest;

import java.util.function.Consumer;
import java.util.function.Predicate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PaymentScreenTest extends BaseTest {

    private PaymentPage paymentPage;

    @BeforeAll
    public void setPaymentScreenTest(){
        this.paymentPage = new PaymentPage(driver);
    }

    @ParameterizedTest
    @MethodSource("getPaymentStatus")
    public void paymentTest(Consumer<PaymentPage> paymode, Predicate<PaymentPage> result){
        this.paymentPage.goTo();
        paymode.accept(this.paymentPage);
        Assertions.assertThat(result.test(this.paymentPage)).isEqualTo(true);
    }

    private Object[][] getPaymentStatus(){
        return new Object[][]{
                {PaymentScreenDecorator.usingFreePromocode ,PaymentScreenDecorator.successStatus},
                {PaymentScreenDecorator.usingValidCC ,PaymentScreenDecorator.successStatus},
                {PaymentScreenDecorator.usingValidCCAndDiscounterPromo ,PaymentScreenDecorator.successStatus},
                {PaymentScreenDecorator.usingInValidCC ,PaymentScreenDecorator.failStatus},
                {PaymentScreenDecorator.usingInValidCCAndDiscounterPromo ,PaymentScreenDecorator.failStatus},
                {PaymentScreenDecorator.UsingNoCCAndPromo ,PaymentScreenDecorator.failStatus},
        };
    }
}
