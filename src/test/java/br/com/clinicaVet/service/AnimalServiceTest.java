package br.com.clinicaVet.service;

import static org.junit.Assert.assertEquals;

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

import br.com.clinicaVet.domain.Animal.TipoAnimal;
import br.com.clinicaVet.domain.Proprietario;
import br.com.clinicaVet.domain.Veterinario;
import br.com.clinicaVet.dto.AnimalDTO;
import br.com.clinicaVet.dto.HistoricoConsultaDTO;
import br.com.clinicaVet.repository.ProprietarioRepository;
import br.com.clinicaVet.repository.VeterinarioRepository;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class AnimalServiceTest {

	@Autowired
	private AnimalService animalService;

	@Autowired
	private ProprietarioRepository proprietarioRepo;

	@Autowired
	private VeterinarioRepository veterinarioRepo;

	private Veterinario danielle;

	private Proprietario barbara;

	@Before
	public void init() {
		barbara = new Proprietario("Barbara Becker", "Rua Mali", "405", "51996859978", "86878506034");
		proprietarioRepo.saveAndFlush(barbara);

		danielle = new Veterinario("Danielle Moura", "74372270020");
		veterinarioRepo.saveAndFlush(danielle);
	}

	@After
	public void finished() {
		animalService.deleteAll();
		proprietarioRepo.deleteAll();
		veterinarioRepo.deleteAll();
	}

	@Test
	public void deveSalvarUmAnimal() {
		AnimalDTO animalParaSalvar = new AnimalDTO();
		animalParaSalvar.setNomeAnimal("Snow");
		animalParaSalvar.setRaca("Shih-Tzu");
		animalParaSalvar.setProprietario("barbara");
		animalParaSalvar.setCpfProprietario("86878506034");
		animalParaSalvar.setNroChip("48596");
		animalParaSalvar.setDataNascimento(LocalDate.of(2017, Month.SEPTEMBER, 11));
		animalParaSalvar.setTipoAnimal(TipoAnimal.CACHORRO);

		animalService.save(animalParaSalvar);
		AnimalDTO animalSalvo = animalService.findByNroChip("48596");
		Assert.assertEquals("Snow", animalSalvo.getNomeAnimal());
		Assert.assertEquals("Shih-Tzu", animalSalvo.getRaca());
		Assert.assertEquals(barbara.getNomeProprietario(), animalSalvo.getProprietario());
		Assert.assertEquals(barbara.getCpf(), animalSalvo.getCpfProprietario());
		Assert.assertEquals("48596", animalSalvo.getNroChip());
		Assert.assertNotNull(LocalDate.of(2017, Month.SEPTEMBER, 11));
		Assert.assertEquals(TipoAnimal.CACHORRO, animalSalvo.getTipoAnimal());
	}

	@Test
	public void deveSalvarHistoricoConsulta() {
		AnimalDTO animalParaSalvar = new AnimalDTO();
		animalParaSalvar.setNomeAnimal("Snow");
		animalParaSalvar.setRaca("Shih-Tzu");
		animalParaSalvar.setProprietario("barbara");
		animalParaSalvar.setCpfProprietario("86878506034");
		animalParaSalvar.setNroChip("48596");
		animalParaSalvar.setDataNascimento(LocalDate.of(2017, Month.SEPTEMBER, 11));
		animalParaSalvar.setTipoAnimal(TipoAnimal.CACHORRO);

		animalService.save(animalParaSalvar);

		HistoricoConsultaDTO historicoAtendimento1 = new HistoricoConsultaDTO();
		historicoAtendimento1.setDiagnostico("O animal esta com as patas assadas. Receitamos Prednisolona 20mg");
		historicoAtendimento1.setCpfVeterinario(danielle.getCpf());

		HistoricoConsultaDTO historicoAtendimento2 = new HistoricoConsultaDTO();
		historicoAtendimento2.setDiagnostico("O animal esta com as patas assadas. Receitamos Prednisolona 20mg");
		historicoAtendimento2.setCpfVeterinario(danielle.getCpf());

		animalService.salvarConsulta("48596", historicoAtendimento1);
		animalService.salvarConsulta("48596", historicoAtendimento2);

		AnimalDTO animalComHistorico = animalService.findByNroChip("48596");
		assertEquals(2, animalComHistorico.getHistoricoConsulta().size());
	}

	@Test(expected = ServiceException.class)
	public void deveExcluirAnimal() {
		AnimalDTO animalDTO = new AnimalDTO();
		animalDTO.setNomeAnimal("Snow");
		animalDTO.setRaca("Shih-Tzu");
		animalDTO.setProprietario("barbara");
		animalDTO.setCpfProprietario("86878506034");
		animalDTO.setNroChip("48596");
		animalDTO.setDataNascimento(LocalDate.of(2017, Month.SEPTEMBER, 11));
		animalDTO.setTipoAnimal(TipoAnimal.CACHORRO);

		animalService.save(animalDTO);
		animalService.deleteByNroChip("48596");
		animalService.findByNroChip("48596");
	}
}
