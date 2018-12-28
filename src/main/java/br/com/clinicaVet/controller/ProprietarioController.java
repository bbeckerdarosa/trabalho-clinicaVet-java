package br.com.clinicaVet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaVet.dto.ProprietarioDTO;
import br.com.clinicaVet.service.ProprietarioService;

@RestController
@RequestMapping(value = "clinicaVet")
public class ProprietarioController {

	private ProprietarioService proprietarioService;

	@Autowired
	public ProprietarioController(ProprietarioService proprietarioService) {
		this.proprietarioService = proprietarioService;
	}

	@GetMapping(value = "/proprietario")
	public ResponseEntity<List<ProprietarioDTO>> obterProprietario() {
		List<ProprietarioDTO> proprietario = proprietarioService.findAll();
		return new ResponseEntity<>(proprietario, HttpStatus.OK);
	}

	@GetMapping(value = "/proprietario/{cpf}")
	public ResponseEntity<ProprietarioDTO> obterProprietarioPorCpf(@PathVariable("cpf") String cpf) {
		ProprietarioDTO proprietario = proprietarioService.findByCpf(cpf);
		return new ResponseEntity<ProprietarioDTO>(proprietario, HttpStatus.OK);
	}

	@PostMapping(value = "/proprietario")
	public ResponseEntity<?> salvar(@RequestBody @Valid ProprietarioDTO proprietarioDTO) {
		this.proprietarioService.save(proprietarioDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
