package org.ls_2023_12_07_Thread2.model1_ConsumerProducer;

public class GrandChild extends Thread {
    private final Basket basket;

    public GrandChild(int id, Basket bascket) {
        super("Внучара " + id);
        this.basket = bascket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Candy candy = basket.getCandy();
                System.out.printf("%s жует конфету %d%n", getName(), candy.getId());
                Thread.sleep(3000);
                System.out.printf("%s употребил конфету %d%n", getName(), candy.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
