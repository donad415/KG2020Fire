package com.company.model;

import com.company.math.Rectangle;


public class Field {
    private Rectangle rectangle;
    private double mu, g;

    public Field(Rectangle rectangle, double mu, double g) {
        this.rectangle = rectangle;
        this.mu = mu;
        this.g = g;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getMu() {
        return mu;
    }

    public void setMu(double mu) {
        this.mu = mu;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }


}
