package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product  implements DomainEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    @Override
    public String toString() {
        return "\nProduct{" +
                "id=" + id +
                ", version=" + version +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                "}\n";
    }
}
