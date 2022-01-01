package learning.designpattern.DecoratorPattern.Excercise1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DashboardPage {

    private WebDriver driver;

    @FindBy(id = "role")
    private WebElement role;

    @FindBy(css = "div.admin")
    private List<WebElement> adminCards;

    @FindBy(css = "div.guest")
    private List<WebElement> guestCards;

    @FindBy(css = "div.superuser")
    private List<WebElement> superuserCards;

    public DashboardPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }

    public void selectRole(String role) {
        Select select = new Select(this.role);
        select.selectByValue(role);
    }

    public List<WebElement> getGuestCards() {
        return guestCards;
    }

    public List<WebElement> getSuperuserCards() {
        return superuserCards;
    }

    public List<WebElement> getAdminCards() {
        return adminCards;
    }


}
