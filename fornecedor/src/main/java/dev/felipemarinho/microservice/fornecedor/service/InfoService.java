package dev.felipemarinho.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.felipemarinho.microservice.fornecedor.model.InfoFornecedor;
import dev.felipemarinho.microservice.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;
	
	public InfoFornecedor getInfoPorEstado(String estado) {
		 return infoRepository.findByEstado(estado);
	}

}
