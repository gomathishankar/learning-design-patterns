package learning.designpattern.CommandPattern.udemy;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NotificationValidator extends ElementValidator {

    private final WebElement button;
    private final WebElement notification;

    public NotificationValidator(final WebElement button, final WebElement notification) {
        this.button = button;
        this.notification = notification;
    }


    @Override
    public boolean validate() {
        this.button.click();
        var appearanceState = this.notification.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        var disappearanceState = this.notification.isDisplayed();
        return appearanceState && (!disappearanceState);
    }
}
