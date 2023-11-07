package de.telran.bankapp.dto;

import de.telran.bankapp.entity.enums.CurrencyCode;
import de.telran.bankapp.entity.enums.ProductType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientProductDto {

    private Long clientId;
    private Long productId;
    private ProductType type;
    private CurrencyCode currencyCode;
    private BigDecimal interestRate;
    private BigDecimal limit;

    public ClientProductDto(Long clientId, Long productId, ProductType type, CurrencyCode currencyCode, BigDecimal interestRate, BigDecimal limit) {
        this.clientId = clientId;
        this.productId = productId;
        this.type = type;
        this.currencyCode = currencyCode;
        this.interestRate = interestRate;
        this.limit = limit;
    }
}
