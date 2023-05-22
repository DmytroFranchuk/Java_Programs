package SingletonApplic;

public class Singleton1 {
    public static int counter = 0;
    private  static Singleton1 instance;
    private Singleton1(){
        counter++;
    }

    public static synchronized Singleton1 getInstance(){
        if (instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

}
