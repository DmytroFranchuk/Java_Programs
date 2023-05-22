import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int [] arr = ExampleArray.createArray(10, 89);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 10;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

