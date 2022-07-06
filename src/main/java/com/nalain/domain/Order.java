package com.nalain.domain;

import com.nalain.domain.enums.OrderStatus;
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
public class Order extends BaseEntity{

    @ManyToOne
    private Customer customer;

    @Embedded
    private Address shipToAddress;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order",orphanRemoval = true)
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
