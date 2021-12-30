package learning.designpattern.CommandPattern.udemy;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DismissalAlertValidator extends ElementValidator{
    private final WebElement dismissalAlert;

    public DismissalAlertValidator(final WebElement dismissalAlert) {
        this.dismissalAlert = dismissalAlert;
    }

    @Override
    public boolean validate() {
        var appearanceState = this.dismissalAlert.isDisplayed();
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        var disappearanceState = this.dismissalAlert.isDisplayed();
        return appearanceState && (!disappearanceState);
    }
}
