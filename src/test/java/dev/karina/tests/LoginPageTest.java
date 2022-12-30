package dev.karina.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.karina.pages.LoginPage;

public class LoginPageTest {
    private LoginPage loginPage;
    private final String URL = "https://automationexercise.com/login";
    
    @BeforeEach
    void setUp() throws Exception{
        loginPage = new LoginPage();
        loginPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception{
        loginPage.quitWebDriver();
    }
    @Test
    void testLoginSuccessfuly(){
        //when
        loginPage.signin();
        //then
        Assertions.assertTrue(this.loginPage.getLogoutBtn().equals("Logout"));
        Assertions.assertTrue(this.loginPage.getUserName().equalsIgnoreCase("Karina"));
        Assertions.assertFalse(this.loginPage.getCurrentUrl().equals(URL));
    }
}
