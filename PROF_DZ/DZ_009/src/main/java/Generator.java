import com.github.javafaker.Faker;


import java.util.ArrayList;
import java.util.List;

public class Generator {
    static Faker faker = new Faker();
    private Developer generateDeveloper() {
        char gender = 'M';
        String firstName = faker.name().firstName();
        char lastLetter = firstName.charAt(firstName.length() - 1);
        if (lastLetter == 'a' || lastLetter == 'e' || lastLetter == 'u' || lastLetter == 'y') {
            gender = 'F';
        }
        return new Developer(firstName, faker.name().lastName(),
                faker.number().numberBetween(16, 67),
                faker.number().randomDouble(2, 1200, 10001),
                gender,
                generateCar());
    }
    public List<Developer> generateDevelopers(int count) {
        List<Developer> developers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            developers.add(generateDeveloper());
        }
        return developers;
    }

    private Car generateCar() {
        int maxSpeed = faker.number().numberBetween(150, 300);
        var isSport = maxSpeed >= 220;
        return new Car(faker.color().name(),
                       isSport,
                       faker.options().option(Brands.class),
                       maxSpeed);
    }

    public List<Car> generateCars(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(generateCar());
        }
        return cars;
    }
}
