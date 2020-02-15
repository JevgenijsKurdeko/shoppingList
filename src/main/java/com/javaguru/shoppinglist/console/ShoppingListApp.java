package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.DIHelper;
import main.java.com.javaguru.shoppinglist.console.UImenu;

public class ShoppingListApp {

    public static void main(String[] args) {


        UImenu uImenu = DIHelper.createApplication();
        uImenu.mainUserMenu();


    }
}
