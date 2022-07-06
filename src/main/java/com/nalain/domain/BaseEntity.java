package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
abstract class BaseEntity implements DomainEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    @CreatedDate
    private Date dateCreated;
    @LastModifiedDate
    private Date dateUpdated;

    @PrePersist
    @PreUpdate
    public void updateTimestamps(){

        if(dateCreated==null){
            dateCreated=new Date();
        }
        dateUpdated=new Date();
    }

}
