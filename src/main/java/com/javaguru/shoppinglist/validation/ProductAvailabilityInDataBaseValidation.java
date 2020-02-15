package main.java.com.javaguru.shoppinglist.validation;

import main.java.com.javaguru.shoppinglist.dataBase.DataBaseInterface;
import com.javaguru.shoppinglist.domain.Product;

public class ProductAvailabilityInDataBaseValidation {

    private DataBaseInterface db;

    public ProductAvailabilityInDataBaseValidation(DataBaseInterface db) {
        this.db = db;
    }

    public boolean validate(Product product) throws ProductFieldsValidationException {

        Product foundProduct = db.get(product.getName());
        if (foundProduct != null) {
//            throw  new ProductFieldsValidationException("In database with ID: " + foundProduct.getId() + " is a product with name: " + foundProduct.getName() + " ! be careful !");
            throw new ProductFieldsValidationException("In database with is a product with entered name!");

        }

        return true;

    }
}
