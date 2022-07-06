package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart extends BaseEntity {
    @OneToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", orphanRemoval = true)
    private List<CartDetail> cartDetails = new ArrayList<>();


    public void addCartDetails(CartDetail cartDetail) {
        this.cartDetails.add(cartDetail);
        cartDetail.setCart(this);

    }

    public void removeCartDetails(CartDetail cartDetail) {
        cartDetail.setCart(null);
        this.cartDetails.remove(cartDetail);
    }
}
