package br.com.clinicaVet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.clinicaVet.domain.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	@Query("SELECT COUNT(1) AS existe FROM Animal a WHERE a.nroChip = :nroChip")
	public Long validateExistAnimalByNrmChip(@Param("nroChip") String nroChip);

	@Query("SELECT a FROM Animal a WHERE a.nroChip = :nroChip")
	public Optional<Animal> findByNrmChip(@Param("nroChip") String nroChip);

}
