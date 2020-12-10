package com.company.timers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import com.company.model.World;

public abstract class AbstractWorldTimer {
    protected World actualWorld;
    private Timer timer;

    public AbstractWorldTimer(World world, int period) {
        this.actualWorld = world;
        timer = new Timer(period, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!actualWorld.isPaused) {
                    worldAction(actualWorld);
                }else{
                    actualWorld.setStadge(-1);
                    worldAction(actualWorld);
                }
            }
        });
    }

    public void start() {
        timer.start();
    }
    public void stop() {
        timer.stop();
    }
    public void setPeriod(int delay) {
        timer.setDelay(delay);
    }

    abstract void worldAction(World w);
}
