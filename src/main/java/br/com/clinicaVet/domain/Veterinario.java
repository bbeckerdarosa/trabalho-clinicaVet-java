package br.com.clinicaVet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "veterinario")
public class Veterinario extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "veterinarioid")
	private Integer id;

	@NotNull(message = "Nome do vaterinario nao pode ser nulo")
	@NotEmpty(message = "Nome do vaterinario nao pode ser vazio")
	@Column(name = "nome_veterinario")
	private String nomeVeterinario;

	@NotNull(message = "Cpf nao pode ser nulo")
	@NotEmpty(message = "Cpf nao pode ser vazio")
	private String cpf;

	@SuppressWarnings("unused")
	private Veterinario() {
		// construtor for hibernate
	}

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
