package com.nalain.services.mapservices;

import com.nalain.domain.DomainEntity;

import java.util.*;

public abstract class AbstractMapService {

    Map<Integer, DomainEntity> domainMap;


    abstract void loadDomainObjects();

    public AbstractMapService() {
        this.domainMap = new HashMap<>();
        loadDomainObjects();
    }



    List<DomainEntity> listAll(){
        return new ArrayList<>(domainMap.values());
    }

    DomainEntity getById(Integer id){
        return domainMap.get(id);
    }

    DomainEntity save(DomainEntity domainEntity){

       if (domainEntity != null) {
            if (domainEntity.getId() == null) {
                domainEntity.setId(Collections.max(domainMap.keySet()) + 1);
            }
            domainMap.put(domainEntity.getId(), domainEntity);
            return domainEntity;
        } else {
            throw new RuntimeException("Entity can't be null");
        }
    }

    void delete(Integer id){


        if (id!= null) {
             domainMap.remove(id);

        } else {
            throw new RuntimeException("id can't be null");
        }
    }
}
