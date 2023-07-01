package com.tanim.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

@Component
public class Traveller {


    @Autowired
    @Qualifier("bike")
    public Vehicle vehicle;


    public void visiting()
    {
        vehicle.perKilo();
    }


}
