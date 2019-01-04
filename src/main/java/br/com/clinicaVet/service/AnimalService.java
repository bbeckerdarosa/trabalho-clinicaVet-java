package br.com.clinicaVet.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaVet.domain.Animal;
import br.com.clinicaVet.domain.Animal.TipoAnimal;
import br.com.clinicaVet.domain.HistoricoConsulta;
import br.com.clinicaVet.domain.Proprietario;
import br.com.clinicaVet.dto.AnimalDTO;
import br.com.clinicaVet.repository.AnimalRepository;

@Service
public class AnimalService {

	private AnimalRepository animalRepository;

	@Autowired
	public AnimalService(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}

	public void deleteAll() {
		this.animalRepository.deleteAll();
	}

	public void save(AnimalDTO animalDTO) {
		String nomeAnimal = animalDTO.getNomeAnimal();
		String raca = animalDTO.getRaca();
		Proprietario proprietario = animalDTO.getProprietario();
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
		animalDTO.setProprietario(animal.getProprietario());
		animalDTO.setNroChip(animal.getNroChip());
		animalDTO.setDataNascimento(animal.getDataNascimento());
		animalDTO.setHistoricoConsulta(animal.getHistoricoConsulta());
		animalDTO.setTipoAnimal(animal.getTipoAnimal());
		return animalDTO;
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
		String nomeAnimal = animalDTO.getNomeAnimal();
		String raca = animalDTO.getRaca();
		Proprietario proprietario = animalDTO.getProprietario();
		String nroChip = animalDTO.getNroChip();
		LocalDate dataNascimento = animalDTO.getDataNascimento();
		List<HistoricoConsulta> historicoConsulta = animalDTO.getHistoricoConsulta();
		TipoAnimal tipoAnimal = animalDTO.getTipoAnimal();

		Animal animal = new Animal(nomeAnimal, raca, proprietario, nroChip, dataNascimento, tipoAnimal);
		return this.animalRepository.saveAndFlush(animal);
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

}
