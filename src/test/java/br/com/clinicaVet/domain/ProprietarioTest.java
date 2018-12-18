package br.com.clinicaVet.domain;

import org.junit.Assert;
import org.junit.Test;

public class ProprietarioTest {

	@Test
	public void deveValidarProprietario() {
		Proprietario proprietario = new Proprietario("Barbara Becker", "Rua Tobias Barreto", "78", "996785766",
				"87867656078");

		Assert.assertEquals("Barbara Becker", proprietario.getNomeProprietario());
		Assert.assertEquals("Rua Tobias Barreto", proprietario.getEndereco());
		Assert.assertEquals("78", proprietario.getNumero());
		Assert.assertEquals("996785766", proprietario.getTelefone());
		Assert.assertEquals("87867656078", proprietario.getCpf());

	}

	@Test(expected = DominioInvalidoException.class)
	public void deveValidarDadosNulos() {
		new Proprietario(null, null, null, null, null);
	}
	
	@Test(expected = DominioInvalidoException.class)
	public void deveValidarDadosVazios() {
		new Proprietario("", "", "", "", "");
	}
}
