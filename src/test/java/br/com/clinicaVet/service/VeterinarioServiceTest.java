package br.com.clinicaVet.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class VeterinarioServiceTest {

	@Autowired
	private VeterinarioService veterinarioService;

	@After
	public void finished() {
		veterinarioService.deleteAll();
	}

	// @Test
	// public void deveSalvarUmVeterinario() {
	// Veterinario danielle = new Veterinario("Danielle Moura", "04189767898");
	// veterinarioService.save(danielle);
	//
	// Veterinario veterinarioSalvo = veterinarioService.findByCpf("04189767898");
	// Assert.assertEquals("Danielle Moura", veterinarioSalvo.getNomeVeterinario());
	// Assert.assertEquals("04189767898", danielle.getCpf());
	// }
	//
	// @Test(expected = ServiceException.class)
	// public void deveValidarVeterinarioJaCadastradoPeloCpf() {
	// Veterinario luciane = new Veterinario("Luciane Padilha", "52540409040");
	// veterinarioService.save(luciane);
	// veterinarioService.save(luciane);
	// }
	//
	// @Test
	// public void deveExcluirVeterinario() {
	// Veterinario joao = new Veterinario("Joao Novadella", "43171271052");
	// veterinarioService.save(joao);
	// veterinarioService.delete(joao);
	// }
}
