import java.util.List;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        List<Developer> developers = generator.generateDevelopers(5);
        Handler handler = new Handler();
        System.out.println(handler.getMenHaveSportCar(developers));
        System.out.println(handler.grouppingCarGender(developers));
        System.out.println(handler.getMaxCarSpeedByDeveloper(developers));
        handler.writeToFile(developers, "Auto.txt");
    }
}
