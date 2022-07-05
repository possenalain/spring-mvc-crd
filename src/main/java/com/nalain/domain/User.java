package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Setter
@Getter
public class User implements DomainEntity{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    private String username;
    @Transient
    private String password;
    private String encryptedPassword;
    private Boolean enabled;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Cart cart;


    public void setCustomer(Customer customer) {
        customer.setUser(this);
        this.customer = customer;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", version=" + version +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", encryptedPassword='" + encryptedPassword + '\'' +
                ", enabled=" + enabled +
                "\n, customer=" + customer +
                "\n, cart=" + cart +
                "\n}\n\n";
    }
}
