package com.nalain.services.mapservices;

import com.nalain.domain.DomainEntity;
import com.nalain.domain.User;
import com.nalain.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class UserServiceImpl extends AbstractMapService implements UserService {
    @Override
    void loadDomainObjects() {

    }

    @Override
    public List<DomainEntity> listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) super.getById(id);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);

    }

    @Override
    public User save(User domainEntity) {
        return (User) super.save(domainEntity);
    }
}
