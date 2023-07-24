public class Client {
    private final String name;
    private final BankCard bankCard;
    private final Double balance;

    public Client(String name, BankCard bankCard, Double balance) {
        this.name = name;
        this.bankCard = bankCard;
        this.balance = balance;
    }
    public String getName() { return name; }
    public BankCard getBankCard() {
        return bankCard;
    }
    public Double getBalance() { return balance; }
    @Override
    public String toString() {
        return "Client [" +
                "name='" + name + '\'' +
                ", bankCard=" + bankCard +
                ", balance=" + balance +
                ']';
    }
}
