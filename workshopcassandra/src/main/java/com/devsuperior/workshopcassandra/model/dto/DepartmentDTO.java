package com.devsuperior.workshopcassandra.model.dto;

import com.devsuperior.workshopcassandra.model.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private UUID id;
    private String name;

    public DepartmentDTO(Department entityDepartment) {
        this.id = entityDepartment.getId();
        this.name = entityDepartment.getName();
    }
}
