package com.company.model;


import com.company.math.Vector2;
import com.company.utils2d.ScreenConverter;
import com.company.utils2d.ScreenPoint;

import java.awt.Color;
import java.awt.Graphics2D;

public class World {
    private Fire fire;
    private Field f;
    private ForceSource externalForce;
    private int stadge;
    public boolean isPaused;

    public World(Fire fire, Field f) {
        this.fire = fire;
        this.f = f;
        this.externalForce = new ForceSource(f.getRectangle().getCenter());
    }


    public void update(double dt) {
        if(stadge<10){
            stadge++;
        }else stadge = 1;
        fire.setDt(stadge);

    }


    public void draw(Graphics2D g, ScreenConverter sc) {
        ScreenPoint tl = sc.r2s(f.getRectangle().getTopLeft());
        int w = sc.r2sDistanceH(f.getRectangle().getWidth());
        int h = sc.r2sDistanceV(f.getRectangle().getHeight());
        g.setColor(Color.BLACK);
        g.fillRect(tl.getI(), tl.getJ(), w, h);
        g.setColor(Color.RED);
        g.drawRect(tl.getI(), tl.getJ(), w, h);
        g.setColor(Color.WHITE);
        g.fillRect(200, 220, 70, 230);

        g.setColor(Color.BLACK);
        fire.setExternalForce(externalForce);
        if(!isPaused){
            FireDrawer.drawFire(g, sc, fire);
        }


//        g.drawString(String.format("Mu=%.2f", f.getMu()), 10, 30);
//        g.drawString(String.format("F=%.0f", externalForce.getValue()), 10, 50);
    }

    public int getStadge() {
        return stadge;
    }

    public void setStadge(int stadge) {
        this.stadge = stadge;
        fire.setStadge(stadge);
    }

    public Field getF() {
        return f;
    }

    public void setF(Field f) {
        this.f = f;
    }

    public ForceSource getExternalForce() {
        return externalForce;
    }
}
