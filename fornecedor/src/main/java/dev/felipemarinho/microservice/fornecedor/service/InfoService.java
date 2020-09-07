package dev.felipemarinho.microservice.fornecedor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.felipemarinho.microservice.fornecedor.model.InfoFornecedor;
import dev.felipemarinho.microservice.fornecedor.repository.InfoRepository;

@Service
public class InfoService {
	
	Logger LOG = LoggerFactory.getLogger(InfoService.class);

	@Autowired
	private InfoRepository infoRepository;
	
	public InfoFornecedor getInfoPorEstado(String estado) {
		LOG.info("Buscando informações do fornecedor de {}", estado);
		 return infoRepository.findByEstado(estado);
	}

}
