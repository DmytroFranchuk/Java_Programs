package shop.products;

public class Snacks extends Table {
    public Snacks(String category, String name, String factory, Integer quantity, boolean isPacked, boolean isAdv, double price, double margin, boolean isDebt) {
        super(category, name, factory, quantity, isPacked, isAdv, price, margin, isDebt);
    }
}
