package br.com.clinicaVet.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.clinicaVet.domain.Animal.TipoAnimal;

public class MetricaDTO {

	private Integer counter;
    private String name;

    public MetricaDTO(String name, Integer counter) {
        this.name = name;
        this.counter = counter;
    }

	public String getName() {
		return this.name;
	}

	public Integer getCounter() {
		return this.counter;
	}
}
