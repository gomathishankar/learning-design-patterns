package TemplatePattern;

import TemplateMethodPattern.AmazonComponents.AmazonShopping;
import TemplateMethodPattern.EbayComponents.EbayShopping;
import TemplateMethodPattern.ShoppingTemplate;
import org.designpatterns.learning.SingleResponsibilityPrinciple.BaseTest;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestingTemplatePattern extends BaseTest {

    @ParameterizedTest
    @MethodSource("shoppingSites")
    public void shoppingTest(ShoppingTemplate shopping){
        shopping.shop();
    }

    private Object[] shoppingSites(){
        return new Object[]{
                new EbayShopping(driver,"iPhone"),
                new AmazonShopping(driver,"iPhone")
        };

    }

}
