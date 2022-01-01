package tests.designpattern.DecoratorPattern.Excercise1;

import learning.designpattern.DecoratorPattern.Excercise1.DashboardPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assertions.assertThat(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assertions.assertThat(!element.isDisplayed()));
    }

    //ingredients
    private static final Consumer<DashboardPage> adminCardsPresent = (dp) -> shouldDisplay(dp.getAdminCards());
    private static final Consumer<DashboardPage> adminCardsNotPresent = (dp) -> shouldNotDisplay(dp.getAdminCards());
    private static final Consumer<DashboardPage> guestCardsPresent = (dp) -> shouldDisplay(dp.getGuestCards());
    private static final Consumer<DashboardPage> guestCardsNotPresent = (dp) -> shouldNotDisplay(dp.getGuestCards());
    private static final Consumer<DashboardPage> superCardsPresent = (dp) -> shouldDisplay(dp.getSuperuserCards());
    private static final Consumer<DashboardPage> superCardsCardsNotPresent = (dp) -> shouldNotDisplay(dp.getSuperuserCards());

    //roleselection
    private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole("admin");
    private static final Consumer<DashboardPage> guestSelection = (dp) -> dp.selectRole("guest");
    private static final Consumer<DashboardPage> superUserSelection = (dp) -> dp.selectRole("superuser");

    //UserRolePage
    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestCardsPresent)
                                                            .andThen(superCardsCardsNotPresent)
                                                            .andThen(adminCardsNotPresent);

    public static final Consumer<DashboardPage> superUserPage = superUserSelection.andThen(superCardsPresent)
                                                                                .andThen(guestCardsPresent)
                                                                                .andThen(adminCardsNotPresent);

    public static final Consumer<DashboardPage> adminUserPage = adminSelection.andThen(superCardsPresent)
            .andThen(guestCardsPresent)
            .andThen(adminCardsPresent);
}

