package com.employees.system.model;

import javax.persistence.*;


@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String description;
    private Integer price;
    private Integer quantity;

    Long user_id;

    public Product() {
    }

    public Product(String productName, String description, Integer price, Integer quantity, Long user_id) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.user_id = user_id;
    }

    public Product(Long id, String productName, String description, Integer price, Integer quantity,Long user_id) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return user_id;
    }

    public void setProductId(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", user_id=" + user_id +
                '}';
    }
}
