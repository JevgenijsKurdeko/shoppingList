package com.javaguru.shoppinglist.service.validation;

public class ProductValidationException extends NullPointerException {
    public ProductValidationException(String message){
        super(message);
    }

}
