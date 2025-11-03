package com.learn;

import com.learn.base.BaseTest;
import com.learn.pages.*;
import com.learn.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class RegisterUserTest extends BaseTest {

    @Test
    void registerUser_happypath()
    {
        String name = "Romeo";
        String email = "romeo@yahoo.com";
        String password = "romeo123";

        HomePage home = new HomePage(page)
                .open()
                .handleConsent();

        assertTrue(home.title().toLowerCase().contains("automation") , "Title should contain 'automation'");


    }
}
