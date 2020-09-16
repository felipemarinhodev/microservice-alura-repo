package dev.felipemarinho.microservice.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.felipemarinho.microservice.loja.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long>{

}
