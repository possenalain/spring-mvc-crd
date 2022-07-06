package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderDetail extends BaseEntity{
    @ManyToOne
    private Order order;
    @OneToOne
    private Product product;
    private Integer quantity;



}
