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

@RestController
@RequestMapping(value = "clinicaVet")
public class MetricsController {

	@Autowired
	public MetricsController() {
	}

	@GetMapping(value = "/metrics")
	public ResponseEntity<MetricasDTO> obterMetricas() {
        int valorGetAnimal = AnimalCounterSingleton.INSTANCE.getValor();
        int valorDelAnimal = AnimalDeleteCounterSingleton.INSTANCE.getValor();

        MetricasDTO metricasDTO = new MetricasDTO();
        metricasDTO.setGetAnimalCounter(valorGetAnimal);
        metricasDTO.setDelAnimalCounter(valorDelAnimal)

        // retornar
		return new ResponseEntity<>(metricasDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/metrics")
	public ResponseEntity<List<MetricaDTO>> obterMetricas() {
        List<MetricaDTO> metricas = new ArrayList<MetricaDTO>();
        metricas.add(new MetricaDTO("getAnimal", AnimalCounterSingleton.INSTANCE.getValor()));
        metricas.add(new MetricaDTO("delAnimal", AnimalDeleteCounterSingleton.INSTANCE.getValor()));
        metricas.add(new MetricaDTO("outroAnimal", AnimalDeleteCounterSingleton.INSTANCE.getValor()));

		return new ResponseEntity<>(metricas, HttpStatus.OK);
	}
}
