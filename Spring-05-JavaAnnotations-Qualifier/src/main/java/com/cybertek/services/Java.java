package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
//@AllArgsConstructor //Lombok la da olur, const yazmana gerek yok o zaman
public class Java implements Course {

    //1. yol field yoluyla , @Qualifier("officeHours") ekle (ya da (mockInterviewHours))
//    @Autowired
//    @Qualifier("officeHours")
    private ExtraSessions extraSessions;

    //2. yol
    //constructor a hangisinin inject edilecegini goster !! @Qualifier("officeHours") ile
//    @Autowired  //not mandatory
    public Java(@Qualifier("officeHours") ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : "+(20+ extraSessions.getHours()));
    }
}

