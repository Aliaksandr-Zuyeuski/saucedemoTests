package com.example.saucedemo.page;

import com.codeborne.selenide.SelenideElement;
import com.example.saucedemo.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    private SelenideElement userNameInput = $("[data-test=username]");
    private  SelenideElement userPasswordInput = $("[data-test=password]");
    private  SelenideElement submitButton = $("[data-test=login-button]");
    private SelenideElement headerContainerTitle = $("#header_container .title");
    private SelenideElement validationErrorMessage = $("[data-test=error]");


    public void logIn(DataHelper.UserInfo user) {
        userNameInput.setValue(user.getUserName());
        userPasswordInput.setValue(user.getUserPassword());
        submitButton.click();
    }
    public void logIn(String userName, String userPassword){
        userNameInput.setValue(userName);
        userPasswordInput.setValue(userPassword);
        submitButton.click();
    }

    public String getTitleValue(){
        return headerContainerTitle.text().trim();
    }
    public String getValidationErrorMessage() {
            return validationErrorMessage.text().trim();
    }



}
