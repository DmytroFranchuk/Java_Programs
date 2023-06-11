import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    public static void generate(char[] chars, int index, List<String> permutations) {
        if (index == chars.length - 1) {
            permutations.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generate(chars, index + 1, permutations);
            swap(chars, index, i); // Возвращаем символы на место для следующей итерации
        }
    }
    public static List<String> generatePermutations(String input) {
        List<String> permutations = new ArrayList<>();
        generate(input.toCharArray(), 0, permutations);
        return permutations;
    }
}
