package learning.designpattern.TemplateMethodPattern;

public abstract class ShoppingTemplate {
    public abstract void launchSite();
    public abstract void searchForProduct();
    public abstract void selectProduct();
    public abstract void extractPrice();


    public void shop(){
        launchSite();
        searchForProduct();
        selectProduct();
        extractPrice();
    }
}
