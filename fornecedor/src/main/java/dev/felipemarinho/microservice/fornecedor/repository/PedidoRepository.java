package dev.felipemarinho.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import dev.felipemarinho.microservice.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{}
