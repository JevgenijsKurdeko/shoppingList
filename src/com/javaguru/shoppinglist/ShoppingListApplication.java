package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        String name;
                        do {
                            System.out.println("Enter product name: (More than 3 and less than 32)");
                            name = scanner.nextLine();
                        }
                        while (name.length() < 3 || name.length() > 32);

                        double price;
                        do {
                            System.out.println("Enter product price:  (Product price must be greater than 0)");
                            price = scanner.nextDouble();
                            //BigDecimal price = new BigDecimal(scanner.nextLine());
                        }
                        while (price < 1);
                        scanner.nextLine();

                        System.out.println("Enter category: ");
                        String category = scanner.nextLine();

                        double discount;
                        do {
                            System.out.println("Enter discount: (Max 100%)");
                            discount = scanner.nextDouble();
                        }
                        while (discount < 1 || discount > 100);
                        scanner.nextLine();

                        System.out.println("Enter description: ");
                        String description = scanner.nextLine();

                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setId(productIdSequence);
                        product.setCategory(category);
                        product.setDescription(description);
                        product.setDiscount(discount);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId() + product.getName() + product.getPrice() + product.getDiscount() + product.getCategory() + product.getDescription());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}