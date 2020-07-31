package com.edi.cursoapirest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class MeuResource {
	
	//Crie os m�todos que receber�o as requisi��es
	
	@GetMapping("/{id}")
	public Cliente obterDadosDoCliente(@PathVariable Long id) {
		System.out.println(String.format("Id recebido da URL %d", id));
		Cliente cliente = new Cliente("Edi", "000.000.000-00");
		return cliente;
	}
	
	
	//Para pegar a resposta, basta colocar ResponseEntity em vez do tipo cliente
	//isto � para respresentar a resposta e no retorno, passa-se os par�metros:
	//o body (no caso o objeto cliente) e o c�digo de status
	//com o responseentity, n�o se faz necesspario a anotation @ResponseStatus
	//o ResponseEntity possui features a mais al�m de retornar s� o objeto
	//pode retornar headers http tamb�m
	
	
//	@PostMapping("/api/clientes/")
//	public ResponseEntity salvar(@RequestBody, Cliente cliente) {
//		return new ResponseEntity(cliente, HttpStatus.CREATED);	
//	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		//service.save(cliente);
		return cliente;		
	}
	
	//para deletar, eu teria primeiro que buscar o cliente pelo id
	//para somente depois deletar o cliente
	//se n�o o encontrar, NOT FOUND
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		//service.buscarPorId(id)
		//service.delete(cliente);
	}
	
	//no put eu recebo os dados do cliente atualizados
	//a� eu recebo um objeto Json
	
	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		//service.buscarPorId(id);
		//service.update(cliente);
		return cliente;
	}
	

	
}