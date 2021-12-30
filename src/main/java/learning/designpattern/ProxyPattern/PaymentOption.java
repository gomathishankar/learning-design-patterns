package learning.designpattern.ProxyPattern;

import java.util.Map;

public interface PaymentOption {
    void enterPaymentInformation(Map<String,String> paymentDetails);
}
