public class Box {
    private int width, length, height;

    public Box(int width, int length, int height) {
        this.width = width;
        this.length = length;
        this.height = height;
        System.out.println("Объём коробки: "+ width*length*height + " см3");
    }
}
