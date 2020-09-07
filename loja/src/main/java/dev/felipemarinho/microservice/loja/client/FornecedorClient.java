package dev.felipemarinho.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.felipemarinho.microservice.loja.controller.dto.ItemDaCompraDTO;
import dev.felipemarinho.microservice.loja.dto.InfoFornecedorDTO;
import dev.felipemarinho.microservice.loja.dto.InfoPedidoDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@RequestMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

	@RequestMapping(method = RequestMethod.POST, value = "/pedido")
	InfoPedidoDTO realizarPedido(List<ItemDaCompraDTO> itens);

}
