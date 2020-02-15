package main.java.com.javaguru.shoppinglist.dataBase;

import com.javaguru.shoppinglist.domain.Product;

public interface DataBaseInterface {
    void insert(Product product);


    void update(Product product);
    void delete(Product product);

    Product get(Product product);
    Product get(String productName);
    Product get(Long productID);
}
