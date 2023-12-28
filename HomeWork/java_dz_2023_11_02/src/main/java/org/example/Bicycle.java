package org.example;

import java.util.Random;

/**
 * Класс, представляющий велосипед.
 */

public class Bicycle {
    private BicyclePart handlebar;
    private BicyclePart saddle;
    private BicyclePart wheel;
    private BicyclePart gears;
    private BicyclePart frame;

    public Bicycle() {
        Random rd = new Random();
        this.handlebar = new BicyclePart("Руль", rd.nextInt(50, 100));
        this.saddle = new BicyclePart("Седло", rd.nextInt(50, 100));
        this.wheel = new BicyclePart("Колесо", rd.nextInt(50, 100));
        this.gears = new BicyclePart("Передачи", rd.nextInt(50, 100));
        this.frame = new BicyclePart("Рама", rd.nextInt(50, 100));
    }

    public boolean useHandlebar(int damage) {
        handlebar.use(damage);
        System.out.println(handlebar.getCount() + " handlebar: " + handlebar.getStrength());
        return handlebar.isBroken();
    }

    public boolean useSaddle(int damage) {
        saddle.use(damage);
        System.out.println(saddle.getCount() + " saddle: " + saddle.getStrength());
        return saddle.isBroken();
    }

    public boolean useWheel(int damage) {
        wheel.use(damage);
        System.out.println(wheel.getCount() + " wheel: " + wheel.getStrength());
        return wheel.isBroken();
    }

    public boolean useGears(int damage) {
        gears.use(damage);
        System.out.println(gears.getCount() + " gears: " + gears.getStrength());
        return gears.isBroken();
    }

    public boolean useFrame(int damage) {
        frame.use(damage);
        System.out.println(frame.getCount() + " frame: " + frame.getStrength());
        return frame.isBroken();
    }
}
