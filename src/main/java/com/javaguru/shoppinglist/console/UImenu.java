package main.java.com.javaguru.shoppinglist.console;


import main.java.com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;
import main.java.com.javaguru.shoppinglist.domain.ProductService;
import main.java.com.javaguru.shoppinglist.validation.ProductDiscountValidation;
import main.java.com.javaguru.shoppinglist.validation.ProductFieldsValidationException;
import main.java.com.javaguru.shoppinglist.validation.ProductNameLengthValidation;
import main.java.com.javaguru.shoppinglist.validation.ProductPriceValidation;

import java.math.BigDecimal;
import java.util.List;

public class UImenu {

    private static KeyboardInput keyboardInput;
    private ProductService productService;


    public UImenu(ProductService productService, KeyboardInput keyboardInput) {
        this.productService = productService;
        this.keyboardInput = keyboardInput;

    }

    private static Category getCategoryByMenu() {
        Category category = Category.UNSSIGNED;
        MenuText.checkingCategoryText();
        Category.printCategoryList();

        int userChose = keyboardInput.getUserNumberInput();
        if (userChose < Category.getCategoryList().size()) {
            category = (Category) Category.getCategoryList().get(userChose);
        }
        return category;
    }

    private void createNewProduct() {

        String name = getProductName();
        BigDecimal priceBD = getProductPrice();
        BigDecimal discount = getProductDiscount();

        Product newProduct = productService.createProduct(name, priceBD, discount);


        if (!(newProduct == Product.emptyProduct)) {
            setCategory(productService, newProduct);
            setDescription(newProduct);
            System.out.println("======   You created product : ");
            System.out.println(newProduct.toString());
        }

        productService.writeProductInDataBase(newProduct);
    }

    private BigDecimal getProductDiscount() {
        BigDecimal discount = new BigDecimal("0");

        boolean correctInput = false;
        while (!correctInput) {
            try {
                System.out.println("======   Please enter product discount  in format like 0.00. Discount cannot be more than 100 percent!");
                discount = keyboardInput.getKeyboardInputBigDecimal();

                ProductDiscountValidation.validate(discount);
                correctInput = true;
            } catch (ProductFieldsValidationException f) {
                System.out.println(f.getMessage());
                correctInput = false;
            }
        }
        return discount;
    }

    private BigDecimal getProductPrice() {
        BigDecimal priceBD = new BigDecimal("0");

        boolean correctInput = false;
        while (!correctInput) {
            try {
                System.out.println("======   Please enter product pice in format like 0.00 ! Product price must be greater than 0! ");
                priceBD = keyboardInput.getKeyboardInputBigDecimal();
                ProductPriceValidation.validate(priceBD);
                correctInput = true;
            } catch (ProductFieldsValidationException f) {
                System.out.println(f.getMessage());
                correctInput = false;
            }
        }
        return priceBD;
    }

    private String getProductName() {
        String name = "";

        boolean correctInput = false;
        while (!correctInput) {
            try {
                System.out.println("======   Please enter product name! Name cannot be less than 3 characters and more than 32! ");
                name = keyboardInput.getKeyboardInputLine();
                ProductNameLengthValidation.validate(name);
                correctInput = true;
            } catch (ProductFieldsValidationException f) {
                System.out.println(f.getMessage());
                correctInput = false;
            }
        }
        return name;
    }

    private void setDescription(Product product) {

        MenuText.descriptionTextQuestion();

        int userChose = keyboardInput.getUserNumberInput();
        if (userChose > 0) {
            setProductDescription(product);
        }

    }

    private void setCategory(ProductService productService, Product product) {

        MenuText.settingCategoryTextQuestion();


        int userChose = keyboardInput.getUserNumberInput();
        if (userChose > 0) {
            Category category = getCategoryByMenu();
            productService.setProductCategory(product, category);
        }

    }

    private void setProductDescription(Product product) {

        MenuText.descriptionTextSetting();

        String description = keyboardInput.getKeyboardInputLine();
        productService.setProductDescription(product, description);

    }

    private void getProductInformation() {

        Product receivedProduct = getProductAcrossMenue();

        if (!(receivedProduct == Product.emptyProduct)) {
            System.out.println(receivedProduct.toString());
        } else {
            System.out.println("Product dont search!");
        }

    }

    private Product getProductAcrossMenue() {

        Product receivedProduct = Product.emptyProduct;
        MenuText.gettingProductTextQuestion();


        int userChose = keyboardInput.getUserNumberInput();
        if (userChose == 1) {
            System.out.println("enter product ID to search ");
            Long iD = new Long(keyboardInput.getUserNumberInput());

            receivedProduct = productService.getProductFromDataBase(iD);
        } else {
            System.out.println("enter product name to search ");
            String productName = keyboardInput.getKeyboardInputLine();
            receivedProduct = productService.getProductFromDataBase(productName);
        }
        return receivedProduct;
    }

    private void deleteSelectedProduct() {
        MenuText.productSelectingToDeleteText();
        Product productToDelete = getProductAcrossMenue();

        if (!(productToDelete == Product.emptyProduct)) {
            productService.deleteProductFromDataBase(productToDelete);
            System.out.println("Product " + productToDelete.toString() + "deleted");
        } else {
            System.out.println("Dont searched product");
        }

    }

    private void getProductListByCategory() {
        Category category = getCategoryByMenu();
        List<Product> productList = productService.getProductListFromDataBaseByCategory(category);
        System.out.println(productList.toString());
    }

    public void mainUserMenu() {
        int userMenuChose = 1;
        while (userMenuChose >= 1 && userMenuChose <= 4) {
            MenuText.userMenu();

            userMenuChose = keyboardInput.getUserNumberInput();

            if (userMenuChose == 1) {
                createNewProduct();
            } else if (userMenuChose == 2) {
                getProductInformation();
            } else if (userMenuChose == 3) {
                getProductListByCategory();
            } else if (userMenuChose == 4) {
                deleteSelectedProduct();
            }

        }
    }



}
