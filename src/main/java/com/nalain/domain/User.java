package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Setter
@Getter
public class User extends BaseEntity{
    private String username;
    private String encryptedPassword;
    private Boolean enabled;
    @Transient
    private String password;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Cart cart;

    public void setCustomer(Customer customer) {
        customer.setUser(this);
        this.customer = customer;
    }
    public void setCart(Cart cart) {
        cart.setUser(this);
        this.cart = cart;
    }
}
