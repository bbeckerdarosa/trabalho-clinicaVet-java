package br.com.clinicaVet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaVet.domain.Proprietario;
import br.com.clinicaVet.dto.ProprietarioDTO;
import br.com.clinicaVet.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

	private ProprietarioRepository proprietarioRepository;

	@Autowired
	public ProprietarioService(ProprietarioRepository proprietarioRepository) {
		this.proprietarioRepository = proprietarioRepository;
	}

	public void deleteAll() {
		this.proprietarioRepository.deleteAll();
	}

	public void save(ProprietarioDTO proprietarioDTO) {
		String nomeProprietario = proprietarioDTO.getNomeProprietario();
		String endereco = proprietarioDTO.getEndereco();
		String numero = proprietarioDTO.getNumero();
		String telefone = proprietarioDTO.getTelefone();
		String cpf = proprietarioDTO.getCpf();

		Proprietario proprietario = new Proprietario(nomeProprietario, endereco, numero, telefone, cpf);
		this.proprietarioRepository.saveAndFlush(proprietario);
	}

	private ProprietarioDTO criarProprietarioDTO(Proprietario proprietario) {
		ProprietarioDTO proprietarioDTO = new ProprietarioDTO();
		proprietarioDTO.setId(proprietario.getId());
		proprietarioDTO.setNomeProprietario(proprietario.getNomeProprietario());
		proprietarioDTO.setEndereco(proprietario.getEndereco());
		proprietarioDTO.setNumero(proprietario.getNumero());
		proprietarioDTO.setTelefone(proprietario.getTelefone());
		proprietarioDTO.setCpf(proprietario.getCpf());
		return proprietarioDTO;
	}

	public ProprietarioDTO findByCpf(String cpf) {
		Optional<Proprietario> proprietario = proprietarioRepository.findByCpf(cpf);
		if (proprietario.isPresent()) {
			ProprietarioDTO proprietarioDTO = criarProprietarioDTO(proprietario.get());
			return proprietarioDTO;
		}
		throw new ServiceException("Proprietario não encontrado");
	}

	public void deleteByCpf(String cpf) {
		Optional<Proprietario> proprietario = proprietarioRepository.findByCpf(cpf);
		if (proprietario.isPresent()) {
			proprietarioRepository.deleteById(proprietario.get().getId());
		}
	}

	public Proprietario update(ProprietarioDTO proprietarioDTO) {
		String nomeProprietario = proprietarioDTO.getNomeProprietario();
		String endereco = proprietarioDTO.getEndereco();
		String numero = proprietarioDTO.getNumero();
		String telefone = proprietarioDTO.getTelefone();
		String cpf = proprietarioDTO.getCpf();

		Proprietario proprietario = new Proprietario(nomeProprietario, endereco, numero, telefone, cpf);
		return this.proprietarioRepository.saveAndFlush(proprietario);
	}

	public List<ProprietarioDTO> findAll() {
		List<ProprietarioDTO> todosProprietarios = new ArrayList<ProprietarioDTO>();
		List<Proprietario> proprietarios = proprietarioRepository.findAll();

		for (Proprietario proprietario : proprietarios) {
			ProprietarioDTO proprietarioDTO = criarProprietarioDTO(proprietario);
			todosProprietarios.add(proprietarioDTO);
		}
		return todosProprietarios;
	}

}
