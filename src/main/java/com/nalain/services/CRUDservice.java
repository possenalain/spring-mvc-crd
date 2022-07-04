package com.nalain.services;

import java.util.List;

public interface CRUDservice<T> {

    List<?> listAll();
    T getById(Integer id);
    T save(T domainEntity);
    void delete(Integer id);
}
