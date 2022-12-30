package dev.karina.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.karina.pages.WomanPage;

public class WomanPageTest {
    private WomanPage womanPage;
    private final String URL = "https://automationexercise.com/";
   
    
    @BeforeEach
    void setUp() throws Exception{
        womanPage = new WomanPage();
        womanPage.visit(URL);
    }
    @AfterEach
    void tearDown() throws Exception{
        womanPage.quitWebDriver();
    }

    @Test
    void test(){
        //when
        this.womanPage.viewDressWoman();
        
       Assertions.assertEquals("https://automationexercise.com/category_products/1",this.womanPage.getCurrentUrl());
        Assertions.assertTrue(this.womanPage.getproductType().equalsIgnoreCase("Women - Dress Products"));
        Assertions.assertFalse(this.womanPage.getCurrentUrl().equals(URL));
        
    }
}
