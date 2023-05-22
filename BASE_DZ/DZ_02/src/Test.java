public class Test {
    public static void main(String[] args) {
        Car car = new Car("Toyota",180, 12000, "Gray", true);
        car.out();
        System.out.println(Car.add(379,986));
        System.out.println(Car.sub(2340, 3075));
        System.out.println(Car.mul(34, 10));
        System.out.println(Car.div(300, 30));
        Car.metod_A(4,5,7);
        Car.metod_B( 8,7,10);
        Car.metod_C(9,4,23);
    }

}
