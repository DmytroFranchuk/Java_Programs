package shop;

import org.json.JSONObject;
import shop.products.Drinks;
import shop.products.Foods;
import shop.products.Snacks;
import shop.products.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Generator {
    private final List<Table> table = new ArrayList<>();
    private final List<Drinks> drinks = new ArrayList<>();
    private final List<Snacks> snacks = new ArrayList<>();
    private final List<Foods> foods = new ArrayList<>();
    private boolean flagCreateReport = false;

    public Generator(String pathFile) {
        createListsFromFile(pathFile);
        if (!table.isEmpty()) {
            createDrinksList();
            createSnacksList();
            createFoodList();
            if (!drinks.isEmpty() && !snacks.isEmpty() && !foods.isEmpty()) {
                flagCreateReport = true;
            }
        }
    }

    private Table parseLine(String line) {
        JSONObject jsonObject = new JSONObject(line);
        String category = jsonObject.getString("CATEGORY");
        String name = jsonObject.getString("NAME");
        name = name.substring(0, name.indexOf("#"));
        String factory = jsonObject.getString("FACTORY");
        factory = factory.substring(0, factory.indexOf("#"));
        Integer quantity = jsonObject.getInt("QUANTITY");
        boolean isPacked = jsonObject.getBoolean("ISPACKED");
        boolean isAdv = jsonObject.getBoolean("ISADV");
        double price = jsonObject.getDouble("PRICE");
        double margin = jsonObject.getDouble("MARGIN");
        boolean isDebt = jsonObject.getBoolean("ISDEBT");
        return new Table(category, name, factory, quantity, isPacked, isAdv, price, margin, isDebt);
    }

    private List<Table> createListsFromFile(String pathFileReport) {
        try (BufferedReader fileReport = new BufferedReader(new FileReader(pathFileReport))) {
            String line;
            while ((line = fileReport.readLine()) != null) {
                table.add(parseLine(line));
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "An error occurred", e);
        }
        return table;
    }

    private List<Drinks> createDrinksList() {
        List<Table> drinksTable = new ArrayList<>(table).stream()
                .filter(d -> d.getCategory().startsWith("DRINKS")).toList();
        int key = 0;
        for (Table drink : drinksTable) {
            drinks.add(key, new Drinks(drink.getCategory(), drink.getName(), drink.getFactory(), drink.getQuantity(),
                    drink.isPacked(), drink.isAdv(), drink.getPrice(), drink.getMargin(), drink.isDebt()));
            key++;
        }
        return drinks;
    }

    private List<Snacks> createSnacksList() {
        List<Table> snacksTable = new ArrayList<>(table).stream()
                .filter(s -> s.getCategory().startsWith("SNACKS")).toList();
        int key = 0;
        for (Table snack : snacksTable) {
            snacks.add(key, new Snacks(snack.getCategory(), snack.getName(), snack.getFactory(), snack.getQuantity(),
                    snack.isPacked(), snack.isAdv(), snack.getPrice(), snack.getMargin(), snack.isDebt()));
            key++;

        }
        return snacks;
    }

    private List<Foods> createFoodList() {
        List<Table> foodTable = new ArrayList<>(table).stream()
                .filter(s -> s.getCategory().startsWith("FOOD")).toList();
        int key = 0;
        for (Table food : foodTable) {
            foods.add(key, new Foods(food.getCategory(), food.getName(), food.getFactory(), food.getQuantity(),
                    food.isPacked(), food.isAdv(), food.getPrice(), food.getMargin(), food.isDebt()));
            key++;
        }
        return foods;
    }

    // Task 1
    public Map<String, List<Integer>> idAllProducts() {
        if (flagCreateReport) {
            List<String> categories = new ArrayList<>(table).stream().map(Table::getCategory).distinct().toList();
            return categories.stream()
                    .map(str -> str.split("#"))
                    .collect(Collectors.groupingBy(arr -> arr[0],
                            Collectors.mapping(arr -> Integer.parseInt(arr[1]), Collectors.toList())));
        }
        return null;
    }

    // Task 2
    public List<Snacks> mostExpensiveSNACKS() {
        if (flagCreateReport) {
            List<Snacks> result = new ArrayList<>();
            int maxKey;
            double maxCost = 0.00;
            Snacks maxElem = null;
            for (Snacks i : snacks) {
                if (i.getPrice() > maxCost) {
                    maxCost = i.getPrice();
                    maxKey = snacks.indexOf(i);
                    maxElem = snacks.get(maxKey);
                }
            }
            for (Snacks i : snacks) {
                if (maxElem != null && i.getPrice() == maxElem.getPrice()) {
                    result.add(i);
                    System.out.println(i);
                }
            }
            return result;
        }
        return null;
    }

    // Task 3
    public String findHighestCost() {
        if (flagCreateReport) {
            Map<String, List<Table>> keyName = new HashMap<>();
            System.out.println();
//            int count = 1;
            for (Table elem : table) {
                String key = elem.getName();
                if (keyName.containsKey(key)) {
                    keyName.get(key).add(elem);
                } else {
                    List<Table> tempList = new ArrayList<>();
                    tempList.add(elem);
                    keyName.put(key, tempList);
                }
            }
            double cost;
            double sum = 0;
//            int maxKey = 0;
            double maxCost = 0.00;
            String maxElement = null;
            for (String i : keyName.keySet()) {
                for (Table tab : keyName.get(i)) {
                    cost = tab.getPrice() * tab.getQuantity();
                    sum = sum + cost;
                }
                if (sum > maxCost) {
                    maxCost = sum;
                    maxElement = i;
                }
                sum = 0;
//                count++;
            }
            return ("Name: " + maxElement + " totalCost: " + maxCost);
        }
        return null;
    }
}