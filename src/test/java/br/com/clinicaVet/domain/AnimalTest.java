package br.com.clinicaVet.domain;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.com.clinicaVet.domain.Animal.TipoAnimal;

public class AnimalTest {

	@Test
	public void deveValidarAnimal() {
		Proprietario barbara = new Proprietario("Barbara Becker", "Rua Tobias Barreto", "78", "996785766",
				"87867656078");
		LocalDate dataNascimento = LocalDate.of(2017, 9, 11);
		Animal animal = new Animal("Snow", "Shih-Tzu", barbara, "564478", dataNascimento, TipoAnimal.CACHORRO);

		Assert.assertEquals("Snow", animal.getNomeAnimal());
		Assert.assertEquals("Shih-Tzu", animal.getRaca());
		Assert.assertEquals(barbara, animal.getProprietario());
		Assert.assertEquals("564478", animal.getNroChip());
		Assert.assertEquals(dataNascimento, animal.getDataNascimento());
		Assert.assertEquals(TipoAnimal.CACHORRO, animal.getTipoAnimal());
	}
	

	@Test(expected = DominioInvalidoException.class)
	public void deveValidarDadosNulos() {
		new Animal(null, null, null, null, null, null);
	}

	@Test(expected = DominioInvalidoException.class)
	public void deveValidarDadosVazios() {
		new Animal("", "", null, "", null, null);
	}
}