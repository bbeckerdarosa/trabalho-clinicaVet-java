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
@Table(name = "proprietario")
public class Proprietario extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proprietarioid")
	private Integer id;

	@NotNull(message = "Nome do proprietario nao pode ser nulo")
	@NotEmpty(message = "Nome do proprietario nao pode ser vazio")
	@Column(name = "nome_proprietario")
	private String nomeProprietario;

	private String endereco;
	private String numero;
	private String telefone;

	@NotNull(message = "Cpf nao pode ser nulo")
	@NotEmpty(message = "Cpf nao pode ser vazio")
	private String cpf;

	@SuppressWarnings("unused")
	private Proprietario() {
		// construtor for hibernate
	}

	public Proprietario(String nomeProprietario, String endereco, String numero, String telefone, String cpf) {
		this.nomeProprietario = nomeProprietario;
		this.endereco = endereco;
		this.numero = numero;
		this.telefone = telefone;
		this.cpf = cpf;
		validarDomain();
	}

	public Proprietario(Integer id, String nomeProprietario, String endereco, String numero, String telefone,
			String cpf) {
		this(nomeProprietario, endereco, numero, telefone, cpf);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getNumero() {
		return numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}

}
