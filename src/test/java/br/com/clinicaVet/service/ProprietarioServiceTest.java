package br.com.clinicaVet.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clinicaVet.dto.ProprietarioDTO;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class ProprietarioServiceTest {

	@Autowired
	private ProprietarioService proprietarioService;

	@After
	public void finished() {
		proprietarioService.deleteAll();
	}

	@Test
	public void deveSalvarUmProprietario() {
		ProprietarioDTO proprietarioParaSalvar = new ProprietarioDTO();
		proprietarioParaSalvar.setNomeProprietario("Barbara Becker");
		proprietarioParaSalvar.setEndereco("Rua Tobias Barreto");
		proprietarioParaSalvar.setNumero("45");
		proprietarioParaSalvar.setTelefone("51994567768");
		proprietarioParaSalvar.setCpf("68658693031");

		proprietarioService.save(proprietarioParaSalvar);
		ProprietarioDTO proprietarioSalvo = proprietarioService.findByCpf("68658693031");
		Assert.assertEquals("Barbara Becker", proprietarioSalvo.getNomeProprietario());
		Assert.assertEquals("45", proprietarioSalvo.getNumero());
		Assert.assertEquals("51994567768", proprietarioSalvo.getTelefone());
		Assert.assertEquals("68658693031", proprietarioSalvo.getCpf());
		Assert.assertEquals("Rua Tobias Barreto", proprietarioSalvo.getEndereco());

	}

	//
	// @Test(expected = ServiceException.class)
	// public void deveValidarProprietarioJaCadastradoPeloCpf() {
	// Proprietario joao = new Proprietario("Joao da Silva", "Rua Virginia", "45",
	// "999876755", "91964531098");
	// proprietarioService.save(joao);
	// proprietarioService.save(joao);
	// }
	//
	// @Test
	// public void deveExcluirProprietario() {
	// Proprietario marcos = new Proprietario("Marcos Barruffe", "Rua Higienopolis",
	// "120", "999845662",
	// "07683750026");
	//
	// proprietarioService.save(marcos);
	// proprietarioService.delete(marcos);
	// }
	//
	// @Test
	// public void deveAtualizarEnderecoETelefoneDoProprietario() {
	// Proprietario adrian = new Proprietario("Adrian Lemes", "Av. Ipiranga", "85",
	// "997425563", "77774191020");
	// proprietarioService.save(adrian);
	//
	// Proprietario adrianSalvo = proprietarioService.findByCpf("77774191020");
	//
	// Proprietario updateAdrian = new Proprietario(adrianSalvo.getId(), "Adrian
	// Lemes", "Av. Bento Gonçalves", "NA", "997425565", "77774191020");
	// proprietarioService.update(adrian);
	// Proprietario adrianAtualizado = proprietarioService.findByCpf("77774191020");
	//
	// Assert.assertEquals("Av. Bento Gonçalves", updateAdrian.getEndereco());
	// Assert.assertEquals("NA", updateAdrian.getNumero());
	// Assert.assertEquals("997425565", updateAdrian.getTelefone());
	// Assert.assertEquals("77774191020", adrianAtualizado.getCpf());
	//
	// }
}
