package br.com.clinicaVet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaVet.domain.Veterinario;
import br.com.clinicaVet.repository.VeterinarioRepository;

@Service
public class VeterinarioService {

	private VeterinarioRepository veterinarioRepository;

	@Autowired
	public VeterinarioService(VeterinarioRepository veterinarioRepository) {
		this.veterinarioRepository = veterinarioRepository;
	}

	public void deleteAll() {
		this.veterinarioRepository.deleteAll();
	}

	public void save(Veterinario veterinario) {
		validarInsertVeterinario(veterinario);
		this.veterinarioRepository.saveAndFlush(veterinario);
	}

	private void validarInsertVeterinario(Veterinario veterinario) {
		Long numberOfVeterinarioWithCPF = veterinarioRepository.validateExistVeterinarioByCpf(veterinario.getCpf());
		if (numberOfVeterinarioWithCPF > 0) {
			throw new ServiceException("Veterinario já cadastrado");
		}
	}

	public Veterinario findByCpf(String cpf) {
		Optional<Veterinario> veterinarioEncontrado = veterinarioRepository.findByCpf(cpf);
		if (veterinarioEncontrado.isPresent()) {
			return veterinarioEncontrado.get();
		}
		throw new ServiceException("Veterinario não encontrado");
	}

	public void delete(Veterinario veterinario) {
		this.veterinarioRepository.delete(veterinario);
	}

}
