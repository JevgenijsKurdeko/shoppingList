package main.java.com.javaguru.shoppinglist.domain;

import java.math.BigDecimal;
import java.util.List;

import com.javaguru.shoppinglist.domain.Product;
import main.java.com.javaguru.shoppinglist.dataBase.DataBase;

public class ProductService {

    private DataBase dataBase;

    public ProductService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public Product createProduct(String name, BigDecimal priceValue, BigDecimal discountValue) {
        return new Product(name, priceValue, discountValue);
    }

    public void setProductCategory(Product product, Category category) {
        product.setCategory(category);
    }

    public Product getProductFromDataBase(Long productID) {
        return dataBase.get(productID);
    }

    public Product getProductFromDataBase(String productName) {
        return dataBase.get(productName);
    }

    public List<Product> getProductListFromDataBaseByCategory(Category category) {
        return dataBase.getProductList(category);
    }

    public Product getProductFromDataBase(Product product) {
        return dataBase.get(product);
    }

    public void deleteProductFromDataBase(Product product) {
        dataBase.delete(product);
    }

    public void setProductDescription(Product product, String description) {
        product.setDescription(description);
    }

    public void writeProductInDataBase (Product product){
        dataBase.insert(product);
    }


}
