import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Написать класс Обработчик который:

 — записывать в текстовый файл всех девелоперов в формате : Jonn-[auto: BMW ::: salary: 12345] в столбик.
 Т.е в файле нужна только эта инфа
*/

public class Handler {
    public List<String> getMenHaveSportCar(List<Developer> developers) {
        return developers.stream()
                .filter(developer -> developer.getGender()=='M' && developer.getCar().getSport())
                .map(Developer::getSurname)
                .collect(Collectors.toList());
        }

    public Map<Character, List<Car>> grouppingCarGender(List<Developer> developers) {
        return developers.stream()
                .collect(Collectors
                        .groupingBy(Developer::getGender, Collectors.
                                mapping(Developer::getCar, Collectors.toList())));
    }
    public Map<Developer, Integer> getMaxCarSpeedByDeveloper(List<Developer> developers) {
        return developers.stream()
                .collect(Collectors.toMap(developer -> developer,
                        developer -> developer.getCar().getMaxSpeed(), Integer::max));
    }
    public void writeToFile(List<Developer> developers, String fileName) {
        try  (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Developer developer : developers) {
                String line = developer.getSurname() + "-[auto: " + developer.getCar().getBrand() +
                        " ::: salary: " + developer.getSalary() + "]";
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data has been written to the file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            }
    }

}
