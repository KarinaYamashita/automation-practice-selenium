package dev.karina.pages;

import org.openqa.selenium.By;

public class WomanPage extends BasePage {
    //Locators
    private By menuWomanLocator = By.cssSelector("#accordian > div:nth-child(1) > div.panel-heading > h4 > a");
    private By submenuDressLocator = By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a");
    private By productType = By.cssSelector("body > section > div > div.row > div.col-sm-9.padding-right > div > h2");
    private By iframeLocator = By.xpath("/html/ins/div/iframe");
    private By iframeAdLocator = By.xpath("/html/body/div/div/div[2]/iframe");
    private By adsClose = By.cssSelector("#dismiss-button"); 
    public void viewDressWoman() {
        if(super.isDisplayed(menuWomanLocator)){
            super.actionMoveToElementClickPerform(menuWomanLocator);

            super.findElementWithDelay(submenuDressLocator);
            super.actionMoveToElementClickPerform(submenuDressLocator);
            closeAds(); 

        } else{
            System.out.println("Menu dress not found");
        }
    }

    public void closeAds() {
        super.intoIframe(iframeLocator);
        super.intoIframe(iframeAdLocator);
        clickWithDelay(adsClose);
        super.leaveIframe();
        super.leaveIframe();

    }


    public String getproductType(){
        return super.getText(productType);
    }
}
