package br.com.clinicaVet.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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

import br.com.clinicaVet.dto.AnimalDTO;
import br.com.clinicaVet.dto.HistoricoConsultaDTO;
import br.com.clinicaVet.service.AnimalService;

@RestController
@RequestMapping(value = "clinicaVet")
public class AnimalController {

	private AnimalService animalService;

	@Autowired
	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping(value = "/animal")
	public ResponseEntity<List<AnimalDTO>> obterAnimal() {
		List<AnimalDTO> animal = animalService.findAll();
		return new ResponseEntity<>(animal, HttpStatus.OK);
	}

	@GetMapping(value = "/animal/{nroChip}")
	public ResponseEntity<AnimalDTO> obterAnimalPeloNroChip(@PathVariable("nroChip") String nroChip) {
		AnimalDTO animal = animalService.findByNroChip(nroChip);
		return new ResponseEntity<AnimalDTO>(animal, HttpStatus.OK);
	}

	@PostMapping(value = "/animal")
	public ResponseEntity<?> salvar(@RequestBody @Valid AnimalDTO animalDTO) {
		this.animalService.save(animalDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/animal/{nroChip}/realizar-consulta")
	public ResponseEntity<?> salvarConsulta(@PathParam("nroChip") String nroChip, @RequestBody HistoricoConsultaDTO historicoConsultaDTO) {
		this.animalService.salvarConsulta(nroChip, historicoConsultaDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/animal/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.animalService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
