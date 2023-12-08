package org.example.pole.chudes;

public class Grandparent extends Thread{
    private final Bascket bascket;

    public Grandparent(int id, Bascket bascket) {
        super("Бабушка " + id);
        this.bascket = bascket;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                try {
                    Candy candy = new Candy();
                    bascket.putCandy(candy);
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
