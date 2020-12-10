package com.company.math;


public class Vector2 {
    private double x, y;


    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }


    public Vector2 mul(double n) {
        return new Vector2((x * n), y * n);
    }


    public Vector2 normolized() {
        double len = length();
        if (len < 1e-12) /*Да, здесь не по модулю, т.к. корень не будет отрицательным.*/
            return new Vector2(0, 0);
        return new Vector2(x / len, y / len);
    }

    public double length() {
        return Math.sqrt(x*x + y*y);
    }
}
