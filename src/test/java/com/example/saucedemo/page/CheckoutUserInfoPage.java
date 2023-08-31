package com.example.saucedemo.page;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutUserInfoPage {
    Faker faker = new Faker();

    String fakeFirstName = faker.name().firstName();
    String fakeLastName = faker.name().lastName();
    String fakePostalCode = faker.address().zipCode();

    private SelenideElement firstNameInput = $("[data-test=firstName]");
    private SelenideElement lastNameInut = $("[data-test=lastName]");
    private SelenideElement postalCodeInput = $("[data-test=postalCode]");

    private SelenideElement canselButton = $("button[id='cancel']");
    private SelenideElement continueButton = $("[data-test=continue]");




    public void sendUserData(){
        firstNameInput.setValue(fakeFirstName);
        lastNameInut.setValue(fakeLastName);
        postalCodeInput.setValue(fakePostalCode);

        continueButton.click();

    }
}
