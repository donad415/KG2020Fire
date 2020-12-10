package com.company.model;

import com.company.math.Vector2;
import com.company.utils2d.ScreenConverter;

import java.awt.*;
import java.util.Random;

public class FireDrawer {
    public static void drawFire(Graphics2D g, ScreenConverter sc, Fire fire) {

        int wind = (int)fire.getExternalForce().getValue();

//        int radius = (int)fire.getAura().getRadius();
//        for(int i=radius; i>0; i--){
//            g.setColor(new Color(230, 200-20*i, 0));
//            g.fillOval(235-i, 220-i, 2*i, 2*i);
//        }

        Vector2 pointTop = fire.getPointTop();
        double startTopY = pointTop.getY();
        pointTop.setY(startTopY - fire.getStadge() * Math.random() * 1.5);
        Vector2 pointBottom = fire.getPointBottom();

        for (int i = (int) pointTop.getY(); i < (int) pointBottom.getY(); i++) {
            if (i <= (pointBottom.getY() - pointTop.getY()) * 0.6 + pointTop.getY()) {
                for (int j = (int) (pointTop.getX() - Math.sqrt(i - pointTop.getY()) - 2); j < (int) (pointTop.getX() + Math.sqrt(i - pointTop.getY()) + 2); j++) {
                    g.setColor(getColor(fire.getStadge(), j, i, false, (int) pointBottom.getX(), (int) pointBottom.getY()));
                 //   g.drawLine(j, i, j, i);
                    int xW = (int)afterWind(j, i, pointTop, pointBottom, wind).getX();
                    g.drawLine(xW, i, xW,i);
                }
            } else {
                for (int j = (int) (pointTop.getX() - Math.pow((pointBottom.getY() - i) + 20, 0.55)); j < (int) (pointTop.getX() + Math.pow((pointBottom.getY() - i) + 20, 0.55)); j++) {
                    g.setColor(getColor(fire.getStadge(), j, i, true, (int) pointBottom.getX(), (int) pointBottom.getY()));
                    g.drawLine(j, i, j, i);
                }
            }
        }
        pointTop.setY(startTopY);

    }

    private static Color getColor(int stage, int x, int y, boolean isBot, int xCenter, int yBot) {
        int G = 0;
        int R = 0;
        int B = 0;

        if (!isBot) {
            G = 100 + Math.abs(xCenter - x) * stage;
            R = 200 + Math.abs(xCenter - x) * stage / 3;
            B = 55;
        } else {
            if ((yBot - y) - Math.abs(xCenter - x) * Math.random() < 15) {
                R = 50;
                G = 10;
                B = 80 + Math.abs(xCenter - x) * stage;
            } else {
                G = 100 + Math.abs(xCenter - x) * stage;
                R = 200 + Math.abs(xCenter - x) * stage / 3;
                B = 55;
            }
        }

        Color color = new Color(R, G, B);
        return color;
    }

    private static Vector2 afterWind(int x, int y, Vector2 pointTop, Vector2 pointBottom, int wind) {
        int dY = (int)(pointBottom.getY()-pointTop.getY());

        if(wind==10){
           // x = (int)Math.pow((pointBottom.getY() - pointTop.getY()) * 0.6 + pointTop.getY()-y, 2) +x;
            x= (int) (x+ 120/(y-pointTop.getY()+3));
        }else if(wind==-10){
            x = x- (int)Math.pow((pointBottom.getY() - pointTop.getY()) * 0.6 + pointTop.getY()-y, 0.9) ;
        }

        Vector2 output = new Vector2(x, y);

        return output;
    }
}
