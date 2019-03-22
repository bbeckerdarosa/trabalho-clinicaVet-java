package br.com.clinicaVet.metrics;

public enum AnimalCounterSingleton {
    INSTANCE,

    private int counter = 0;

    public void inc() {
        this.counter++;
    }
}
