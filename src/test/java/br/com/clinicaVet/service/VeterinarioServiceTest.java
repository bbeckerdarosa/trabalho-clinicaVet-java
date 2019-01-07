package br.com.clinicaVet.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clinicaVet.dto.VeterinarioDTO;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class VeterinarioServiceTest {

	@Autowired
	private VeterinarioService veterinarioService;

	@After
	public void finished() {
		veterinarioService.deleteAll();
	}

	@Test
	public void deveSalvarUmVeterinario() {
		VeterinarioDTO veterinarioDTO = new VeterinarioDTO();
		veterinarioDTO.setNomeVeterinario("Danielle Moura");
		veterinarioDTO.setCpf("04189767898");

		veterinarioService.save(veterinarioDTO);
		VeterinarioDTO veterinarioSalvo = veterinarioService.findByCpf("04189767898");
		Assert.assertEquals(veterinarioDTO.getNomeVeterinario(), veterinarioSalvo.getNomeVeterinario());
		Assert.assertEquals(veterinarioDTO.getCpf(), veterinarioSalvo.getCpf());
	}

	@Test(expected = ServiceException.class)
	public void deveExcluirVeterinario() {
		VeterinarioDTO veterinarioDTO = new VeterinarioDTO();
		veterinarioDTO.setNomeVeterinario("Danielle Moura");
		veterinarioDTO.setCpf("04189767898");

		veterinarioService.save(veterinarioDTO);
		veterinarioService.deleteByCpf("04189767898");
		veterinarioService.findByCpf("04189767898");
	}
}
