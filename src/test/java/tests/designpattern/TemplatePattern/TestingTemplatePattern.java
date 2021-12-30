package tests.designpattern.TemplatePattern;

import learning.designpattern.TemplateMethodPattern.AmazonComponents.AmazonShopping;
import learning.designpattern.TemplateMethodPattern.EbayComponents.EbayShopping;
import learning.designpattern.TemplateMethodPattern.ShoppingTemplate;
import tests.designpattern.BaseTest;
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
