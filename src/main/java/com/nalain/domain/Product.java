package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class Product  extends BaseEntity{
    private String description;
    private BigDecimal price;
    private String imageUrl;
}
