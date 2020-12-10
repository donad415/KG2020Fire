package com.company.model;

import com.company.math.Vector2;

public class Fire {
    private double dt ;
    private double angle;
    private Aura aura;
    private Vector2 pointTop;
    private Vector2 pointBottom;
    private int stadge;
    private ForceSource externalForce;

    public double getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
        this.aura.setRadius(dt);
        this.stadge = dt;
    }

    public Fire() {
        this.pointBottom = new Vector2(235, 220);
        this.aura = new Aura();
        this.pointTop = new Vector2(235, 130);
    }

    public int getStadge() {
        return stadge;
    }



    public void setStadge(int stadge) {
        this.stadge = stadge;
    }

    public Vector2 getPointTop() {
        return pointTop;
    }

    public void setPointTop(Vector2 pointTop) {
        this.pointTop = pointTop;
    }

    public Vector2 getPointBottom() {
        return pointBottom;
    }

    public void setPointBottom(Vector2 pointBottom) {
        this.pointBottom = pointBottom;
    }

    public double getAngle(){
        return angle;
    }

    public void  setAngle(double angle){
        this.angle=angle;
    }

    public Aura getAura() {
        return aura;
    }

    public void setAura(Aura aura) {
        this.aura = aura;
    }

    public ForceSource getExternalForce() {
        return externalForce;
    }

    public void setExternalForce(ForceSource externalForce) {
        this.externalForce = externalForce;
    }
}
