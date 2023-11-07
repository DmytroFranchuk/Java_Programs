package de.telran.bankapp.service;

import de.telran.bankapp.dto.ProductDto;
import de.telran.bankapp.entity.enums.CurrencyCode;
import de.telran.bankapp.entity.enums.Status;

import java.util.List;

public interface ProductService {

    ProductDto getById(Long id);

    List<ProductDto> getAllProducts();

    List<ProductDto> getProductWithParamsStatusAndCurrencyCode(Status status, CurrencyCode currencyCode);
}
