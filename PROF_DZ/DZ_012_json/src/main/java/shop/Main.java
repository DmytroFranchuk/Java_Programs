package shop;

public class Main {
    public static void main(String[] args) {
        String pathFile = "report.json";
        Generator report = new Generator(pathFile);

        // Task 1
        for (String key : report.idAllProducts().keySet()) {
            System.out.println(key + ": " + report.idAllProducts().get(key));
        }
        System.out.println();
        // Task 2
        report.mostExpensiveSNACKS();
        // Task 3
        System.out.println(report.findHighestCost());
    }
}