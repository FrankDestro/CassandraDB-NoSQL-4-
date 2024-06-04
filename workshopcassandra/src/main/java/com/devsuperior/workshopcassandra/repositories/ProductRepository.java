package com.devsuperior.workshopcassandra.repositories;

import com.devsuperior.workshopcassandra.model.entities.Department;
import com.devsuperior.workshopcassandra.model.entities.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CassandraRepository <Product, UUID> {
}
