package com.erp.entity.cart;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "CART")
@Entity(name = "cart")
public class Cart implements Serializable {
    @Id
    @SequenceGenerator(name = "CART_SEQ",sequenceName = "CART_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "CART_SEQ")
    private long id;
    @Column(name = "NAME",columnDefinition = "NVARCHAR2(40)")
    private String name;
    @Column(name = "PRICE",columnDefinition = "NVARCHAR2(40)")
    private String price;
    @Column(name = "STATE",columnDefinition = "NVARCHAR2(40)")
    private boolean state;
    @Column(name = "userID",columnDefinition = "NUMBER")
    private long userID;

    public Cart() {
    }

    public Cart(String name, String price, long userID, boolean state) {
        this.name = name;
        this.price = price;
        this.userID = userID;
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
