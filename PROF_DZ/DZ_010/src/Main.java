import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Java\\DZ\\PROF_DZ\\DZ_010\\src\\email.txt";
        String regex = "@(\\S+)$";
        ReadFile readFile = new ReadFile();
        // Task 1
        Map<String, Integer> domainCountMap = readFile.createMapUsingRegex(filePath, regex);
        readFile.printMap(domainCountMap);
        // Task 2
        String inputFile = "C:\\Java\\DZ\\PROF_DZ\\DZ_010\\src\\url.txt";
        readFile.replaceUrlProtocol(inputFile);
        // Task 3
        inputFile = "C:\\Java\\DZ\\PROF_DZ\\DZ_010\\src\\code.txt";
        regex = "([A-Z0-9]+):(\\d+)";
        readFile.findProductsMoreThan10(inputFile, regex);
    }
}


