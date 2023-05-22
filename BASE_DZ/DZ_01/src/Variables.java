import java.util.Scanner;

public class Variables {
    static byte     globalByte = -128;
    static short    globalShort = -32768;
    static int      globalInt = -2_147_483_648;
    static long     globalLong = -9_223_372_036l;
    static float    globalFloat = 234.44456f;
    static double   globalDouble = 3421.44412345;
    static boolean  globalBoolean = false;
    static char     globalChar = 48;
    int id;
    String name;
    double balance;

    public static void tableTopLine() {
        System.out.print('\u2554');
        for (int i = 0; i<112; i++) {
            if (i==14 | i==28 | i==42 | i==56 | i==70 | i==84 | i==98) {
                System.out.print('\u2566');
            }
            System.out.print('\u2550');}
        System.out.println('\u2557');
        System.out.println('\u2551'+"     Byte     "+'\u2551'+"    Short     "+'\u2551'+"     Int      "+
                '\u2551'+"     Long     "+'\u2551'+"    Float     "+'\u2551'+"    Double    "+
                '\u2551'+"   Boolean    "+'\u2551'+"     Char     "+'\u2551');
    }

    public static void tableBottomLine() {
        System.out.print('\u255A');
        for (int i = 0; i<112; i++) {
            if (i==14 | i==28 | i==42 | i==56 | i==70 | i==84 | i==98) {
                System.out.print('\u2569');
            }
            System.out.print('\u2550');
        }
        System.out.println('\u255D');
    }

    public static void tableHorizontalLine() {
        System.out.print('\u2560');
        for (int i = 0; i < 112; i++) {
            if (i==14 | i==28 | i==42 | i==56 | i==70 | i==84 | i==98) {
                System.out.print('\u256C');
            }
            System.out.print('\u2550');
        }
        System.out.println('\u2563');
    }

    static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {

        byte        localByte = 127;
        short       localShort = 32767;
        int         localInt = 2_147_483_647;
        long        localLong = 9_223_372_036l;
        float       localFloat = 4.2265743f;
        double      localDouble = 5.23427865972;
        boolean     localBoolean = true;
        char        localChar = 49;

//        System.out.print("Enter a byte value (-128 - 127): ");
//        globalByte = scanner.nextByte();
//        System.out.print("Enter a byte value -128 - 127: ");
//        localByte = scanner.nextByte();

//        System.out.print("Enter a short value (-32768 - 32767): ");
//        globalShort = scanner.nextShort();
//        System.out.print("Enter a short value (-32768 - 32767): ");
//        localShort = scanner.nextShort();
//
//        System.out.print("Enter a int value (-2_147_483_648 - 2_147_483_647): ");
//        globalInt = scanner.nextInt();
//        System.out.print("Enter a int value (-2_147_483_648 - 2_147_483_647): ");
//        localInt = scanner.nextInt();
//
//        System.out.print("Enter a long value (-9_223_372_036_854_775_808 - 9_223_372_036_854_775_807): ");
//        globalLong = scanner.nextLong();
//        System.out.print("Enter a long value (-9_223_372_036_854_775_808 - 9_223_372_036_854_775_807): ");
//        localLong = scanner.nextLong();
//
//        System.out.print("Enter a float value (1.4e-45f - 3.4e+38f): ");
//        globalFloat = scanner.nextFloat();
//        System.out.print("Enter a float value (1.4e-45f - 3.4e+38f): ");
//        localFloat = scanner.nextFloat();
//
//        System.out.print("Enter a double value (4.9e-324 - 1.7e+308): ");
//        globalDouble = scanner.nextDouble();
//        System.out.print("Enter a double value (4.9e-324 - 1.7e+308): ");
//        localDouble = scanner.nextDouble();
//
//        System.out.print("Enter a boolean value (true false): ");
//        globalBoolean = scanner.nextBoolean();
//        System.out.print("Enter a boolean value (true false): ");
//        localBoolean = scanner.nextBoolean();
//
//        System.out.print("Enter a char value: ");
//        globalChar = scanner.next().charAt(0);
//        System.out.print("Enter a char value: ");
//        localChar = scanner.next().charAt(0);

        tableTopLine();
        tableHorizontalLine();
        System.out.printf('\u2551'+"%14d"+'\u2551'+"%14d"+'\u2551'+"%14d"+'\u2551'+"%14d"+'\u2551'+
                "%14.4f"+'\u2551'+"%14.4f"+'\u2551'+"%14b"+'\u2551'+"%14s"+'\u2551'+
                "\n", globalByte, globalShort, globalInt, globalLong, globalFloat, globalDouble, globalBoolean, globalChar);
        tableHorizontalLine();
        System.out.printf('\u2551'+"%14d"+'\u2551'+"%14d"+'\u2551'+"%14d"+'\u2551'+"%14d"+'\u2551'+
                "%14.4f"+'\u2551'+"%14.4f"+'\u2551'+"%14b"+'\u2551'+"%14s"+'\u2551'+
                "\n", localByte, localShort, localInt, localLong, localFloat, localDouble, localBoolean, localChar);
        tableBottomLine();

//        System.out.println("I--------------|--------------|--------------|--------------|--------------|--------------|--------------|--------------I");
//        System.out.println("I     Byte     |    Short     |     Int      |     Long     |    Float     |    Double    |   Boolean    |     Char     I");
//        System.out.println("I--------------|--------------|--------------|--------------|--------------|--------------|--------------|--------------I");
//        System.out.printf("I%14d|%14d|%14d|%14d|%14.4f|%14.4f|%14b|%14sI\n", globalByte, globalShort, globalInt, globalLong, globalFloat, globalDouble, globalBoolean, globalChar);
//        System.out.println("I--------------|--------------|--------------|--------------|--------------|--------------|--------------|--------------I");
//        System.out.printf("I%14d|%14d|%14d|%14d|%14.4f|%14.4f|%14b|%14sI\n", localByte, localShort, localInt, localLong, localFloat, localDouble, localBoolean, localChar);
//        System.out.println("I--------------|--------------|--------------|--------------|--------------|--------------|--------------|--------------I");

    }
}

class BankAccount{
    int id;
    String name;
    double balance;

    public static void main(String[] args) {

        Variables myAccount = new Variables();
        Variables yourAccount = new Variables();
        BankAccount hisAccount = new BankAccount();



        myAccount.id = 1;
        myAccount.name = "Rachid Kalinin";
        myAccount.balance = 100.75;

        yourAccount.id = 2;
        yourAccount.name = "Владислав Можейко";
        yourAccount.balance = 8.54;

        hisAccount.id = 3;
        hisAccount.name = "Борис Коновалов";
        hisAccount.balance = 34.77;

        Variables bA = yourAccount;
        bA.name = "Duncan MacLeod ";

        yourAccount.tableTopLine();
        yourAccount.tableHorizontalLine();
        yourAccount.tableBottomLine();

//        System.out.println(myAccount.name);
        System.out.println(yourAccount.name);
//        System.out.println(hisAccount.name);

    }

}
