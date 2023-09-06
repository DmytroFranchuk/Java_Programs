package de.telran.bankapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@AllArgsConstructor
@Getter
public class Transaction {
    private UUID id;
    private UUID debit_account_id;
    private UUID credit_account_id;
    private int type;
    private BigDecimal amount;
    private String description;
    private LocalDateTime created_at;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return type == that.type && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", debit_account_id=" + debit_account_id +
                ", credit_account_id=" + credit_account_id +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
