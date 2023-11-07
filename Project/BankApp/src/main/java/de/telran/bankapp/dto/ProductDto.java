package de.telran.bankapp.dto;

import de.telran.bankapp.entity.enums.CurrencyCode;
import de.telran.bankapp.entity.enums.ProductType;
import de.telran.bankapp.entity.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductDto {

    private Long id;
    private String managerId;
    private ProductType type;
    private Status status;
    private CurrencyCode currencyCode;
    private BigDecimal interestRate;
    private BigDecimal limit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    public ProductDto(Long id, String managerId, ProductType type, Status status, CurrencyCode currencyCode, BigDecimal interestRate, BigDecimal limit) {
//        this.id = id;
//        this.managerId = managerId;
//        this.type = type;
//        this.status = status;
//        this.currencyCode = currencyCode;
//        this.interestRate = interestRate;
//        this.limit = limit;
//    }

    //    private List<Agreement> agreements;
}
