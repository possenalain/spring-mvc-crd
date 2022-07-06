package com.nalain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Address {

    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String zipCode;
}
