package com.javaguru.shoppinglist.domain;



import main.java.com.javaguru.shoppinglist.domain.Category;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    public static Long counter = 0L;
    public static final Product emptyProduct = new Product("", new BigDecimal(0), new BigDecimal(0));
    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private BigDecimal discount;
    private String description;

    public Product(String name, BigDecimal priceValue, BigDecimal discountValue) {
        this.name = name;
        price = priceValue;
        discount = discountValue;
        id = counter.longValue();
        counter++;
        category = Category.UNSSIGNED;

    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public BigDecimal getDiscount() { return discount; }

    public void setDiscount(BigDecimal discount) { this.discount = discount; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass()  != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name,  category);
    }

    @Override
    public String toString(){
        return "Product{ " +
                "id= " + id +
                ", name =' " + name + '\'' +
                ", category=' " + category + '\'' +
                "/ discount=' " + discount +
                ", description=' " + description + '\'' +
                "}";
    }

}

