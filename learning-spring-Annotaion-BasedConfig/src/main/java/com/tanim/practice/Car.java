package com.tanim.practice;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

    @Override
    public void perKilo()
    {
        System.out.println("Car is running about 25Km/h");
    }
}
