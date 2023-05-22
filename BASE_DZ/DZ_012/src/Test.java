public class Test {
    public static void main(String[] args) {
        char c1 = '0';
        char c2 = '0';
        char c3 = '0';
//        System.out.println((int) c1);
//        System.out.println(c2 - '0');
//        System.out.println((char) 48);


        int i1 = (int) c1;
        System.out.println("i1= "+i1);
//
        int i2 = Character.getNumericValue(c2);
        System.out.println("i2= "+i2);
//
        int i3 = Integer.parseInt(String.valueOf(c3));
        System.out.println("i3= "+i3);

//        int i4 = c1;
//        System.out.println(i4);
    }
}
