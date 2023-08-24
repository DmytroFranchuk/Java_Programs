package shop.products;

public class Foods extends Table {

    public Foods(String category, String name, String factory, Integer quantity, boolean isPacked, boolean isAdv, double price, double margin, boolean isDebt) {
        super(category, name, factory, quantity, isPacked, isAdv, price, margin, isDebt);
    }
}
