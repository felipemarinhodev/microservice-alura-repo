package dev.felipemarinho.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import dev.felipemarinho.microservice.loja.Compra;
import dev.felipemarinho.microservice.loja.client.FornecedorClient;
import dev.felipemarinho.microservice.loja.controller.dto.CompraDTO;
import dev.felipemarinho.microservice.loja.dto.InfoFornecedorDTO;
import dev.felipemarinho.microservice.loja.dto.InfoPedidoDTO;

@Service
public class CompraService {
	
	Logger LOG = LoggerFactory.getLogger(Compra.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	@HystrixCommand(fallbackMethod = "realizarCompraFallback")
	public Compra realizarCompra(CompraDTO compra) {
		final String estado = compra.getEndereco().getEstado();
		LOG.info("Buscando informações do fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);
		
		LOG.info("Realizando um pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizarPedido(compra.getItens());
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(info.getEndereco());
		LOG.info("Pedido {} realizado com sucesso!", compraSalva.getPedidoId());
				
		return compraSalva;
	}

	public Compra realizarCompraFallback(CompraDTO compra) {
		Compra compraFallback = new Compra();
		compraFallback.setEnderecoDestino(compra.getEndereco().toString());
		return compraFallback;
	}
}
