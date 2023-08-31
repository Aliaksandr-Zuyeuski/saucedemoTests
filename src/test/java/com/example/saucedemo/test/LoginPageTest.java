package com.example.saucedemo.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.saucedemo.data.DataHelper;
import com.example.saucedemo.page.LoginPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://www.saucedemo.com/");
    }

    @Test
    void standardUserLoginTest () {
        LoginPage loginPage = new LoginPage();

        loginPage.logIn(DataHelper.getUserInfo());

        String actualTitle = loginPage.getTitleValue();
        String expectedTitle = "Products";

        Assertions.assertEquals(expectedTitle, actualTitle);

    }



    @Test
    void emptyPasswordValidationTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.logIn("user", "");

        String actualValidationErrorMessage = loginPage.getValidationErrorMessage();
        String expectedValidationErrorMessage = "Epic sadface: Password is required";

        Assertions.assertEquals(expectedValidationErrorMessage, actualValidationErrorMessage);

    }
    @Test
    void lockedUserLoginTest(){
        LoginPage loginPage = new LoginPage();

        loginPage.logIn(DataHelper.getLockedOutUserInfo());

        String actualValidationErrorMessage = loginPage.getValidationErrorMessage();
        String expectedValidationErrorMessage = "Epic sadface: Sorry, this user has been locked out.";

        Assertions.assertEquals(expectedValidationErrorMessage, actualValidationErrorMessage);


    }




}
