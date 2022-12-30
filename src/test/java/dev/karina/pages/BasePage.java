package dev.karina.pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private WebDriver driver;
    private Actions action;
    private Select select;  
    private ChromeOptions options;
    
    public  BasePage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        options = new ChromeOptions();
        options.addArguments("--headless");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    public void visit(String url) {
        this.driver.get(url);
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void quitWebDriver() {
        this.driver.quit();
    }
    public WebElement findElement(By locator) {
        return this.driver.findElement(locator);
    }

    public void type(String input, By locator){
        findElementWithDelay(locator).sendKeys(input);
    }

    public Boolean isDisplayed(By locator){
        try {
            return this.driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } 
        
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void clickWithDelay(By locator) {
        findElementWithDelay(locator).click();
    }
    
    public String getText(By locator){
       return this.driver.findElement(locator).getText();
    }

    public String getTextByAttribute(By locator, String attributeName) {
        return this.driver.findElement(locator).getAttribute(attributeName); 
    }

    public void actionMoveToElementPerform(By locator) {
        if(this.action == null){
            this.action = new Actions(this.driver);
        }
        WebElement element = this.driver.findElement(locator);
        action.moveToElement(element).perform();;
    }
    public void actionMoveToElementClickPerform(By locator) {
        if(this.action == null){
            this.action = new Actions(this.driver);
        }
        // WebElement element = this.driver.findElement(locator);
        WebElement element = findElementWithDelay(locator);
        
        action.moveToElement(element).click().build().perform();
    }

    public void intoIframe(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));  
    }

    public void leaveIframe() {
        driver.switchTo().defaultContent();
    }
    
    public WebElement findElementWithDelay(By locator){
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));             
        } catch (Exception e){
            return this.driver.findElement(locator);
        }
    }

    public void selectByValue(By locator, String value) {
        select = new Select(findElement(locator));
        select.selectByValue(value);
    }

    public void clear(By locator) {
        this.driver.findElement(locator).clear();
    }

    public void closeAds(By iframeLocator, By iframeAdLocator, By adsBtnClose) {
        intoIframe(iframeLocator);
        intoIframe(iframeAdLocator);
        clickWithDelay(adsBtnClose);
        leaveIframe();
        leaveIframe();
    }

}
