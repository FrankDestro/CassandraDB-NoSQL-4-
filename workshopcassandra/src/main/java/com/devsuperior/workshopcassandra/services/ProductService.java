package com.devsuperior.workshopcassandra.services;

import com.devsuperior.workshopcassandra.model.dto.ProductDTO;
import com.devsuperior.workshopcassandra.model.entities.Product;
import com.devsuperior.workshopcassandra.repositories.ProductRepository;
import com.devsuperior.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO findById(UUID id) {
        Product entity = getById(id);
        return new ProductDTO(entity);
    }

    private Product getById(UUID id) {
        Optional<Product> result = productRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("id not found"));
    }

    public List<ProductDTO> findByDepartment (String department) {
        List<Product> result = productRepository.findByDepartment(department);
        return result.stream().map(x -> (new ProductDTO(x))).toList();
    }
}
