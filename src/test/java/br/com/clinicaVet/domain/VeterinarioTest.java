package br.com.clinicaVet.domain;

import org.junit.Assert;
import org.junit.Test;

public class VeterinarioTest {

	@Test
	public void deveValidarVaterinario() {

		Veterinario vet = new Veterinario("Danielle Moura", "04189767898");

		Assert.assertEquals("Danielle Moura", vet.getNomeVeterinario());
		Assert.assertEquals("04189767898", vet.getCpf());
	}

	@Test(expected = DominioInvalidoException.class)
	public void deveValidarDadosNulos() {
		new Veterinario(null, null);
	}

	@Test(expected = DominioInvalidoException.class)
	public void deveValidarDadosVazios() {
		new Veterinario("", "");
	}
}
