package br.com.clinicaVet.metrics;

public enum AnimalDeleteCounterSingleton {
	INSTANCE;

	private int counter = 0;

	public void inc() {
		this.counter++;
	}

	public int getValor() {
		return this.counter;
	}
}
