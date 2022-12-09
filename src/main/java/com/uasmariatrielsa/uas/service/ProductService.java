
package com.uasmariatrielsa.uas.service;



import com.uasmariatrielsa.uas.model.Product;
import com.uasmariatrielsa.uas.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public Product create(Product product) {
        if (product.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Product already exists");
        }
        if (productRepository.findByName(product.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Product name already exists");
        }
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        getById(id);
        product.setId(id);
        return productRepository.save(product);
    }

    public Product delete(Long id) {
        Product product = getById(id);
        productRepository.delete(product);
        return product;
    }
}
