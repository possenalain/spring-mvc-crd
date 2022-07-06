package com.nalain.domain;

import com.nalain.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

//@Entity
@Getter
@Setter
public class Order implements DomainEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Customer customer;

    @Embedded
    private Address shippingAddress;

    private OrderStatus status;

    @CreatedDate
    private Date dateCreated;
    @LastModifiedDate
    private Date dateUpdated;

    private Date dateShipped;

}
