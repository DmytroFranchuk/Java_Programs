package org.task2;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
@Lazy
public class Refrigerator {

    private Map<String, Map.Entry<List<FoodItem>, Integer>> productToActualToExpectedCount;

    @Autowired
    public Refrigerator(Map<String, FoodItem> nameToProduct) {
        this.productToActualToExpectedCount = new HashMap<>();
        fillIntInfo(nameToProduct);
    }

    private void fillIntInfo(Map<String, FoodItem> nameToProduct) {
        System.out.println("Для каждого типа продукта введите желаемое количество продуктов: ");
        Scanner scanner = new Scanner(System.in);
        nameToProduct.forEach((k, v) -> {
            System.out.print(k + ":");
            int count = scanner.nextInt();
            productToActualToExpectedCount.put(k, new AbstractMap.SimpleEntry<>(new ArrayList<>(), count));
        });
    }

//    private List<FoodItem> generateItems(String name){
//        @Autowired
//        ApplicationContext context;
//        int random = ThreadLocalRandom.current().nextInt(10);
//        return Arrays.stream(new Object[random])
//                .map(e-> context.getBean(name, FoodItem.class))
//                .collect(Collectors.toList());
//    }

    public Map<String, Map.Entry<List<FoodItem>, Integer>> getProductToActualToExpectedCount() {
        return productToActualToExpectedCount;
    }
}
