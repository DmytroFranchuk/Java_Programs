package org.pr_10_11_2023_Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private int currentId;
    private MerchService merchService;
    private Map<Integer, Product> products = new HashMap<>();

    public void setMerchService(MerchService merchService) {
        this.merchService = merchService;
    }

    public List<Product> getAll() {
        List<Product> result = new ArrayList<>(products.values());

        if (merchService.withoutSupplierInfo()) {
            for (Product product : result) {
                product.setSupplier(null);
            }
        }
        return result;
    }

    public Product getById(int id) {
        Product product = products.get(id);
        if (product != null) {
            double markup = merchService.getMarkup();
            double newPrice = product.getPrice() * (100 + markup) / 100;
            product.setPrice(newPrice);
        }
        return product;
    }

    public Product save(Product product) {
        product.setId(++currentId);
        merchService.setArticle(product);
        products.put(product.getId(), product);
        return product;
    }

    public void delete(int id) {
        if (merchService.fullDeletion()) {
            products.remove(id);
        } else {
            Product product = products.get(id);
            if (product != null) {
                product.setActive(false);
            }
        }
    }

}
