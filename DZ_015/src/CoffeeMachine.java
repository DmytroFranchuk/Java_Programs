import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите напиток: 1 - эспрессо, 2 - американо, 3 - капучино, 4 - чай");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                prepareEspresso();
                break;
            case 2:
                prepareAmericano();
                break;
            case 3:
                prepareCappuccino();
                break;
            case 4:
                prepareTea();
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private static void prepareEspresso() {
        System.out.println("Приготовление эспрессо...");
        System.out.println("Эспрессо готов!");
    }

    private static void prepareAmericano() {
        System.out.println("Приготовление американо...");
        prepareEspresso();
        System.out.println("Добавление воды...");
        System.out.println("Американо готов!");
    }

    private static void prepareCappuccino() {
        System.out.println("Приготовление капучино...");
        prepareEspresso();
        System.out.println("Добавление вспененного молока...");
        System.out.println("Капучино готов!");
    }

    private static void prepareTea() {
        System.out.println("Приготовление чая...");
        System.out.println("Чай готов!");
    }
}
