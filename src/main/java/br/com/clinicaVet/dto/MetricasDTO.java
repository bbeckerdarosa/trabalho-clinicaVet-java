package br.com.clinicaVet.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.clinicaVet.domain.Animal.TipoAnimal;

public class MetricasDTO {

	private Integer getAnimalCounter;
    private Integer delAnimalCounter;

	public Integer getAnimalCounter() {
		return animalCounter;
	}

	public void setAnimalCounter(Integer animalCounter) {
		this.animalCounter = animalCounter;
	}
}
