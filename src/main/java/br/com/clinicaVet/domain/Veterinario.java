package br.com.clinicaVet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "veterinario")
public class Veterinario extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "veterinarioid")
	private Integer id;

	@NotNull(message = "Nome do vaterinario nao pode ser nulo")
	private String nomeVeterinario;
	private String cpf;

	public Veterinario(String nomeVeterinario, String cpf) {
		this.nomeVeterinario = nomeVeterinario;
		this.cpf = cpf;
		validarDomain();
	}

	public Veterinario(Integer id, String nomeVeterinario, String cpf) {
		this(nomeVeterinario, cpf);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNomeVeterinario() {
		return nomeVeterinario;
	}

	public String getCpf() {
		return cpf;
	}

}
