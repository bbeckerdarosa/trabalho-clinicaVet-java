package br.com.clinicaVet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.clinicaVet.domain.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

	@Query("SELECT COUNT(1) AS existe FROM Veterinario v WHERE v.cpf = :cpf")
	public Long validateExistVeterinarioByCpf(@Param("cpf") String cpf);

	@Query("SELECT v FROM Veterinario v WHERE v.cpf = :cpf")
	public Optional<Veterinario> findByCpf(@Param("cpf") String cpf);
}
