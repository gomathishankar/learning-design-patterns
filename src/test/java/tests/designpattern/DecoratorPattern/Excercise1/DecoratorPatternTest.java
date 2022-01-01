package tests.designpattern.DecoratorPattern.Excercise1;

import learning.designpattern.DecoratorPattern.Excercise1.DashboardPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.designpattern.BaseTest;

import java.util.function.Consumer;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DecoratorPatternTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeAll
    public void setDashboardPage(){
        this.dashboardPage = new DashboardPage(driver);
    }

    @ParameterizedTest
    @MethodSource("getUserPages")
    public void roleTest(Consumer<DashboardPage> role){
        this.dashboardPage.goTo();
        role.accept(this.dashboardPage);
    }

    private Object[] getUserPages(){
        return new Object[] {
                Decorators.guestPage,
                Decorators.adminUserPage,
                Decorators.superUserPage
        };
    }
}
