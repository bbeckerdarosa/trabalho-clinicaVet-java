package br.com.clinicaVet.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "animal")
public class Animal extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "animalid")
	private Integer id;

	@NotNull(message = "Nome do animal nao pode ser nulo")
	@NotEmpty(message = "Nome do animal nao pode ser vazio")
	@Column(name = "nome_animal")
	private String nomeAnimal;

	@NotNull(message = "A raça do animal nao deve ser nula")
	@NotEmpty(message = "A raça do animal nao deve ser vazia")
	private String raca;

	@ManyToOne
	@JoinColumn(name = "proprietarioid")
	private Proprietario proprietario;

	@NotNull(message = "O numero do chip nao pode ser nulo")
	@NotEmpty(message = "O numero do chip nao pode ser vazio")
	@Column(name = "nro_chip")
	private String nroChip;

	@NotNull
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@Column(name = "historico_consulta")
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "historico_consultaid")
	private List<HistoricoConsulta> historicoConsulta;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_animal")
	private TipoAnimal tipoAnimal;

	@SuppressWarnings("unused")
	private Animal() {
		// construtor for hibernate
	}

	public Animal(String nomeAnimal, String raca, Proprietario proprietario, String nroChip, LocalDate dataNascimento,
			TipoAnimal tipoAnimal) {
		this.nomeAnimal = nomeAnimal;
		this.raca = raca;
		this.proprietario = proprietario;
		this.nroChip = nroChip;
		this.historicoConsulta = new ArrayList<>();
		this.dataNascimento = dataNascimento;
		this.tipoAnimal = tipoAnimal;
		validarDomain();
	}

	public Animal(Integer id, String nomeAnimal, String raca, Proprietario proprietario, String nroChip,
			LocalDate dataNascimento, TipoAnimal tipoAnimal) {
		this(nomeAnimal, raca, proprietario, nroChip, dataNascimento, tipoAnimal);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public String getRaca() {
		return raca;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public String getNroChip() {
		return nroChip;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public List<HistoricoConsulta> getHistoricoConsulta() {
		return historicoConsulta;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public enum TipoAnimal {
		CACHORRO, GATO, TARTARUGA, COELHO, CAVALO, HAMSTER
	}

}
