package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users")
@Setter
@Getter
public class User implements DomainEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String encryptedPassword;
    private Boolean enabled;

    @Version
    private Integer version;

    @Transient
    private String password;
    @CreatedDate
    private Date dateCreated;
    @LastModifiedDate
    private Date dateUpdated;


    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Cart cart;

    public void setCustomer(Customer customer) {
        customer.setUser(this);
        this.customer = customer;
    }
}
