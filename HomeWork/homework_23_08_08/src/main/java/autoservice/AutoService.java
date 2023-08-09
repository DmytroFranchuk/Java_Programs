package autoservice;

public class AutoService implements ModernAutoService{
    @Override
    public void changeTires(Auto auto, int tire) {
        if (auto.getTypeTire() == TypeTire.SUMMER) {
            System.out.println("Заменили на зимнюю резину " + tire + " колеса");
        }
        if (auto.getTypeTire() == TypeTire.WINTER) {
            System.out.println("Заменили на летнюю резину " + tire + " колеса");
        }
    }

    public void fixCar(Auto auto) {
        System.out.println("В сервис поступил автомобиль: ");
        System.out.println("Год выпуска: " + auto.getCarYear());
        System.out.println("Модель: " + auto.getCarModel());
        System.out.println("Марка: " + auto.getCarBrand());
        System.out.println("Тип: " + auto.getTypeAuto());
        System.out.println("Тип шин: " + auto.getTypeTire());
        System.out.println("Колес в авто: " + auto.getTire());
    }
}
