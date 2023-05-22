package SingletonApplic;

public class R implements Runnable{

    @Override
    public void run() {
        Singleton1.getInstance();
    }
}
