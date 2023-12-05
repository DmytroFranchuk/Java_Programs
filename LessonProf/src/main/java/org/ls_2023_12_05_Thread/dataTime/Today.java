package org.ls_2023_12_05_Thread.dataTime;

import java.time.LocalDate;

public class Today {
    private MyDate myDate = new MyDate(0,0,0);

    public synchronized MyDate getTodayDate(){
        myDate = new MyDate(LocalDate.now().getDayOfMonth(),LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return myDate;
    }

    public synchronized MyDate getMyDate() {
        return myDate;
    }
}
