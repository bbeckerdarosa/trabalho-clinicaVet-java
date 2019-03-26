package br.com.clinicaVet.dto;

public class MetricaDTO {

	private Integer counter;
    private String name;

    public MetricaDTO(String name, Integer counter) {
        this.name = name;
        this.counter = counter;
    }

	public String getName() {
		return this.name;
	}

	public Integer getCounter() {
		return this.counter;
	}
}
