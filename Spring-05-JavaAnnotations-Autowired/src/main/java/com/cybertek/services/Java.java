package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//@AllArgsConstructor //Lombok la da olur, const yazmana gerek yok o zaman
public class Java implements Course {

    //field injection
    @Autowired
    private OfficeHours officeHours;

//    //constructor injection  --> en cok tercih edileni bu!!!
////    //@Autowired  //Autowired yazmasan da olur , sadece 1 tane method varsa extrasession da
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }


//    public OfficeHours getOfficeHours() {
//        return officeHours;
//    }

//    //Setter injection
//    @Autowired
//    public void setOfficeHours(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : "+(30+officeHours.getHours()));
    }
}

