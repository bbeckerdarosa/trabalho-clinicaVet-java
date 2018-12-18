package br.com.clinicaVet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaVet.domain.Proprietario;
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

	public void save(Proprietario proprietario) {
		validarInsertProprietario(proprietario);
		this.proprietarioRepository.saveAndFlush(proprietario);
	}

	private void validarInsertProprietario(Proprietario proprietario) {
		Long numberOfProprietarioWithCPF = proprietarioRepository.validateExistProprietarioByCpf(proprietario.getCpf());
		if (numberOfProprietarioWithCPF > 0) {
			throw new ServiceException("Proprietario já cadastrado");
		}
	}

	public Proprietario findByCpf(String cpf) {
		Optional<Proprietario> proprietarioEncontrado = proprietarioRepository.findByCpf(cpf);
		if (proprietarioEncontrado.isPresent()) {
			return proprietarioEncontrado.get();
		}
		throw new ServiceException("Proprietario não encontrado");
	}

	public void delete(Proprietario proprietario) {
		this.proprietarioRepository.delete(proprietario);
	}

	public Proprietario update(Proprietario proprietario) {
		return this.proprietarioRepository.saveAndFlush(proprietario);
	}

}
