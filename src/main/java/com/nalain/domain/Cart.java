package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart implements DomainEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart" , orphanRemoval = true )
    private List<CartDetail> cartDetails=new ArrayList<>();


    public void addCartDetails(CartDetail cartDetail) {
        this.cartDetails.add(cartDetail);
        cartDetail.setCart(this);

    }
    public void removeCartDetails(CartDetail cartDetail) {
        cartDetail.setCart(null);
        this.cartDetails.remove(cartDetail);
    }

    @Override
    public String toString() {
        return "\n\nCart{" +
                "id=" + id +
                ", version=" + version +
                ", user=" + user +
                "\n, cartDetails=" + cartDetails +
                "\n}\n\n";
    }
}
