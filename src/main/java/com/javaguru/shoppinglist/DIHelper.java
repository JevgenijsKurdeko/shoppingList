package com.javaguru.shoppinglist;

import main.java.com.javaguru.shoppinglist.console.KeyboardInput;
import main.java.com.javaguru.shoppinglist.console.UImenu;
import main.java.com.javaguru.shoppinglist.dataBase.DataBase;
import main.java.com.javaguru.shoppinglist.domain.ProductService;

public class DIHelper {

    public static UImenu createApplication() {

        DataBase db = new DataBase();
        ProductService productService = new ProductService(db);
        KeyboardInput keyboardInput = new KeyboardInput();
        return new UImenu(productService, keyboardInput);

    }

}
