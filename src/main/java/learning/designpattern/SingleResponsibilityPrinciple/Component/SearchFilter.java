package learning.designpattern.SingleResponsibilityPrinciple.Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFilter extends AbstractComponent {

    @FindBy(css = ".search-filters.js-vertical-filters")
    private WebElement searchFilter;

    @FindBy(css=".js-region-filter-switch")
    private WebElement regionFilterSwitch;

    public SearchFilter(WebDriver driver) {
        super(driver);
    }

    public void setRegionSwitchToIndia(){
        if(regionFilterSwitch.getAttribute("class").contains("is-on")){
            System.out.println("region switch is on");
        } else{
            regionFilterSwitch.click();
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) ->regionFilterSwitch.isDisplayed());
    }
}
