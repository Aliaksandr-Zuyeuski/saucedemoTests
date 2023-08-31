package com.example.saucedemo.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {



    SelenideElement appLogo = $(".app_logo");
    SelenideElement cart = $("#shopping_cart_container a");
    SelenideElement burgerMenu = $("#react-burger-menu-btn");
    SelenideElement inventorySidebarLink = $("#inventory_sidebar_link");
    SelenideElement aboutSidebarLink = $("#about_sidebar_link");
    SelenideElement logoutSidebarLink = $("#logout_sidebar_link");
    SelenideElement resetSidebarLink = $("#reset_sidebar_link");
    SelenideElement productSortContainer = $("[data-test=product_sort_container]");
    SelenideElement sortByNameAZ = $("option[value='az']");
    SelenideElement sortByNameZA = $("option[value='za']");
    SelenideElement sortByPriceLoHi = $("option[value='lohi']");
    SelenideElement sortByPriceHiLo = $("option[value='hilo']");
    ElementsCollection inventoryItems = $$(".inventory_item");

    SelenideElement shoppingCartBage =$(".shopping_cart_badge");


    public  List<InventoryItem> processInventoryItems() {
        List<InventoryItem> itemsList = new ArrayList<>();


        for (SelenideElement item : inventoryItems) {
            SelenideElement itemNameElement = item.$(".inventory_item_name");
            SelenideElement itemPriceElement = item.$(".inventory_item_price");


            String itemName = itemNameElement.getText();
            String itemPriceText = itemPriceElement.getText();

            double itemPrice = Double.parseDouble(itemPriceText.replaceAll("[^0-9.]*", ""));


            InventoryItem inventoryItem = new InventoryItem(itemName, itemPrice);
            itemsList.add(inventoryItem);
        }
        System.out.println(itemsList);
        return itemsList;
    }




    public  List<InventoryItem> sortInventoryItemsByPriceLoHi(List<InventoryItem> itemsList) {
        Collections.sort(itemsList, Comparator.comparingDouble(InventoryItem::getPrice));
        return itemsList;
    }

    public List<InventoryItem> sortInventoryItemsByPriceHiLo(List<InventoryItem> itemsList) {
        Collections.sort(itemsList, Comparator.comparingDouble(InventoryItem::getPrice).reversed());
        return itemsList;
    }

    public List<InventoryItem> sortInventoryItemsByNameAZ(List<InventoryItem> itemsList) {
        Collections.sort(itemsList, Comparator.comparing(InventoryItem::getName));
        return itemsList;
    }

    public List<InventoryItem> sortInventoryItemsByNameZA(List<InventoryItem> itemsList) {
        Collections.sort(itemsList, Comparator.comparing(InventoryItem::getName).reversed());
        return itemsList;
    }


    public void sortByPriceLoHi(){
        productSortContainer.click();
        sortByPriceLoHi.click();

    }

    public void sortByPriceHiLo() {
        productSortContainer.click();
        sortByPriceHiLo.click();
    }

    public void setSortByNameAZ() {
        productSortContainer.click();
        sortByNameAZ.click();
    }

    public void setSortByNameZA() {
        productSortContainer.click();
        sortByNameZA.click();
    }

    public void addProductToCart(){
        inventoryItems.first().find("button").click();
    }

    public String getShoppingCartBadgeValue() {
        return shoppingCartBage.text().trim();
    }

    public void goToCart() {
        cart.click();
    }





    @AllArgsConstructor
    @Getter
    public static class InventoryItem {
        private String name;
        private double price;
    }

}
