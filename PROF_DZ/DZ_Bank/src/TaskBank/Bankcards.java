package TaskBank;

// - класс Банковская карта
//      - срок действия dateValidityCard
//      - статус statusCard
//      - платежная система paymentSystemCard
//      - остаток на счету accountBalanceCard
//      - валюта currencyCard

public class Bankcards {
    String dateValidityCard;
    StatusCard statusCard;
    PaymentSystem paymentSystemCard;
    double accountBalanceCard;
    Currency currencyCard;

    public Bankcards(String dateValidityCard, StatusCard statusCard, PaymentSystem paymentSystemCard, double accountBalanceCard, Currency currencyCard) {
        this.dateValidityCard = dateValidityCard;
        this.statusCard = statusCard;
        this.paymentSystemCard = paymentSystemCard;
        this.accountBalanceCard = accountBalanceCard;
        this.currencyCard = currencyCard;
    }

    @Override
    public String toString() {
        return "Bankcards{" +
                "dateValidityCard='" + dateValidityCard + '\'' +
                ", statusCard=" + statusCard +
                ", paymentSystemCard=" + paymentSystemCard +
                ", accountBalanceCard=" + accountBalanceCard +
                ", currencyCard=" + currencyCard +
                '}';
    }
}
