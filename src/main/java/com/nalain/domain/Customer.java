package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.aop.framework.adapter.AdvisorAdapterRegistrationManager;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Customer implements DomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;
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


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", version=" + version +
                //", user=" + user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
