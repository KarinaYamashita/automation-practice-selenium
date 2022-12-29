package dev.karina;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");
    }
    @AfterEach
    void tearDown() throws Exception{
        driver.quit();
    }
    @Test
    void test(){
        WebElement emailAddressLocator = driver.findElement(By.name("email"));
        emailAddressLocator.sendKeys("karina_test@gmail.com");
        
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("12345abc");
        
        WebElement submitBtnElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
        submitBtnElement.click();

        WebElement LogoutButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        String textLogoutButton = LogoutButton.getText();

        Assertions.assertTrue(textLogoutButton.equals("Logout"));
    }
}
