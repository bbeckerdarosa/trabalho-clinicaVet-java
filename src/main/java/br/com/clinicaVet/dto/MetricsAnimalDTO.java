package br.com.clinicaVet.dto;

public class MetricsAnimalDTO {

	private Integer getAnimalCounter;
	private Integer delAnimalCounter;

	public Integer getGetAnimalCounter() {
		return getAnimalCounter;
	}

	public void setGetAnimalCounter(Integer getAnimalCounter) {
		this.getAnimalCounter = getAnimalCounter;
	}

	public Integer getDelAnimalCounter() {
		return delAnimalCounter;
	}

	public void setDelAnimalCounter(Integer delAnimalCounter) {
		this.delAnimalCounter = delAnimalCounter;
	}
}
