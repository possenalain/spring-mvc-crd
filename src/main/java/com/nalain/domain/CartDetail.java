package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CartDetail extends BaseEntity {

    private Integer quantity;
    @ManyToOne
    private Cart cart;
    @OneToOne
    private Product product;


}
