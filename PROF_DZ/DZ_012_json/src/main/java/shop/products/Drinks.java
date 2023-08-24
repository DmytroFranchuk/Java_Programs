package shop.products;

public class Drinks extends Table {

    public Drinks(String category, String name, String factory, Integer quantity, boolean isPacked, boolean isAdv, double price, double margin, boolean isDebt) {
        super(category, name, factory, quantity, isPacked, isAdv, price, margin, isDebt);
    }
}