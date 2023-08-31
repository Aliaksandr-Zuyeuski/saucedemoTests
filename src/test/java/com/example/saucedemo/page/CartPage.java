package com.example.saucedemo.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    SelenideElement continueShopping = $("[data-test=continue-shopping]");
    SelenideElement checkoutButton = $("button[id='checkout']");


    public void checkOutProducts(){
        checkoutButton.click();
    }
}
