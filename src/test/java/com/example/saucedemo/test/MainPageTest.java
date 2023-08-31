package com.example.saucedemo.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.saucedemo.data.DataHelper;

import com.example.saucedemo.page.CartPage;
import com.example.saucedemo.page.CheckoutUserInfoPage;
import com.example.saucedemo.page.LoginPage;
import com.example.saucedemo.page.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new  ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://www.saucedemo.com/");
    }

//    @Test
//    void happyPathTest() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.logIn(DataHelper.getUserInfo());
//
//        MainPage mainPage = new MainPage();
//        mainPage.addProductToCart();
//
//        String actualProductsCount = mainPage.getShoppingCartBadgeValue();
//        Assertions.assertEquals("1", actualProductsCount);
//
//        mainPage.goToCart();
//
//        CartPage cartPage = new CartPage();
//        cartPage.checkOutProducts();
//
//        CheckoutUserInfoPage  checkoutUserInfoPage = new CheckoutUserInfoPage();
//        checkoutUserInfoPage.sendUserData();
//
//
//    }

    @Test
    public void sortByPriceLoHi() {
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(DataHelper.getUserInfo());

        MainPage mainPage = new MainPage();
        mainPage.sortByPriceLoHi();

        List<MainPage.InventoryItem> originalList = mainPage.processInventoryItems();
        List<MainPage.InventoryItem> sortedList = mainPage.sortInventoryItemsByPriceLoHi(new ArrayList<>(originalList));

        System.out.println("Original List:");
        originalList.forEach(item -> System.out.println(item.getName() + " - " + item.getPrice()));

        System.out.println("Sorted List:");
        sortedList.forEach(item -> System.out.println(item.getName() + " - " + item.getPrice()));

        Assertions.assertIterableEquals(sortedList, originalList);
    }


    @Test
    public void sortByPriceHiLo() {
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(DataHelper.getUserInfo());

        MainPage mainPage = new MainPage();
        mainPage.sortByPriceHiLo();

        List<MainPage.InventoryItem> originalList = mainPage.processInventoryItems();
        List<MainPage.InventoryItem> sortedList = mainPage.sortInventoryItemsByPriceHiLo(new ArrayList<>(originalList));

        System.out.println("Original List:");
        originalList.forEach(item -> System.out.println(item.getName() + " - " + item.getPrice()));

        System.out.println("Sorted List:");
        sortedList.forEach(item -> System.out.println(item.getName() + " - " + item.getPrice()));

        Assertions.assertIterableEquals(sortedList, originalList);
    }


    @Test
    public void sortByNameAZ() {
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(DataHelper.getUserInfo());

        MainPage mainPage = new MainPage();
        mainPage.setSortByNameAZ();

        List<MainPage.InventoryItem> originalList = mainPage.processInventoryItems();
        List<MainPage.InventoryItem> sortedList = mainPage.sortInventoryItemsByNameAZ(new ArrayList<>(originalList));

        System.out.println("Original List:");
        originalList.forEach(item -> System.out.println(item.getName() + " - " + item.getPrice()));

        System.out.println("Sorted List:");
        sortedList.forEach(item -> System.out.println(item.getName() + " - " + item.getPrice()));

        Assertions.assertIterableEquals(sortedList, originalList);
    }

    @Test
    public void sortByNameZA() {
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(DataHelper.getUserInfo());

        MainPage mainPage = new MainPage();
        mainPage.setSortByNameZA();

        List<MainPage.InventoryItem> originalList = mainPage.processInventoryItems();
        List<MainPage.InventoryItem> sortedList = mainPage.sortInventoryItemsByNameZA(new ArrayList<>(originalList));

        System.out.println("Original List:");
        originalList.forEach(item -> System.out.println(item.getName() + " - " + item.getPrice()));

        System.out.println("Sorted List:");
        sortedList.forEach(item -> System.out.println(item.getName() + " - " + item.getPrice()));

        Assertions.assertIterableEquals(sortedList, originalList);
    }






}
