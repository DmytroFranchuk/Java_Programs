package org.zadanie.task1.clases;

import org.zadanie.task1.reflect.InvokeFirst;

public class SmartHouse {
    private static final String NAME = SmartHouse.class.getSimpleName() + ": ";
    public void callEmergency() {
        System.out.println(NAME + "звонит в полицию");
    }
    @InvokeFirst
    public void turnOnLight() {
        System.out.println(NAME + "включил свет");
    }
    @InvokeFirst
    public void turnOffSecurityAlarm() {
        System.out.println(NAME + "выключил сигнализацию");
    }

    public void sleep() {
        System.out.println(NAME + "спит");
    }


}
