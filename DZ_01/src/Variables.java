import java.util.Scanner;

public class Variables {
    static byte     globalByte;
    static short    globalShort;
    static int      globalInt;
    static long     globalLong;
    static float    globalFloat;
    static double   globalDouble;
    static boolean  globalBoolean;
    static char     globalChar;

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        byte        localByte;
        short       localShort;
        int         localInt;
        long        localLong;
        float       localFloat;
        double      localDouble;
        boolean     localBoolean;
        char        localChar;

        System.out.print("Enter a byte value (-128 - 127): ");
        globalByte = scanner.nextByte();
        System.out.print("Enter a byte value -128 - 127: ");
        localByte = scanner.nextByte();

        System.out.print("Enter a short value (-32768 - 32767): ");
        globalShort = scanner.nextShort();
        System.out.print("Enter a short value (-32768 - 32767): ");
        localShort = scanner.nextShort();

        System.out.print("Enter a int value (-2_147_483_648 - 2_147_483_647): ");
        globalInt = scanner.nextInt();
        System.out.print("Enter a int value (-2_147_483_648 - 2_147_483_647): ");
        localInt = scanner.nextInt();

        System.out.print("Enter a long value (-9_223_372_036_854_775_808 - 9_223_372_036_854_775_807): ");
        globalLong = scanner.nextLong();
        System.out.print("Enter a long value (-9_223_372_036_854_775_808 - 9_223_372_036_854_775_807): ");
        localLong = scanner.nextLong();

        System.out.print("Enter a float value (1.4e-45f - 3.4e+38f): ");
        globalFloat = scanner.nextFloat();
        System.out.print("Enter a float value (1.4e-45f - 3.4e+38f): ");
        localFloat = scanner.nextFloat();

        System.out.print("Enter a double value (4.9e-324 - 1.7e+308): ");
        globalDouble = scanner.nextDouble();
        System.out.print("Enter a double value (4.9e-324 - 1.7e+308): ");
        localDouble = scanner.nextDouble();

        System.out.print("Enter a boolean value (true false): ");
        globalBoolean = scanner.nextBoolean();
        System.out.print("Enter a boolean value (true false): ");
        localBoolean = scanner.nextBoolean();

        System.out.print("Enter a char value: ");
        globalChar = scanner.next().charAt(0);
        System.out.print("Enter a char value: ");
        localChar = scanner.next().charAt(0);

//        System.out.println("globalByte: "   + globalByte + " localByte: "       + localByte);
//        System.out.println("globalShort: "  + globalShort + " localShort: "     + localShort);
//        System.out.println("globalInt: "    + globalInt + " localInt: "         + localInt);
//        System.out.println("globalLong: "   + globalLong + " localLong: "       + localLong);
//        System.out.println("globalFloat: "  + globalFloat + " localFloat: "     + localFloat);
//        System.out.println("globalDouble: " + globalDouble + " localDouble: "   + localDouble);
//        System.out.println("globalBoolean: "+ globalBoolean + " localBoolean: " + localBoolean);
//        System.out.println("globalChar: "   + globalChar + " localChar: "       + localChar);
        
        System.out.print('\u2554');
        for (int i = 0; i<112; i++) {
            if (i==14|i==28|i==42|i==56|i==70|i==84|i==98){
                System.out.print('\u2566');}
            System.out.print('\u2550');}
        System.out.println('\u2557');
        System.out.println('\u2551'+"     Byte     "+'\u2551'+"    Short     "+'\u2551'+"     Int      "
                +'\u2551'+"     Long     "+'\u2551'+"    Float     "+'\u2551'+"    Double    "
                +'\u2551'+"   Boolean    "+'\u2551'+"     Char     "+'\u2551');

        System.out.print('\u2560');
        for (int i = 0; i<112; i++) {
            if (i==14|i==28|i==42|i==56|i==70|i==84|i==98){
                System.out.print('\u256C');
            }
            System.out.print('\u2550');
        }
        System.out.println('\u2563');

        System.out.println('\u2551'+"     Byte     "+'\u2551'+"    Short     "+'\u2551'+"     Int      "
                +'\u2551'+"     Long     "+'\u2551'+"    Float     "+'\u2551'+"    Double    "
                +'\u2551'+"   Boolean    "+'\u2551'+"     Char     "+'\u2551');

        System.out.print('\u255A');
        for (int i = 0; i<112; i++) {
            if (i==14|i==28|i==42|i==56|i==70|i==84|i==98){
                System.out.print('\u2569');
            }
            System.out.print('\u2550');
        }
        System.out.println('\u255D');

        System.out.println("I--------------|--------------|--------------|--------------|--------------|--------------|--------------|--------------I");
        System.out.println("|     Byte     |    Short     |     Int      |     Long     |    Float     |    Double    |   Boolean    |     Char     |");
        System.out.println("I--------------|--------------|--------------|--------------|--------------|--------------|--------------|--------------I");
        System.out.printf("|%14d|%14d|%14d|%14d|%14.4f|%14.4f|%14b|%14s|\n", globalByte, globalShort, globalInt, globalLong, globalFloat, globalDouble, globalBoolean, globalChar);
        System.out.println("I--------------|--------------|--------------|--------------|--------------|--------------|--------------|--------------I");
        System.out.printf("|%14d|%14d|%14d|%14d|%14.4f|%14.4f|%14b|%14s|\n", localByte, localShort, localInt, localLong, localFloat, localDouble, localBoolean, localChar);
        System.out.println("I--------------|--------------|--------------|--------------|--------------|--------------|--------------|--------------I");



    }
}
