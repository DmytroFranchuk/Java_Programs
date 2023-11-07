package de.telran.bankapp.service.impl;

import de.telran.bankapp.dto.ProductDto;
import de.telran.bankapp.entity.bank.Product;
import de.telran.bankapp.entity.enums.CurrencyCode;
import de.telran.bankapp.entity.enums.Status;
import de.telran.bankapp.mapper.ProductMapper;
import de.telran.bankapp.repository.bank.ProductRepository;
import de.telran.bankapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getProductWithParamsStatusAndCurrencyCode(Status status, CurrencyCode currencyCode) {
        List<Product> products = productRepository.findProductWithParamsStatusAndCurrencyCode(status, currencyCode);
        return products.stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product != null ? productMapper.productToProductDto(product) : null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }
}
