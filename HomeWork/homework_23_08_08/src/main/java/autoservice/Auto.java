package autoservice;

public class Auto {
    private final int carYear;
    private final String carModel;
    private final String carBrand;
    private final int tire;
    private final TypeTire typeTire;
    private final TypeAuto typeAuto;

    public Auto(int carYear, String carModel, String carBrand, TypeTire typeTire, TypeAuto typeAuto) {
        int tire = 4;
        this.carYear = carYear;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.tire = tire;
        this.typeTire = typeTire;
        this.typeAuto = typeAuto;
    }

    public int getCarYear() {
        return carYear;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public TypeTire getTypeTire() {
        return typeTire;
    }

    public TypeAuto getTypeAuto() {
        return typeAuto;
    }

    public void driveCar(String direction) {
        System.out.println("Машина едет: " + direction);
    }

    public int getTire() {
        return tire;
    }

    public void breakCar(Boolean isCritical) {
        if (isCritical) {
            System.out.println("Поломка, требуется вызвать эвакуатор");
        } else {
            System.out.println("Поломка, требуется в сервис");
        }
    }

    public void turnOnCar(Control control) {
        switch (control) {
            case KEY -> System.out.println("Машина включается с помощью ключа зажигания");
            case BUTTON -> System.out.println("Машина включается с помощью кнопки зажигания");
            case REMOTE -> System.out.println("Машина включается с помощью дистанционного пульта");
        }
    }
}
