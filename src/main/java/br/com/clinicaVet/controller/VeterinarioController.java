package br.com.clinicaVet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaVet.dto.VeterinarioDTO;
import br.com.clinicaVet.service.VeterinarioService;

@RestController
@RequestMapping(value = "clinicaVet")
public class VeterinarioController {

	private VeterinarioService veterinarioService;

	@Autowired
	public VeterinarioController(VeterinarioService veterinarioService) {
		this.veterinarioService = veterinarioService;
	}

	@GetMapping(value = "/veterinario")
	public ResponseEntity<List<VeterinarioDTO>> obterVeterinario() {
		List<VeterinarioDTO> veterinario = veterinarioService.findAll();
		return new ResponseEntity<>(veterinario, HttpStatus.OK);
	}

	@GetMapping(value = "/veterinario/{cpf}")
	public ResponseEntity<VeterinarioDTO> obterVeterinarioPorCpf(@PathVariable("cpf") String cpf) {
		VeterinarioDTO veterinario = veterinarioService.findByCpf(cpf);
		return new ResponseEntity<VeterinarioDTO>(veterinario, HttpStatus.OK);
	}

	@PostMapping(value = "/veterinario")
	public ResponseEntity<?> salvar(@RequestBody @Valid VeterinarioDTO veterinarioDTO) {
		this.veterinarioService.save(veterinarioDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/veterinario/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.veterinarioService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
