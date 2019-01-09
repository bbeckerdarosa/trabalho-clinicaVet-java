package br.com.clinicaVet.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.clinicaVet.domain.Animal.TipoAnimal;

public class AnimalDTO {

	private Integer id;

	@NotNull
	@NotEmpty
	private String nomeAnimal;

	@NotNull
	@NotEmpty
	private String raca;

	private String proprietario;

	private String cpfProprietario;
	
	@NotNull
	@NotEmpty
	private String nroChip;

	@NotNull
	private LocalDate dataNascimento;

	// inclusao
	private HistoricoConsultaDTO historicoConsultaDTO;
	
	// consulta
	private List<HistoricoConsultaDTO> historicoConsulta;

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

	public String getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getCpfProprietario() {
		return cpfProprietario;
	}
	
	public void setCpfProprietario(String cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
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

	public List<HistoricoConsultaDTO> getHistoricoConsulta() {
		return historicoConsulta;
	}

	public void setHistoricoConsulta(List<HistoricoConsultaDTO> historicoConsulta) {
		this.historicoConsulta = historicoConsulta;
	}
	
	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	
	public HistoricoConsultaDTO getHistoricoConsultaDTO() {
		return historicoConsultaDTO;
	}
	
	public void setHistoricoConsultaDTO(HistoricoConsultaDTO historicoConsultaDTO) {
		this.historicoConsultaDTO = historicoConsultaDTO;
	}

}
