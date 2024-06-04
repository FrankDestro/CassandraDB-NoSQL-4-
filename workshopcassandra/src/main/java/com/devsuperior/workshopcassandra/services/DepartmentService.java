package com.devsuperior.workshopcassandra.services;

import com.devsuperior.workshopcassandra.model.dto.DepartmentDTO;
import com.devsuperior.workshopcassandra.model.entities.Department;
import com.devsuperior.workshopcassandra.repositories.DepartmentRepository;
import com.devsuperior.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> findAll() {
        List<Department> list = departmentRepository.findAll();
        return list.stream().map(x -> new DepartmentDTO(x)).toList();
    }

    public DepartmentDTO findById(UUID id) {
        Optional<Department> result = departmentRepository.findById(id);
        Department entity = result.orElseThrow(() -> new ResourceNotFoundException("id not found"));
        return new DepartmentDTO(entity);
    }

    public DepartmentDTO insert(DepartmentDTO dto) {
        Department entity = new Department();
        entity.setId(UUID.randomUUID());
        copyDtoToEntity(dto, entity);
        entity = departmentRepository.save(entity);
        return new DepartmentDTO(entity);
    }

    private void copyDtoToEntity(DepartmentDTO dto, Department entity) {
        entity.setName(dto.getName());
    }
}
