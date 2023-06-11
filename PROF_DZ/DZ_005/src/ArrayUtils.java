import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayUtils {
    public static <T> T[] swap(T[] arr, int index1, int index2) {
        if (index1 < 0 || index1 >= arr.length || index2 < 0 || index2 >= arr.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        T[] newArr1 = (T[]) new Object[arr.length];
        T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
            newArr1[i] = newArr[i];
        }
        T tmp = newArr[index1];
        newArr[index1] = newArr[index2];
        newArr[index2] = tmp;
        return newArr;
    }

    public static <T> void printArray(T[] arr){
        System.out.print("printArray [");
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) {
                System.out.print(arr[i] + "]");
                System.out.println();
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
