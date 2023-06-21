package TaskBank;

// - класс Генератор
//      * генерация Клиента
//      * генерация банковских карт

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    static Random rd = new Random();

    private static List<Bankcards> cardsGeneration(int numCards) {
        List<Bankcards> bankcards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            double accountBalanceCard = Math.round(rd.nextDouble() * 1000000.0) / 100.0;
            bankcards.add(i, new Bankcards(dateValidityCard(), statusCard(), paymentSystem(), accountBalanceCard, currency()));
        }
        return bankcards;
    }

    private static String dateValidityCard() {
        int year = rd.nextInt(6)+23;    // Случайный год
        int month = rd.nextInt(12) + 1; // Случайный месяц от 1 до 12
        int day = rd.nextInt(28) + 1;   // Случайный день от 1 до 28
        // Форматирование даты в строку
        String date = String.format("%02d/%02d/%02d", day, month, year);
        return date;
    }

    private static StatusCard statusCard() {
        StatusCard[] status = StatusCard.values();
        StatusCard statusCard = status[rd.nextInt(status.length)];
        return statusCard;
    }

    private static PaymentSystem paymentSystem() {
        PaymentSystem[] payment = PaymentSystem.values();
        PaymentSystem paymentSystem = payment[rd.nextInt(payment.length)];
        return paymentSystem;
    }

    private static Currency currency() {
        Currency[] curr = Currency.values();
        Currency currency = curr[rd.nextInt(curr.length)];
        return currency;
    }

    public static Client clientGeneration() {
        int numCards = rd.nextInt(4) + 1;
        int age = rd.nextInt(85) + 16;
        return new Client(nameGenerate(), age, passportID(), Generator.cardsGeneration(numCards));
    }

    private static String nameGenerate() {
        Names[] names = Names.values();
        Names randomNames = names[rd.nextInt(names.length)];
        String name = randomNames.name();
        return name;
    }

    private static String passportID() {
//        Random random = new Random();
        StringBuilder passportID = new StringBuilder();
        // Генерируем первые две буквы с большой
        char firstChar = (char) (rd.nextInt(5) + 'A');
        char secondChar = (char) (rd.nextInt(4) + 'A');
        passportID.append(firstChar);
        passportID.append(secondChar);
        // Генерируем шесть цифр от 0 до 9
        for (int i = 0; i < 6; i++) {
            int digit = rd.nextInt(10);
            passportID.append(digit);
        }
        return passportID.toString();
    }






}
