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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeProprietario == null) ? 0 : nomeProprietario.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proprietario other = (Proprietario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeProprietario == null) {
			if (other.nomeProprietario != null)
				return false;
		} else if (!nomeProprietario.equals(other.nomeProprietario))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	
	
}
