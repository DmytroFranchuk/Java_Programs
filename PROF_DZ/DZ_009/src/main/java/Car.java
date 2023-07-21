public class Car {
    private final String color;
    private final Boolean isSport;
    private final Brands brand;
    private final Integer maxSpeed;

    public Car(String color, Boolean isSport, Brands brand, Integer maxSpeed) {
        this.color = color;
        this.isSport = isSport;
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public Boolean getSport() {
        return isSport;
    }

    public Brands getBrand() {
        return brand;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", isSport=" + isSport +
                ", brand=" + brand +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

