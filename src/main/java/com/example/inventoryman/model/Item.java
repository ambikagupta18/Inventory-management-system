package com.example.inventoryman.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message="product name is not empty")
    private String name;

    @NotEmpty(message = "quantity is not empty")
    @Positive(message = "value must be positive")
    private String quantity;

    @NotNull(message = "price is not empty")
    @Positive(message = "value must be positive")
    //@Digits(integer=1, fraction=0, message = "value must be positive and 1 digits whole number")
    private long price;
    /*@ManyToOne()
    private User user;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Item(long id, String name, String quantity, long price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Item() {

    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price=" + price +
                '}';
    }
}
