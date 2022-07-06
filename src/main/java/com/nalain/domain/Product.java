package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product  extends BaseEntity{
    private String description;
    private BigDecimal price;
    private String imageUrl;
}
