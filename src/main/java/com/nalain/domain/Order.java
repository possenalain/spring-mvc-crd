package com.nalain.domain;

import com.nalain.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@Getter
@Setter
public class Order extends BaseEntity{

    @ManyToOne
    private Customer customer;

    @Embedded
    private Address shipToAddress;

    @OneToMany(cascade = {CascadeType.ALL,CascadeType.PERSIST},mappedBy = "order",orphanRemoval = true)
    private List<OrderDetail> orderDetails=new ArrayList<>();

    private OrderStatus status;
    private Date dateShipped;

    public void addToOrderDetails(OrderDetail orderDetail){
        orderDetail.setOrder(this);
        orderDetails.add(orderDetail);
    }
    public void removeOrderDetail(OrderDetail orderDetail){
        orderDetail.setOrder(null);
        orderDetails.remove(orderDetail);
    }

}
