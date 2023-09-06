package de.telran.bankapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Account {
    private UUID id;
    private UUID client_id;
    private String name;
    private int type;
    private Status status;
    private BigDecimal balance;
    private int currency_code;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(client_id, account.client_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client_id);
    }

    @Override
    public String toString() {
        return "\nAccount{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", balance=" + balance +
                ", currency_code=" + currency_code +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
