import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
    private final Map<String, Integer> domainCountMap = new HashMap<>();

    public void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public Map<String, Integer> createMapUsingRegex(String inputFile, String regex) {
        Pattern emailPattern = Pattern.compile(regex);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while((line = br.readLine()) != null) {
                String domain = extractDomainUsingRegex(line, emailPattern);
                domainCountMap.compute(domain, (key, value) -> value == null ? 1 : value + 1);
            }
        }
        catch (IOException e) {
            System.out.println("Файл: " + inputFile + " не найден");
        }
        return domainCountMap;
    }
    private String extractDomainUsingRegex(String email, Pattern pattern) {
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
    public void replaceUrlProtocol(String inputFile) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while((line = reader.readLine()) != null) {
                content.append(line.replace("https://", "http://")).append("\n");
            }
        }
        catch (IOException e) {
            System.out.println("Файл: " + inputFile + " не найден");
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write(content.toString());
        }
        catch (IOException e) {
            System.out.println("Файл: " + inputFile + " не найден");
        }
    }
    public void findProductsMoreThan10(String inputFile, String regex) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);
                if(matcher.matches()) {
                    String productCode = matcher.group(1);
                    int quantity = Integer.parseInt(matcher.group(2));
                    if(quantity > 10) {
                        System.out.println("Product Code: " + productCode + ", Quantity: " + quantity);
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("Файл: " + inputFile + " не найден");
        }
    }
}
