package com.devsuperior.workshopcassandra.controllers;

import com.devsuperior.workshopcassandra.model.dto.ProductDTO;
import com.devsuperior.workshopcassandra.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
        ProductDTO dto = productService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findByDepartment(
            @RequestParam(name = "department", defaultValue = "") String department) {
        List<ProductDTO> list = productService.findByDepartment(department);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/description")
    public ResponseEntity<List<ProductDTO>> findByDescription(
            @RequestParam(name = "text", defaultValue = "") String text) {
        List<ProductDTO> list = productService.findByDescription(text);
        return ResponseEntity.ok(list);
    }
}
