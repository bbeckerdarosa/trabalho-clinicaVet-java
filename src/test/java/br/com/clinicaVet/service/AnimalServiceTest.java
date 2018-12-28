package br.com.clinicaVet.service;

import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clinicaVet.domain.Animal;
import br.com.clinicaVet.domain.Proprietario;
import br.com.clinicaVet.domain.Animal.TipoAnimal;
import br.com.clinicaVet.repository.ProprietarioRepository;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class AnimalServiceTest {

	@Autowired
	private AnimalService animalService;

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	private Proprietario barbara;

	@Before
	public void init() {
		barbara = new Proprietario("Barbara Becker", "Rua Molias", "45", "51998786766", "52113441039");
		proprietarioRepository.saveAndFlush(barbara);
	}

	@After
	public void finished() {
		animalService.deleteAll();
	}

	@Test
	public void deveSalvarUmAnimal() {
		Animal snow = new Animal("Snow", "Shih-Tzu", barbara, "568999", LocalDate.of(2017, Month.SEPTEMBER, 11),
				TipoAnimal.CACHORRO);
		animalService.save(snow);

		Animal animalSalvo = animalService.findByNrmChip("568999");
		Assert.assertEquals("Snow", animalSalvo.getNomeAnimal());
		Assert.assertEquals("Shih-Tzu", snow.getRaca());
		Assert.assertEquals(barbara, snow.getProprietario());
		Assert.assertEquals("Shih-Tzu", snow.getRaca());
		Assert.assertEquals("568999", snow.getNroChip());
		Assert.assertNotNull(LocalDate.of(2017, Month.SEPTEMBER, 11));
		Assert.assertEquals(TipoAnimal.CACHORRO, snow.getTipoAnimal());
	}
}
