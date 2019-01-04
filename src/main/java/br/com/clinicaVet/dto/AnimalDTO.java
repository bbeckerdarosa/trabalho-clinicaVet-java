package br.com.clinicaVet.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.clinicaVet.domain.Proprietario;
import br.com.clinicaVet.domain.Animal.TipoAnimal;
import br.com.clinicaVet.domain.HistoricoConsulta;

public class AnimalDTO {

	private Integer id;

	@NotNull
	@NotEmpty
	private String nomeAnimal;

	@NotNull
	@NotEmpty
	private String raca;

	@ManyToOne
	@JoinColumn(name = "proprietarioid")
	private Proprietario proprietario;

	@NotNull
	@NotEmpty
	private String nroChip;

	@NotNull
	private LocalDate dataNascimento;

	private List<HistoricoConsulta> historicoConsulta;

	private TipoAnimal tipoAnimal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public String getNroChip() {
		return nroChip;
	}

	public void setNroChip(String nroChip) {
		this.nroChip = nroChip;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<HistoricoConsulta> getHistoricoConsulta() {
		return historicoConsulta;
	}

	public void setHistoricoConsulta(List<HistoricoConsulta> historicoConsulta) {
		this.historicoConsulta = historicoConsulta;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

}
