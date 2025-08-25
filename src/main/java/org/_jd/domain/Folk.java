package org._jd.domain;

public class Folk implements Runnable, Item {
    private int number;
    private boolean saturated;
    private int saturationCnt;
    Fork f1;
    Fork f2;

    public Folk(int number, Fork f1, Fork f2) {
        this.number = number;
        this.saturated = false;
        this.saturationCnt = 0;
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public void run() {
        while (saturationCnt < 3){
            eat();
        }
    }

    public void eat(){
        if (!f1.isBusy().get() && !f2.isBusy().get() && !this.saturated) {
            this.f1.takeFork(this);
            this.f2.takeFork(this);
            this.saturated = true;
            ++saturationCnt;
            System.out.println(toString() + " Om-nom-nom!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            think();
        } else think();
    }

    public void think(){
        if (f1.isBusy().get() && f1.getFolk().equals(this))
            this.f1.releaseFork(this);
        if (f2.isBusy().get() && f2.getFolk().equals(this))
            this.f2.releaseFork(this);
        this.saturated = false;
        System.out.println(toString() + " Hmmm...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Folk{" +
                "number=" + number +
                '}';
    }
}
