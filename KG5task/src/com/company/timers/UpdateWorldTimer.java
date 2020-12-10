package com.company.timers;


import com.company.model.World;

public class UpdateWorldTimer extends AbstractWorldTimer {

    private long last;
    public UpdateWorldTimer(World world, int period) {
        super(world, period);
    }

    @Override
    void worldAction(World w) {
        long time = System.currentTimeMillis();
        actualWorld.update((time - last));
        last = time;
    }

    @Override
    public void start() {
        last = System.currentTimeMillis();
        super.start();
    }


}
