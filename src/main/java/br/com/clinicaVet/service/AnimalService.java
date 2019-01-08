package br.com.clinicaVet.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinicaVet.domain.Animal;
import br.com.clinicaVet.domain.Animal.TipoAnimal;
import br.com.clinicaVet.domain.HistoricoConsulta;
import br.com.clinicaVet.domain.Proprietario;
import br.com.clinicaVet.domain.Veterinario;
import br.com.clinicaVet.dto.AnimalDTO;
import br.com.clinicaVet.dto.HistoricoConsultaDTO;
import br.com.clinicaVet.repository.AnimalRepository;
import br.com.clinicaVet.repository.ProprietarioRepository;
import br.com.clinicaVet.repository.VeterinarioRepository;

@Service
@Transactional
public class AnimalService {

	private AnimalRepository animalRepository;

	private VeterinarioRepository veterinarioRepository;

	private ProprietarioRepository proprietarioRepository;

	@Autowired
	public AnimalService(AnimalRepository animalRepository, VeterinarioRepository veterinarioRepository,ProprietarioRepository proprietarioRepository) {
		this.animalRepository = animalRepository;
		this.veterinarioRepository = veterinarioRepository;
		this.proprietarioRepository = proprietarioRepository;
	}

	public void deleteAll() {
		this.animalRepository.deleteAll();
	}

	public void save(AnimalDTO animalDTO) {
		Optional<Proprietario> proprietarioEncontrado = proprietarioRepository.findByCpf(animalDTO.getCpfProprietario());
		String nomeAnimal = animalDTO.getNomeAnimal();
		String raca = animalDTO.getRaca();
		Proprietario proprietario = proprietarioEncontrado.get();
		String nroChip = animalDTO.getNroChip();
		LocalDate dataNascimento = animalDTO.getDataNascimento();
		TipoAnimal tipoAnimal = animalDTO.getTipoAnimal();

		Animal animal = new Animal(nomeAnimal, raca, proprietario, nroChip, dataNascimento, tipoAnimal);
		this.animalRepository.saveAndFlush(animal);
	}

	private AnimalDTO criarAnimalDTO(Animal animal) {
		AnimalDTO animalDTO = new AnimalDTO();
		animalDTO.setId(animal.getId());
		animalDTO.setNomeAnimal(animal.getNomeAnimal());
		animalDTO.setRaca(animal.getRaca());
		animalDTO.setProprietario(animal.getProprietario().getNomeProprietario());
		animalDTO.setCpfProprietario(animal.getProprietario().getCpf());
		animalDTO.setNroChip(animal.getNroChip());
		animalDTO.setDataNascimento(animal.getDataNascimento());
		animalDTO.setHistoricoConsulta(criarHistoricoConsulta(animal.getHistoricoConsulta()));
		animalDTO.setTipoAnimal(animal.getTipoAnimal());
		return animalDTO;
	}

	private List<HistoricoConsultaDTO> criarHistoricoConsulta(List<HistoricoConsulta> historicoConsultas) {
		List<HistoricoConsultaDTO> retorno = new ArrayList<>();

		for (HistoricoConsulta historicoConsulta : historicoConsultas) {
			HistoricoConsultaDTO historicoDTO = new HistoricoConsultaDTO();
			historicoDTO.setId(historicoConsulta.getId());
			historicoDTO.setDataAtendimento(historicoConsulta.getDataAtendimento());
			historicoDTO.setDiagnostico(historicoConsulta.getDiagnostico());
			historicoDTO.setCpfVeterinario(historicoConsulta.getVeterinario().getNomeVeterinario());
			retorno.add(historicoDTO);
		}

		return retorno;
	}

	public AnimalDTO findByNroChip(String nroChip) {
		Optional<Animal> animal = animalRepository.findByNroChip(nroChip);
		if (animal.isPresent()) {
			AnimalDTO animalDTO = criarAnimalDTO(animal.get());
			return animalDTO;
		}
		throw new ServiceException("Animal não encontrado");
	}

	public void delete(Integer id) {
		this.animalRepository.deleteById(id);
	}

	public Animal update(AnimalDTO animalDTO) {
		Optional<Proprietario> proprietarioEncontrado = proprietarioRepository.findByCpf(animalDTO.getCpfProprietario());

		Integer id = animalDTO.getId();
		String nomeAnimal = animalDTO.getNomeAnimal();
		String raca = animalDTO.getRaca();
		Proprietario proprietario = proprietarioEncontrado.get();
		String nroChip = animalDTO.getNroChip();
		LocalDate dataNascimento = animalDTO.getDataNascimento();
		TipoAnimal tipoAnimal = animalDTO.getTipoAnimal();

		Animal animal = new Animal(id, nomeAnimal, raca, proprietario, nroChip, dataNascimento, tipoAnimal);
		return this.animalRepository.saveAndFlush(animal);
	}

	public void deleteByNroChip(String nroChip) {
		Optional<Animal> animal = animalRepository.findByNroChip(nroChip);
		if (animal.isPresent()) {
			animalRepository.deleteById(animal.get().getId());
		}
	}

	public List<AnimalDTO> findAll() {
		List<AnimalDTO> todosAnimais = new ArrayList<AnimalDTO>();
		List<Animal> animais = animalRepository.findAll();

		for (Animal animal : animais) {
			AnimalDTO animalDTO = criarAnimalDTO(animal);
			todosAnimais.add(animalDTO);
		}
		return todosAnimais;
	}

	public void salvarConsulta(String nroChip, HistoricoConsultaDTO historicoConsultaDTO) {
		// Buscar o veterinário
		Optional<Veterinario> veterinarioEncontrado = this.veterinarioRepository.findByCpf(historicoConsultaDTO.getCpfVeterinario());

		// buscar animal
		Optional<Animal> animalEncontrado = this.animalRepository.findByNroChip(nroChip);

		if (animalEncontrado.isPresent()) {
			Animal animal = animalEncontrado.get();
			String diagnostico = historicoConsultaDTO.getDiagnostico();
			Veterinario veterinario = veterinarioEncontrado.get();
			HistoricoConsulta historicoConsulta = new HistoricoConsulta(diagnostico, veterinario);
			animal.adicionarConsulta(historicoConsulta);
			this.animalRepository.saveAndFlush(animal);
		}
	}

}
