package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "regions")
public class Region extends BaseEntity{

    private String region;
    private String country;

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }

    @OneToOne(mappedBy = "region" )
    private Employee employee;
}
