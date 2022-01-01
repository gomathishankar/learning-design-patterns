package tests.designpattern.DecoratorPattern.Excercise2;


import learning.designpattern.DecoratorPattern.Excercise2.PaymentPage;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class PaymentScreenDecorator {

    private static final Consumer<PaymentPage> applyFreeCoupon = (pp)-> pp.enterCoupon("FREEUDEMY");
    private static final Consumer<PaymentPage> applyPartialCoupon = (pp) ->pp.enterCoupon("PARTIALUDEMY");
    private static final Consumer<PaymentPage> enterValidCreditCard = (pp)->pp.enterPayment("4111111111111111","2023","123");
    private static final Consumer<PaymentPage> enterInValidCreditCard = (pp)->pp.enterPayment("4111111111111111","2020","123");
    public static final Predicate<PaymentPage> successStatus = (pp)->pp.getStatus().equalsIgnoreCase("PASS");
    public static final Predicate<PaymentPage> failStatus = (pp)->pp.getStatus().equalsIgnoreCase("FAIL");
    private static final Consumer<PaymentPage> pay = (pp)->pp.buyNow();

    public static final Consumer<PaymentPage> usingValidCC = enterValidCreditCard.andThen(pay);
    public static final Consumer<PaymentPage> usingValidCCAndDiscounterPromo = enterValidCreditCard.andThen(applyPartialCoupon).andThen(pay);
    public static final Consumer<PaymentPage> usingFreePromocode = applyFreeCoupon.andThen(pay);
    public static final Consumer<PaymentPage> usingInValidCC = enterInValidCreditCard.andThen(pay);
    public static final Consumer<PaymentPage> usingInValidCCAndDiscounterPromo = enterInValidCreditCard.andThen(applyPartialCoupon).andThen(pay);
    public static final Consumer<PaymentPage> UsingNoCCAndPromo = pay;


}
