package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {

    //OfficeHours officeHours;

    //always do your injections through interfaces !!! (config.xml de constructor-arg a ne eklemek istersey koy)
    ExtraSessions extraSessions;


//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }


    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : " + (20 + extraSessions.getHours()));
    }
}