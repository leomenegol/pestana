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
import com.algaworks.crm.repository.PessoaRepository;
import com.algaworks.crm.repository.VeiculoRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	
	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}	
	
	@PostMapping
	public Pessoa adicionar(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@DeleteMapping
	public void apagar(@RequestBody Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}
	
	public List<Veiculo> listarVeiculos(Pessoa pessoa){
		return findAllByDono(pessoa.getId()); 
	}
	
	public List<Veiculo> findAllByDono(Long id){
		List<Veiculo> lista = veiculoRepository.findAll();
		List<Veiculo> lista2 = new ArrayList<Veiculo>();
		for(Veiculo veiculo : lista){
		    if (veiculo.getDono() == id) {
		    	lista2.add(veiculo);
		    }
		}
		
		return lista2;
	}
}
