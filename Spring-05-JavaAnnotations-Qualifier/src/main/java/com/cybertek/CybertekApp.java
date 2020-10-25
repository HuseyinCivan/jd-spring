package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        //Course course = container.getBean("API", Course.class);  //hepsi buyuk harfse buyuk harfle yaz!!
        //  Course course =container.getBean("selenium",Course.class);  //ilk harfi kucuk harf yap!
        Course course = container.getBean("java", Course.class);   //ilk harfi kucuk harf yap!
        course.getTeachingHours();


    }
}
