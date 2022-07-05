package com.nalain.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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

    @Override
    public void setId(Integer id) {

    }

    @Override
    public Integer getId() {
        return null;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

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
