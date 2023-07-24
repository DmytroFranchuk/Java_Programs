import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CardDataGenerator {
    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMyy");

    public BankCard generateBankCard() {
        return new BankCard(cardData(), currency(), status());
    }
    private String cardData() {
        Random random = new SecureRandom();
        String cardNumber = generateCardNumber(random);
        String date = generateDate(random);
        String cvv = generateCVV(random);
        return cardNumber+date+cvv;
    }
    private String generateCardNumber(Random random) {
        long randomNumber = random.nextLong() & 0x0000_7FFF_FFFF_FFFFL;
        return String.format("%016d", randomNumber);
    }
    private String generateDate(Random random) {
        LocalDate currentDate = LocalDate.now();
        LocalDate randomDate = currentDate.plusYears(random.nextInt(11) - 5)
                .plusMonths(random.nextInt(12))
                .withDayOfMonth(1);
        return randomDate.format(DATE_FORMATTER);
    }
    private String generateCVV(Random random) {
        String CVV_FORMAT = "000";
        DecimalFormat cvvFormatter = new DecimalFormat(CVV_FORMAT);
        int cvvNumber = random.nextInt(1000);
        return  cvvFormatter.format(cvvNumber);
    }
    private Currencies currency() {
        Currencies[] allCurrencies = Currencies.values();
        int randomIndex = new Random().nextInt(allCurrencies.length);
        return allCurrencies[randomIndex];
    }
    private Statuses status() {
        Statuses[] allStatuses = Statuses.values();
        int randomIndex = new Random().nextInt(allStatuses.length);
        return allStatuses[randomIndex];
    }
}
