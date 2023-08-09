package autoservice;

import java.time.LocalDate;

public class Realization {
    public static void main(String[] args) {
        System.out.println("Начало работы сервиса " + LocalDate.now());
        AutoService autoService = new AutoService();
        Auto auto1 = new Auto(2012, "Toyota", "Camry", TypeTire.SUMMER, TypeAuto.HYBRID);
        Auto auto2 = new Auto(2013, "Toyota", "Corolla", TypeTire.WINTER, TypeAuto.DIESEL);
        Auto auto3 = new Auto(2014, "Toyota", "Rav4", TypeTire.SUMMER, TypeAuto.ELECTRICAL);
        Auto auto4 = new Auto(2015, "Toyota", "Tacoma", TypeTire.WINTER, TypeAuto.GASOLINE);
        auto1.breakCar(true);
        auto3.breakCar(false);
        auto2.driveCar("Вперед");
        auto4.turnOnCar(Control.BUTTON);
        auto2.turnOnCar(Control.REMOTE);
        auto1.turnOnCar(Control.KEY);
        autoService.fixCar(auto1);
        autoService.fixCar(auto2);
        autoService.changeTires(auto3, 4);
        autoService.changeTires(auto4, 2);

        System.out.println("Конец работы сервиса");
    }
}
