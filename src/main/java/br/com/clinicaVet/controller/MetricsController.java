package br.com.clinicaVet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.clinicaVet.dto.MetricsAnimalDTO;
import br.com.clinicaVet.metrics.AnimalCounterSingleton;
import br.com.clinicaVet.metrics.AnimalDeleteCounterSingleton;

@RestController
@RequestMapping(value = "clinicaVet")
public class MetricsController {

	@Autowired
	public MetricsController() {
	}

	@GetMapping(value = "/metrics")
	public ResponseEntity<MetricsAnimalDTO> obterMetricaAnimal() {
		int valorGetAnimal = AnimalCounterSingleton.INSTANCE.getValor();
		int valorDelAnimal = AnimalDeleteCounterSingleton.INSTANCE.getValor();

		MetricsAnimalDTO metricasDTO = new MetricsAnimalDTO();
		metricasDTO.setGetAnimalCounter(valorGetAnimal);
		metricasDTO.setDelAnimalCounter(valorDelAnimal);

		return new ResponseEntity<>(metricasDTO, HttpStatus.OK);
	}

//	@GetMapping(value = "/metrics")
//	public ResponseEntity<List<MetricaDTO>> obterMetricas() {
//        List<MetricaDTO> metricas = new ArrayList<MetricaDTO>();
//        metricas.add(new MetricaDTO("getAnimal", AnimalCounterSingleton.INSTANCE.getValor()));
//        metricas.add(new MetricaDTO("delAnimal", AnimalDeleteCounterSingleton.INSTANCE.getValor()));
//        metricas.add(new MetricaDTO("outroAnimal", AnimalDeleteCounterSingleton.INSTANCE.getValor()));
//
//		return new ResponseEntity<>(metricas, HttpStatus.OK);
//	}
}
