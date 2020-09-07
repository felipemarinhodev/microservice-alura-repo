package dev.felipemarinho.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.felipemarinho.microservice.loja.Compra;
import dev.felipemarinho.microservice.loja.client.FornecedorClient;
import dev.felipemarinho.microservice.loja.controller.dto.CompraDTO;
import dev.felipemarinho.microservice.loja.dto.InfoFornecedorDTO;
import dev.felipemarinho.microservice.loja.dto.InfoPedidoDTO;

@Service
public class CompraService {
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public Compra realizarCompra(CompraDTO compra) {
		
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		InfoPedidoDTO pedido = fornecedorClient.realizarPedido(compra.getItens());
		
		System.out.println(info.getEndereco());
		
		Compra compraSalva = new Compra();
		
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		return compraSalva;
	}

}
