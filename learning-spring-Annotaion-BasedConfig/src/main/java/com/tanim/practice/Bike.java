package com.tanim.practice;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{
    @Override
    public void perKilo() {
        System.out.println("Its running around 20Km/h");
    }
}
