package br.com.clinicaVet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaVet.domain.Veterinario;
import br.com.clinicaVet.dto.VeterinarioDTO;
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

	public void save(VeterinarioDTO veterinarioDTO) {
		String nomeVeterinario = veterinarioDTO.getNomeVeterinario();
		String cpf = veterinarioDTO.getCpf();

		Veterinario veterinario = new Veterinario(nomeVeterinario, cpf);
		this.veterinarioRepository.saveAndFlush(veterinario);
	}

	private VeterinarioDTO criarVeterinarioDTO(Veterinario veterinario) {
		VeterinarioDTO veterinarioDTO = new VeterinarioDTO();
		veterinarioDTO.setId(veterinario.getId());
		veterinarioDTO.setNomeVeterinario(veterinario.getNomeVeterinario());
		veterinarioDTO.setCpf(veterinario.getCpf());
		return veterinarioDTO;
	}

	public VeterinarioDTO findByCpf(String cpf) {
		Optional<Veterinario> veterinario = veterinarioRepository.findByCpf(cpf);
		if (veterinario.isPresent()) {
			VeterinarioDTO veterinarioDTO = criarVeterinarioDTO(veterinario.get());
			return veterinarioDTO;
		}
		throw new ServiceException("Veterinario não encontrado");
	}

	public void delete(Integer id) {
		this.veterinarioRepository.deleteById(id);
	}

	public List<VeterinarioDTO> findAll() {
		List<VeterinarioDTO> todosVeterinarios = new ArrayList<VeterinarioDTO>();
		List<Veterinario> veterinarios = veterinarioRepository.findAll();

		for (Veterinario veterinario : veterinarios) {
			VeterinarioDTO veterinarioDTO = criarVeterinarioDTO(veterinario);
			todosVeterinarios.add(veterinarioDTO);
		}
		return todosVeterinarios;
	}

	public void deleteByCpf(String cpf) {
		Optional<Veterinario> veterinario = veterinarioRepository.findByCpf(cpf);
		if (veterinario.isPresent()) {
			veterinarioRepository.deleteById(veterinario.get().getId());
		}
	}

}
