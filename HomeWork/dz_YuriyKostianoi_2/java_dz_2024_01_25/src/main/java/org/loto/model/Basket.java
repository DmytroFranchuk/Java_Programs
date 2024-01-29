package org.loto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Basket {
    private static Basket instance;
    private List<Barrel> barrelList;
    private List<Barrel> deliveryOrder;

    private Basket() {
        barrelList = new ArrayList<>(90);
        deliveryOrder = new ArrayList<>();
        fillBasket();
    }

    private void fillBasket() {
        for (int i = 0; i < 90; i++) {
            Barrel barrel = new Barrel();
            barrelList.add(barrel);
        }
    }

    public static Basket getInstance() {
        if (instance == null) {
            instance = new Basket();
        }
        return instance;
    }

    public Barrel takeBarrel() {
        Barrel takenBarrel = null;
        if (!barrelList.isEmpty()) {
            int barrelIndex = new Random().nextInt(barrelList.size());
            takenBarrel = barrelList.remove(barrelIndex);
            deliveryOrder.add(takenBarrel);
            System.out.println("Basket " + barrelList.size() + ":" + takenBarrel.getBarrelNumber());
        }

        return takenBarrel;
    }

    public void resetBasket() {
        for (int i = deliveryOrder.size() - 1; i >= 0; i--) {
            barrelList.add(deliveryOrder.get(i));
            deliveryOrder.remove(i);
        }
    }

    public List<Barrel> getBarrelList() {
        return barrelList;
    }

//    public List<Barrel> getDeliveryOrder() {
//        return Collections.unmodifiableList(deliveryOrder);
//    }
}
