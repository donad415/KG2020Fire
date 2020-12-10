package com.company.model;

import com.company.math.Vector2;

public class Aura {
    private Vector2 position;
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Aura(){
        this.position = new Vector2(235, 195);
    }
}
