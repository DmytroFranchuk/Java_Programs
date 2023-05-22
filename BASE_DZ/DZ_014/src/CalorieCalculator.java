public class CalorieCalculator {
    static double valueAreaOfCircle(double Diameter) {
        return Math.PI*Math.pow(Diameter, 2);
    }
    public static void main(String[] args) {
        int caloriesPizza = 40;
        double caloriesDifference = caloriesPizza*(valueAreaOfCircle(28)-valueAreaOfCircle(24));
        System.out.println("Разница составляет: "+(int)caloriesDifference+" калл");
    }
}
