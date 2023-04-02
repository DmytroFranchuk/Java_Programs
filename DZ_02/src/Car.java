public class Car {
    private String model;
    private int speed;
    private double price;
    private String color;
    private boolean isElectric;

    public Car(String model, int speed, String color) {
        this.model = model;
        this.speed = speed;
        this.color = color;
    }

    public Car(String model, int speed, double price, String color, boolean isElectric) {
        this.model = model;
        this.speed = speed;
        this.price = price;
        this.color = color;
        this.isElectric = isElectric;
    }

    public void out() {
        System.out.println("Марка авто: "+getModel()+" Скорость: "+getSpeed()+"км/ч"+" Цена: "+getPrice()+"$"+
                " Цвет: "+getColor()+" Электропривод: "+isElectric);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }
    static int add(int a, int b) {
        return a+b;
    }
    static int sub(int a, int b) {
        return a-b;
    }
    static long mul(int a, int b) {
        return a*b;
    }
    static double div(int a, int b) {
        return a/b;
    }
    static void metod_A(int a, int b, int c) {
        if (a > b && a > c) {
            System.out.println("Первая переменная больше двух других");
        } else {
            System.out.println("Первая переменная не больше двух других");
        }
    }
    static void metod_B(int a, int b, int c) {
        if (a > b || a > c) {
            System.out.println("Первая переменная больше хотя бы одной другой");
        } else {
            System.out.println("Первая переменная не больше ни одной другой");
        }
    }
    static void metod_C(int a, int b, int c) {
        if ((a > b && a < c) || (a < b && a > c)) {
            System.out.println("Первая переменная больше только одной другой");
        } else {
            System.out.println("Первая переменная не больше только одной другой");
        }
    }
}
