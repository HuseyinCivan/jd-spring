package com.cybertek;

import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedquerriesApplication {

    @Autowired
    RegionRepository regionRepository;


    public static void main(String[] args) {
        SpringApplication.run(DerivedquerriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions() {
        System.out.println("------regions start");
        System.out.println("findByCountry : "+regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry : "+regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining : "+regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByCountry : "+regionRepository.findByCountryContainsOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry : "+regionRepository.findTop2ByCountry("Canada"));



        System.out.println("------regions end");
    }

}
