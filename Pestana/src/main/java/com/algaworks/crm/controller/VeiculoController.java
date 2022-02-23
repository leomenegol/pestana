package com.algaworks.crm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.Pessoa;
import com.algaworks.crm.model.Veiculo;
import com.algaworks.crm.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping
	public List<Veiculo> listar() {
		return veiculoRepository.findAll();
	}

	@PostMapping
	public Veiculo adicionar(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@DeleteMapping
	public void apagar(@RequestBody Veiculo veiculo) {
		veiculoRepository.delete(veiculo);
	}

}
