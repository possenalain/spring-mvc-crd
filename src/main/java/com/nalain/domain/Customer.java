package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Customer extends BaseEntity {
    @OneToOne
    private User user;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Embedded
    private  Address billingAddress;
    @Embedded
    private Address shippingAddress;

}
