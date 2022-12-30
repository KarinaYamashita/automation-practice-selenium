package dev.karina.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.karina.pages.RegisterPage;

public class RegisterPageTest {
    private RegisterPage registerPage;
    private final String URL = "https://automationexercise.com/login";

    @BeforeEach
    void setUp() throws Exception{
        this.registerPage = new RegisterPage();
        this.registerPage.visit(URL);
    }

    @AfterEach
    void tearDown() throws Exception{
        this.registerPage.quitWebDriver();
    }
    @Test
    void testInsertNewUser(){
        String name = "karina";
        String email = "karina321@email.com";
        //when
        this.registerPage.insertEmailToRegister(name, email);
        //then
        Assertions.assertTrue(name.equalsIgnoreCase(this.registerPage.getNameNewAccount()));
        Assertions.assertEquals(email, this.registerPage.getEmailNewAccount());
    }

    @Test
    void testFillOutForm(){
        //when
        this.registerPage.fillOutForm();
        //then
        Assertions.assertTrue("ACCOUNT CREATED!".equalsIgnoreCase(this.registerPage.getSuccessfullyMessage()));
        Assertions.assertFalse(this.URL.equals(this.registerPage.getCurrentUrl()));
    }
}
