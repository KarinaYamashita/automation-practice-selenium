package dev.karina.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    //Locators
    private By emailAddressLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By submitBtnLocator = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    private By btnLogoutLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By userNameLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b");

    public void signin() {
        if(super.isDisplayed(emailAddressLocator)){
            super.type("karina_test@gmail.com", emailAddressLocator);
            super.type("12345abc", passwordLocator);
            super.click(submitBtnLocator);
        }else{
            System.out.println("Email textbox wasn't present");
        }
    }

    public String getLogoutBtn (){
        return super.getText(btnLogoutLocator);
    } 

    public String getUserName (){
        return super.getText(userNameLocator);
    }
}
