package dev.karina.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    //Locators
    private By nameLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    private By emailAdressLocator = By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]");
    private By btnSingupLocator = By.xpath("/html/body/section/div/div/div[3]/div/form/button");
    private By nameNewAccountLocator = By.xpath("/html/body/section/div/div/div/div/form/div[2]/input"); 
    private By emailLocator = By.xpath("/html/body/section/div/div/div/div/form/div[3]/input[1]");
    //Locators enter account information
    private By genderMaleLocator = By.xpath("/html/body/section/div/div/div/div/form/div[1]/div[1]/label/div/span/input");
    private By emailAddressAlreadyExist = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > p");
    private By btnDeleteAccountLocator = By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]/a");
    private By successfullyMessage = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    //private By genderFemaleLocator = By.xpath("/html/body/section/div/div/div/div/form/div[1]/div[2]/label/div/span/input");
    private By passwordLocator = By.xpath("/html/body/section/div/div/div/div/form/div[4]/input");
    private By dayLocator = By.xpath("/html/body/section/div/div/div/div/form/div[5]/div/div[1]/div/select");
    private By monthLocator = By.xpath("/html/body/section/div/div/div/div/form/div[5]/div/div[2]/div/select");
    private By yearLocator = By.xpath("/html/body/section/div/div/div/div/form/div[5]/div/div[3]/div/select");
    private By signNewsletterLocator = By.xpath("/html/body/section/div/div/div/div/form/div[6]/div/span/input");
    private By offersCheckboxLocator = By.xpath("/html/body/section/div/div/div/div/form/div[7]/div/span/input");
    //Locators address information
    private By customerFirstNameLocator = By.xpath("/html/body/section/div/div/div/div/form/p[1]/input");
    private By customerLastNameLocator = By.xpath("/html/body/section/div/div/div/div/form/p[2]/input");
    private By companyLocator = By.xpath("/html/body/section/div/div/div/div/form/p[3]/input");
    private By addressLocator = By.xpath("/html/body/section/div/div/div/div/form/p[4]/input");
    private By address2Locator = By.xpath("/html/body/section/div/div/div/div/form/p[5]/input");
    private By countryLocator = By.xpath("/html/body/section/div/div/div/div/form/p[6]/select");
    private By stateLocator = By.xpath("/html/body/section/div/div/div/div/form/p[7]/input");
    private By cityLocator = By.xpath("/html/body/section/div/div/div/div/form/p[8]/input");
    private By zipcodeLocator = By.xpath("/html/body/section/div/div/div/div/form/p[9]/input");
    private By mobileNumberLocator = By.xpath("/html/body/section/div/div/div/div/form/p[10]/input");
    private By btnCreateAccountLocator = By.xpath("/html/body/section/div/div/div/div/form/button");
    private By btnLoginLocator = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
    private By iframeLocator = By.xpath("/html/ins/div/iframe");
    private By iframeAdLocator = By.xpath("/html/body/div/div/div[2]/iframe");
    private By adsBtnClose = By.cssSelector("#dismiss-button"); 

    public void insertEmailToRegister(String name, String email) {
        if(isDisplayed(emailAdressLocator)){
            super.type(name, nameLocator);
            super.type(email, emailAdressLocator);
            click(btnSingupLocator);
        }else{
            System.out.println("email texbox not present");
        }
    }
    public String getNameNewAccount() {
        return super.getTextByAttribute(this.nameNewAccountLocator, "value");
    }
    public String getEmailNewAccount() {
        return super.getTextByAttribute(this.emailLocator, "value");
    }

    public String getSuccessfullyMessage() {
        super.findElementWithDelay(successfullyMessage);
        return super.getText(successfullyMessage);
    }

    public String getEmailAddressAlreadyExist() {
        super.findElementWithDelay(emailAddressAlreadyExist);
        return super.getText(emailAddressAlreadyExist);
    }

    public void fillOutForm(String name, String email) {
        this.insertEmailToRegister(name, email);
        if(super.isDisplayed(genderMaleLocator)){
            //super.click(genderFemaleLocator);
            super.click(genderMaleLocator);
            super.type("12345", passwordLocator);
            super.selectByValue(dayLocator, "12");
            super.selectByValue(monthLocator, "9");
            super.selectByValue(yearLocator, "1990");
            super.click(signNewsletterLocator);
            super.click(offersCheckboxLocator);
            super.type("Karina", customerFirstNameLocator);
            super.type("Yamashita", customerLastNameLocator);
            super.type("DIO", companyLocator);
            super.type("Street Name, 123", addressLocator);
            super.type("Street Name2, 2123", address2Locator);
            super.selectByValue(countryLocator, "United States");
            super.type("Florida", stateLocator);
            super.type("Orlando", cityLocator);
            super.type("0000000", zipcodeLocator);
            super.type("99999999", mobileNumberLocator);
            super.click(btnCreateAccountLocator);
        }else{
            System.out.println("message not found.");
        }
    }

    public void deleteAccount() {
        super.click(btnLoginLocator);
        if(isDisplayed(iframeLocator)){
            closeAds(iframeLocator, iframeAdLocator, adsBtnClose); 
        }
        super.clickWithDelay(btnDeleteAccountLocator);
    }
}
