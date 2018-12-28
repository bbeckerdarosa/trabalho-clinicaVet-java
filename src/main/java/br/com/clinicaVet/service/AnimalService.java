package br.com.clinicaVet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaVet.domain.Animal;
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

	public void save(Animal animal) {
		validarInsertAnimal(animal);
		this.animalRepository.saveAndFlush(animal);
	}

	private void validarInsertAnimal(Animal animal) {
		Long numberOfAnimalWithNrmChip = animalRepository.validateExistAnimalByNrmChip(animal.getNroChip());
		if (numberOfAnimalWithNrmChip > 0) {
			throw new ServiceException("Animal já cadastrado");
		}
	}

	public Animal findByNrmChip(String nrmChip) {
		Optional<Animal> animalEncontrado = animalRepository.findByNrmChip(nrmChip);
		if (animalEncontrado.isPresent()) {
			return animalEncontrado.get();
		}
		throw new ServiceException("Animal não encontrado");
	}

}
