public class BankCard {
    private final String cardData;
    private final Currencies currency;
    private final Statuses status;

    public BankCard(String cardData, Currencies currency, Statuses status) {
        this.cardData = cardData;
        this.currency = currency;
        this.status = status;
    }
    public String getCardData() {
        return cardData;
    }
    public Currencies getCurrency() {
        return currency;
    }
    public Statuses getStatus() {
        return status;
    }
    @Override
    public String toString() {
        return "BankCard [" +
                "cardData='" + cardData + '\'' +
                ", currency=" + currency +
                ", status=" + status +
                ']';
    }
}
