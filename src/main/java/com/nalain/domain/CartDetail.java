package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class CartDetail implements DomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    @Autowired
    private Integer quantity;
    @ManyToOne
    private Cart cart;

    @OneToOne
    private Product product;

    @CreatedDate
    private Date dateCreated;
    @LastModifiedDate
    private Date dateUpdated;

}
