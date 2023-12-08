package org.ls_2023_12_07_Thread2.model1_ConsumerProducer;

public class Grandparent extends Thread {
    private final Basket basket;

    public Grandparent(int id, Basket bascket) {
        super("Бабушка " + id);
        this.basket = bascket;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                try {
                    Candy candy = new Candy();
                    basket.putCandy(candy);
                    System.out.printf("%s положил конфету %d%n", getName(), candy.getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("%s ждет пенсию%n", getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
