package br.com.clinicaVet.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

public class VeterinarioDTO {

	private Integer id;

	@NotNull
	@NotEmpty
	private String nomeVeterinario;

	@NotNull
	@NotEmpty
	@CPF
	private String cpf;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeVeterinario() {
		return nomeVeterinario;
	}

	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
