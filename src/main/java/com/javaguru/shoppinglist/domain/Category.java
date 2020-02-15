package main.java.com.javaguru.shoppinglist.domain;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    UNSSIGNED,
    MILK,
    VEGAN,
    CHEESE,
    FISH,
    MEAT,
    VEGETABLES,
    FRUITS;

    public static List getCategoryList() {
        List<Category> category = new ArrayList<>();
        category.add(UNSSIGNED);
        category.add(VEGAN);
        category.add(FISH);
        category.add(FRUITS);
        category.add(CHEESE);
        category.add(MEAT);
        category.add(VEGETABLES);
        category.add(MILK);
        return category;
    }

    public static void printCategoryList(){

        List categories = getCategoryList();

        System.out.println("" + categories.indexOf(UNSSIGNED) + " = " + UNSSIGNED);
        System.out.println("" + categories.indexOf(MILK) + " = " + MILK);
        System.out.println("" + categories.indexOf(FRUITS) + " = " + FRUITS);
        System.out.println("" + categories.indexOf(FISH) + " = " + FISH);
        System.out.println("" + categories.indexOf(VEGAN) + " = " + VEGAN);
        System.out.println("" + categories.indexOf(VEGETABLES) + " = " + VEGETABLES);
        System.out.println("" + categories.indexOf(CHEESE) + " = " + CHEESE);
        System.out.println("" + categories.indexOf(MEAT) + " = " + MEAT);
    }
}
