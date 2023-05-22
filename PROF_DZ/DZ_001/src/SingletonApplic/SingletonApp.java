package SingletonApplic;

public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {
        /*
         Класс Singleton имеет приватный конструктор поэтому не мы можем создавать
         экземпляр этого класса с помощью new
         Singleton s = new Singleton();
         Singleton s2 = new Singleton();
        */
        final int SIZE = 1000;

        Thread t[] = new Thread[SIZE];
        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }

        for (int i = 0; i < SIZE; i++) {
            t[i].join();

        }


//        Singleton1 arr[] = new Singleton1[SIZE] ;
//        for (int i = 0; i < SIZE; i++) {
//            arr[i] = Singleton1.getInstance();
//        }
            System.out.println(Singleton1.counter);
        }
    }

