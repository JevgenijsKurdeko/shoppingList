package main.java.com.javaguru.shoppinglist.validation;

public class ProductFieldsValidationException extends Throwable {

    ProductFieldsValidationException(String errorDescription) {
        super(errorDescription);
    }
}
