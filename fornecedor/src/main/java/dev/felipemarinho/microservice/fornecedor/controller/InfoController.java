package dev.felipemarinho.microservice.fornecedor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.felipemarinho.microservice.fornecedor.model.InfoFornecedor;
import dev.felipemarinho.microservice.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	Logger LOG = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired
	private InfoService infoService;

	
	@GetMapping("/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
		LOG.info("Recebido pedido de informações do fornecedor de {}", estado);
		return infoService.getInfoPorEstado(estado);
	}
}
