package de.telran.bankapp.repository.bank;

import de.telran.bankapp.entity.bank.Product;
import de.telran.bankapp.entity.enums.CurrencyCode;
import de.telran.bankapp.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p from Product p WHERE p.status = :status AND p.currencyCode = :currencyCode")
    List<Product> findProductWithParamsStatusAndCurrencyCode(
            @Param("status") Status status,
            @Param("currencyCode") CurrencyCode currencyCode
    );
}