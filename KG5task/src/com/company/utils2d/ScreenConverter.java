package com.company.utils2d;

import com.company.math.Rectangle;
import com.company.math.Vector2;

public class ScreenConverter {
    private double xr, yr, wr, hr;
    private int ws, hs;

    public ScreenConverter(double xr, double yr, double wr, double hr, int ws, int hs) {
        this.xr = xr;
        this.yr = yr;
        this.wr = wr;
        this.hr = hr;
        this.ws = ws;
        this.hs = hs;
    }

    public ScreenConverter(Rectangle real, int width, int height) {
        this(real.getLeft(), real.getHeight(), real.getWidth(), real.getHeight(), width, height);
    }

    public ScreenPoint r2s(Vector2 p) {
        int i = (int)((p.getX() - xr)*ws/wr);
        int j = (int)((yr - p.getY())*hs/hr);
        return new ScreenPoint(i, j);
    }

    public Vector2 s2r(ScreenPoint p) {
        double x = xr + p.getI()*wr/ws;
        double y = yr - p.getJ()*hr/hs;
        return new Vector2(x, y);
    }

    public int r2sDistanceH(double d) {
        /*Можно написать проще*/
        return r2s(new Vector2(d, 0)).getI() - r2s(new Vector2(0, 0)).getI();
    }

    public int r2sDistanceV(double d) {
        /*Можно написать проще*/
        return r2s(new Vector2(0, 0)).getJ() - r2s(new Vector2(0, d)).getJ();
    }

    public double getHr() {
        return hr;
    }

    public void setHr(double hr) {
        this.hr = hr;
    }

    public int getHs() {
        return hs;
    }

    public void setHs(int hs) {
        this.hs = hs;
    }

    public double getWr() {
        return wr;
    }

    public void setWr(double wr) {
        this.wr = wr;
    }

    public int getWs() {
        return ws;
    }

    public void setWs(int ws) {
        this.ws = ws;
    }

    public double getXr() {
        return xr;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public double getYr() {
        return yr;
    }

    public void setYr(double yr) {
        this.yr = yr;
    }




}
