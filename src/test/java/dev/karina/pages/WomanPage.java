package dev.karina.pages;

import org.openqa.selenium.By;

public class WomanPage extends BasePage {
    //Locators
    private By menuWomanLocator = By.cssSelector("#accordian > div:nth-child(1) > div.panel-heading > h4 > a");
    private By submenuDressLocator = By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a");
    private By productType = By.cssSelector("body > section > div > div.row > div.col-sm-9.padding-right > div > h2");
    private By iframeLocator = By.xpath("/html/ins/div/iframe");
    private By iframeAdLocator = By.xpath("/html/body/div/div/div[2]/iframe");
    private By adsBtnClose = By.cssSelector("#dismiss-button"); 
    public void viewDressWoman() {
        if(super.isDisplayed(menuWomanLocator)){
            super.actionMoveToElementClickPerform(menuWomanLocator);

            super.findElementWithDelay(submenuDressLocator);
            super.actionMoveToElementClickPerform(submenuDressLocator);
            if(isDisplayed(iframeLocator)){
                closeAds(iframeLocator, iframeAdLocator, adsBtnClose); 
            }

        } else{
            System.out.println("Menu dress not found");
        }
    }

    

    public String getproductType(){
        return super.getText(productType);
    }
}
