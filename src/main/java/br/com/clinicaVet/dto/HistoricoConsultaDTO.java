package br.com.clinicaVet.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class HistoricoConsultaDTO {

	private Integer id;

	@NotNull
	private LocalDate dataAtendimento;

	@NotNull
	@NotEmpty
	private String diagnostico;

	private String veterinario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(LocalDate dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}

}
