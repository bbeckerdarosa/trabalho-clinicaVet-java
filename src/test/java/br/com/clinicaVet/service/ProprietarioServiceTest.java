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
		ProprietarioDTO proprietarioDTO = new ProprietarioDTO();
		proprietarioDTO.setNomeProprietario("Barbara Becker");
		proprietarioDTO.setEndereco("Rua Tobias Barreto");
		proprietarioDTO.setNumero("45");
		proprietarioDTO.setTelefone("51994567768");
		proprietarioDTO.setCpf("68658693031");

		proprietarioService.save(proprietarioDTO);
		ProprietarioDTO proprietarioSalvo = proprietarioService.findByCpf("68658693031");
		Assert.assertEquals(proprietarioDTO.getNomeProprietario(), proprietarioSalvo.getNomeProprietario());
		Assert.assertEquals(proprietarioDTO.getNumero(), proprietarioSalvo.getNumero());
		Assert.assertEquals(proprietarioDTO.getTelefone(), proprietarioSalvo.getTelefone());
		Assert.assertEquals(proprietarioDTO.getCpf(), proprietarioSalvo.getCpf());
		Assert.assertEquals(proprietarioDTO.getEndereco(), proprietarioSalvo.getEndereco());

	}

	@Test(expected = ServiceException.class)
	public void deveExcluirProprietario() {
		ProprietarioDTO proprietarioDTO = new ProprietarioDTO();
		proprietarioDTO.setNomeProprietario("Barbara Becker");
		proprietarioDTO.setEndereco("Rua Tobias Barreto");
		proprietarioDTO.setNumero("45");
		proprietarioDTO.setTelefone("51994567768");
		proprietarioDTO.setCpf("68658693031");

		proprietarioService.save(proprietarioDTO);
		proprietarioService.deleteByCpf("68658693031");
		proprietarioService.findByCpf("68658693031");
	}

	@Test
	public void deveEditarEnderecoNumeroETelefone() {
		ProprietarioDTO proprietarioDTO = new ProprietarioDTO();
		proprietarioDTO.setNomeProprietario("Barbara Becker");
		proprietarioDTO.setEndereco("Rua Tobias Barreto");
		proprietarioDTO.setNumero("45");
		proprietarioDTO.setTelefone("51994567768");
		proprietarioDTO.setCpf("68658693031");
		proprietarioService.save(proprietarioDTO);

		ProprietarioDTO proprietarioParaEditar = proprietarioService.findByCpf("68658693031");
		proprietarioParaEditar.setEndereco("Rua Marrocos");
		proprietarioParaEditar.setNumero("670");
		proprietarioParaEditar.setTelefone("51988459632");
		proprietarioService.update(proprietarioParaEditar);

		ProprietarioDTO proprietarioEditado = proprietarioService.findByCpf("68658693031");
		Assert.assertEquals("Rua Marrocos", proprietarioEditado.getEndereco());
		Assert.assertEquals("670", proprietarioEditado.getNumero());
		Assert.assertEquals("51988459632", proprietarioEditado.getTelefone());

	}
}
