package dev.felipemarinho.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.felipemarinho.microservice.loja.Compra;
import dev.felipemarinho.microservice.loja.controller.dto.CompraDTO;
import dev.felipemarinho.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@GetMapping("/{id}")
	public Compra getById(@PathVariable("id") Long id) {
		return compraService.getById(id);
	}

	@PostMapping
	public Compra realizarCompra(@RequestBody CompraDTO compra) {
		return compraService.realizarCompra(compra);
	}
}
