import java.util.Scanner;

public class BinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int decimal = scanner.nextInt();
        String binary = Integer.toBinaryString(decimal);
        System.out.println("Двоичное представление числа: "+binary);
    }
}
