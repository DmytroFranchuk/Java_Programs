package de.telran.bankapp.entity;

import de.telran.bankapp.entity.enums.CurrencyCode;
import de.telran.bankapp.entity.enums.ProductType;
import de.telran.bankapp.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_product")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_code")
    private CurrencyCode currencyCode;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "`limit`")
    private BigDecimal limit;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Agreement> agreements = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(manager, product.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manager);
    }
}
