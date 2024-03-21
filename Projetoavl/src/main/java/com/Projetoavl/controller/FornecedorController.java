package com.Projetoavl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projetoavl.entities.Fornecedor;
import com.Projetoavl.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

private final FornecedorService fornecedorService;
	
	@Autowired
	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id) {
		Fornecedor fornecedor = fornecedorService.getFornecedorById(id);
		if (fornecedor != null) {
			return ResponseEntity.ok(fornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Fornecedor>> getAllFornecedor() {
		List<Fornecedor> fornecedor = fornecedorService.getAllFornecedor();
		return ResponseEntity.ok(fornecedor);
	}

	@PostMapping("/")
	public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
		Fornecedor criarFornecedor = fornecedorService.salvarFornecedor(fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarFornecedor);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
		Fornecedor updatedFornecedor = fornecedorService.updateFornecedor(id, fornecedor);
		if (updatedFornecedor != null) {
			return ResponseEntity.ok(updatedFornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFornecedor(@PathVariable Long id) {
		boolean deleted = fornecedorService.deleteFornecedor(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Fornecedor foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
