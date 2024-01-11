package dining.philosophers.model;

public class Philosopher extends Thread {
    private final int id;
    private final Object leftFork;
    private final Object rightFork;

    public Philosopher(int id, Object leftFork, Object rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating");
        Thread.sleep((long) (Math.random() * 1000));
    }

    public void run() {
        try {
            while (true) {
                think();

                synchronized (leftFork) {
                    System.out.println("Philosopher " + id + " picked up left fork");
                    synchronized (rightFork) {
                        System.out.println("Philosopher " + id + " picked up right fork");

                        eat();

                        System.out.println("Philosopher " + id + " put down right fork");
                    }
                    System.out.println("Philosopher " + id + " put down left fork");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
