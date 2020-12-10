package com.company.model;

import com.company.math.Vector2;


public class ForceSource {
    private Vector2 location;
    private double value;

    public ForceSource(Vector2 location) {
        this.location = location;
        value = 0;
    }

    public Vector2 getLocation() {
        return location;
    }

    public void setLocation(Vector2 location) {
        this.location = location;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Vector2 getForceAt(Vector2 p) {
        if (Math.abs(value) < 1e-12)
            return new Vector2(0, 0);
        return location.add(p.mul(-1)).normolized().mul(value);
    }
}
