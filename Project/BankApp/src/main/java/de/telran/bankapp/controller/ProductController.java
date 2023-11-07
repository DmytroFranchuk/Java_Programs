package de.telran.bankapp.controller;

import de.telran.bankapp.dto.ProductDto;
import de.telran.bankapp.entity.enums.CurrencyCode;
import de.telran.bankapp.entity.enums.Status;
import de.telran.bankapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = productService.getAllProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        ProductDto productDto = productService.getById(id);
        if (productDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id: " + id + " not found");
        }
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/choose")
    public ResponseEntity<List<ProductDto>> getByStatusAndCurrencyCode(@RequestParam Status status, @RequestParam CurrencyCode currencyCode) {
        List<ProductDto> result = productService.getProductWithParamsStatusAndCurrencyCode(status, currencyCode);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
