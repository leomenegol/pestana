package com.algaworks.crm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.algaworks.crm.model.Pessoa;
import com.algaworks.crm.model.Veiculo;
import com.algaworks.crm.repository.PessoaRepository;
import com.algaworks.crm.repository.VeiculoRepository;

public class VagaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<Integer> encontrarVagaPessoa(Long id) {

		List<Veiculo> lista = veiculoRepository.findAll();
		List<Veiculo> lista2 = new ArrayList<Veiculo>();
		List<Integer> lista3 = new ArrayList<Integer>();
		for (Veiculo veiculo : lista) {
			if (veiculo.getDono() == id) {
				lista2.add(veiculo);
			}
		}
		for (Veiculo veiculo : lista) {
			if (veiculo.getDono() == id) {
				lista3.add(veiculo.getVaga());
			}
		}
		return lista3;
	}

	public List<Integer> encontrarVagaApartamento(String apartamento) {

		List<Pessoa> pessoas = pessoaRepository.findAll();
		List<Veiculo> veiculos = veiculoRepository.findAll();
		List<Pessoa> pessoasApartamento = new ArrayList<Pessoa>();
		List<Integer> lista3 = new ArrayList<Integer>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getApartamento() == apartamento) {
				pessoasApartamento.add(pessoa);
			}
		}
		for (Veiculo veiculo : veiculos) {
			for (Pessoa pessoa : pessoasApartamento) {
				if (veiculo.getDono() == pessoa.getId()) {
					lista3.add(veiculo.getVaga());
				}
			}
		}
		return lista3;
	}

	public List<Integer> encontrarVagaTelefone(String telefone) {

		List<Pessoa> pessoas = pessoaRepository.findAll();
		List<Veiculo> veiculos = veiculoRepository.findAll();
		List<Pessoa> pessoasTelefone = new ArrayList<Pessoa>();
		List<Integer> lista3 = new ArrayList<Integer>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getApartamento() == telefone) {
				pessoasTelefone.add(pessoa);
			}
		}
		for (Veiculo veiculo : veiculos) {
			for (Pessoa pessoa : pessoasTelefone) {
				if (veiculo.getDono() == pessoa.getId()) {
					lista3.add(veiculo.getVaga());
				}
			}
		}
		return lista3;
	}

	public int encontrarVagaVeiculo(Veiculo veiculo) {
		return veiculo.getVaga();
	}

}
