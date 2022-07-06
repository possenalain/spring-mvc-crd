package com.nalain.services.mapservices;

import com.nalain.domain.DomainEntity;
import com.nalain.domain.Order;
import com.nalain.services.OrderService;

import java.util.List;

public class OrderServiceImpl extends AbstractMapService implements OrderService {
    @Override
    void loadDomainObjects() {

    }

    @Override
    public List<DomainEntity> listAll() {
        return null;
    }

    @Override
    public Order getById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Order save(Order domainEntity) {
        return null;
    }
}
