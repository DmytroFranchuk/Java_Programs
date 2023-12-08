package org.example.pole.chudes;

public class GrandChild extends Thread{
    private final Bascket bascket;

    public GrandChild(int id, Bascket bascket) {
        super("Внучара " +id);
        this.bascket = bascket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Candy candy = bascket.getCandy();
                System.out.printf("%s жует конфету %d%n", getName(), candy.getId());
                Thread.sleep(3000);
                System.out.printf("%s употребил конфету %d%n", getName(), candy.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
