package de.telran.bankapp.mapper;

import de.telran.bankapp.dto.ProductDto;
import de.telran.bankapp.entity.bank.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product.manager.id", target = "managerId")
    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto productDto);

    List<ProductDto> productsToProductDtos(List<Product> products);



    Product dtoToProduct(ProductDto productDto);

}
