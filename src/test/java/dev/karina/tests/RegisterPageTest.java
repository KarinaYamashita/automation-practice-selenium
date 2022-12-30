package dev.karina.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.karina.pages.RegisterPage;

public class RegisterPageTest {
    private RegisterPage registerPage;
    private final String URL = "https://automationexercise.com/login";
    String name = "karina";
    
    
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
    void testInsertNewUserSuccessfuly(){
        String email = "karina15@email.com";
        //when
        this.registerPage.insertEmailToRegister(name, email);
        //then
        Assertions.assertTrue(name.equalsIgnoreCase(this.registerPage.getNameNewAccount()));
        Assertions.assertEquals(email, this.registerPage.getEmailNewAccount());
    }
    
    @Test
    void testFillOutFormSuccessfuly(){
        String email = "karina22@email.com";
        //when
        this.registerPage.fillOutForm(name, email);
        //then
        Assertions.assertTrue("ACCOUNT CREATED!".equalsIgnoreCase(this.registerPage.getSuccessfullyMessage()));
        Assertions.assertFalse(this.URL.equals(this.registerPage.getCurrentUrl()));
        this.registerPage.deleteAccount();
    }

    @Test
    void testInsertNewUserExistent() {
        String email = "karina_test@gmail.com";
        //when
        this.registerPage.insertEmailToRegister(name, email);
        //then
        String message = this.registerPage.getEmailAddressAlreadyExist();
        Assertions.assertTrue("Email Address already exist!".equalsIgnoreCase(message));
    }

   
}
