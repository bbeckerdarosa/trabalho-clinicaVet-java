package br.com.clinicaVet.service;

import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clinicaVet.domain.Proprietario;
import br.com.clinicaVet.dto.AnimalDTO;
import br.com.clinicaVet.domain.Animal.TipoAnimal;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class AnimalServiceTest {

	@Autowired
	private AnimalService animalService;

	@After
	public void finished() {
		animalService.deleteAll();
	}

	@Test
	public void deveSalvarUmAnimal() {
		Proprietario barbara = new Proprietario("Barbara Becker", "Rua Mali", "405", "51996859978", "86878506034");
		AnimalDTO animalParaSalvar = new AnimalDTO();
		animalParaSalvar.setNomeAnimal("Snow");
		animalParaSalvar.setRaca("Shih-Tzu");
		animalParaSalvar.setProprietario(barbara);
		animalParaSalvar.setNroChip("48596");
		animalParaSalvar.setDataNascimento(LocalDate.of(2017, Month.SEPTEMBER, 11));
		animalParaSalvar.setTipoAnimal(TipoAnimal.CACHORRO);

		animalService.save(animalParaSalvar);
		AnimalDTO animalSalvo = animalService.findByNroChip("48596");
		Assert.assertEquals("Snow", animalSalvo.getNomeAnimal());
		Assert.assertEquals("Shih-Tzu", animalSalvo.getRaca());
		Assert.assertEquals(barbara, animalSalvo.getProprietario());
		Assert.assertEquals("568999", animalSalvo.getNroChip());
		Assert.assertNotNull(LocalDate.of(2017, Month.SEPTEMBER, 11));
		Assert.assertEquals(TipoAnimal.CACHORRO, animalSalvo.getTipoAnimal());
	}
}
