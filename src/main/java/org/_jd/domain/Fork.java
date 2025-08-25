package org._jd.domain;

import java.util.concurrent.atomic.AtomicBoolean;

public class Fork implements Item{
    private int number;
    private AtomicBoolean isBusy;
    private Folk folk;

    public Fork(int number) {
        this.number = number;
        this.isBusy = new AtomicBoolean(false);
        this.folk = null;
    }

    public void takeFork(Folk folk){
        synchronized (this){
            this.folk = folk;
            this.isBusy.set(true);
        }

    }

    public void releaseFork(Folk folk){
//        synchronized (this){
            if (this.folk.equals(folk)) {
                this.isBusy.set(false);
                this.folk = null;
//            }
        }
    }

    public AtomicBoolean isBusy() {
        return isBusy;
    }

    public Folk getFolk() {
        return folk;
    }

    @Override
    public String toString() {
        return "fork #" + this.number;
    }
}
