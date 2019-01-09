package br.com.clinicaVet.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class HistoricoConsultaDTO {

	private Integer id;

	private LocalDate dataAtendimento;

	@NotNull
	@NotEmpty
	private String diagnostico;

	@NotNull
	@NotEmpty
	private String cpfVeterinario;

	@NotNull
	@NotEmpty
	private String nomeVeterinario;

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

	public String getCpfVeterinario() {
		return cpfVeterinario;
	}

	public void setCpfVeterinario(String cpfVeterinario) {
		this.cpfVeterinario = cpfVeterinario;
	}

	public String getNomeVeterinario() {
		return nomeVeterinario;
	}

	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
	}

}
