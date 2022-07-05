package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CartDetail implements DomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @ManyToOne
    private Cart cart;

    @OneToOne
    private Product product;

    @Override
    public String toString() {
        return "\n\nCartDetail{" +
                "id=" + id +
                ", version=" + version +
                "\n, product=" + product +
                "}\n\n";
    }
}
