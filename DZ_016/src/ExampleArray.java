import java.util.Random;

public class ExampleArray {

    public static int[] createArray(int sizeArr, int maxValue){
        int [] array = new int[sizeArr];
        Random rd = new Random();
        for (int i = 0; i < sizeArr; i++) {
            array[i] = rd.nextInt(maxValue+1);
        }
        rd = null;
        return array;
    }
}
