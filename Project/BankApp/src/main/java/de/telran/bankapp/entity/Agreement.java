package de.telran.bankapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Agreement {
    private int id;
    private UUID account_id;
    private int product_id;
    private double interest_rate;
    private Status status;
    private BigDecimal sum;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return id == agreement.id && Objects.equals(account_id, agreement.account_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account_id);
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", account_id=" + account_id +
                ", product_id=" + product_id +
                ", interest_rate=" + interest_rate +
                ", status=" + status +
                ", sum=" + sum +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
