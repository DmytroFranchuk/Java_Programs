package alphabet;

public class Realization {
    public static void main(String[] args) {
        System.out.println(serialNumberLetter(Alphabet.K));
        System.out.println(serialNumberLetter(Alphabet.O));
        System.out.println(serialNumberLetter(Alphabet.Z));
    }

    // Возвращает порядковый номер буквы в алфавите
    public static int serialNumberLetter(Alphabet letter) {
        return letter.ordinal() + 1;
    }
}
