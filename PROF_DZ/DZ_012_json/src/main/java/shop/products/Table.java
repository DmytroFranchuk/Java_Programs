package shop.products;

import java.util.Objects;

public class Table {
    private final String category;
    private final String name;
    protected final String factory;
    private final Integer quantity;
    private final boolean isPacked;
    private final boolean isAdv;
    private final double price;
    private final double margin;
    private final boolean isDebt;

    public Table(String category, String name, String factory, Integer quantity, boolean isPacked, boolean isAdv, double price, double margin, boolean isDebt) {
        this.category = category;
        this.name = name;
        this.factory = factory;
        this.quantity = quantity;
        this.isPacked = isPacked;
        this.isAdv = isAdv;
        this.price = price;
        this.margin = margin;
        this.isDebt = isDebt;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getFactory() {
        return factory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public boolean isPacked() {
        return isPacked;
    }

    public boolean isAdv() {
        return isAdv;
    }

    public double getPrice() {
        return price;
    }

    public double getMargin() {
        return margin;
    }

    public boolean isDebt() {
        return isDebt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return isPacked == table.isPacked && isAdv == table.isAdv && Double.compare(price, table.price) == 0 && Double.compare(margin, table.margin) == 0 && isDebt == table.isDebt && Objects.equals(category, table.category) && Objects.equals(name, table.name) && Objects.equals(factory, table.factory) && Objects.equals(quantity, table.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name, factory, quantity, isPacked, isAdv, price, margin, isDebt);
    }

    @Override
    public String toString() {
        return "reportTable{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", factory='" + factory + '\'' +
                ", quantity=" + quantity +
                ", isPacked=" + isPacked +
                ", isAdv=" + isAdv +
                ", price=" + price +
                ", margin=" + margin +
                ", isDebt=" + isDebt +
                '}';
    }
}