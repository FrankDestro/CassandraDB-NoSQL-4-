package com.devsuperior.workshopcassandra.model.dto;

import com.devsuperior.workshopcassandra.model.embedded.Prop;
import com.devsuperior.workshopcassandra.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private UUID id;
    private String department;
    private Double price;
    private Instant moment;
    private String name;
    private String description;

    private List<Prop> props = new ArrayList<>();

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.department = entity.getDepartment();
        this.price = entity.getPrice();
        this.moment = entity.getMoment();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.props.addAll(entity.getProps());
    }
}
