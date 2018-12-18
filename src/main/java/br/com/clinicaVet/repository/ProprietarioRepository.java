package br.com.clinicaVet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.clinicaVet.domain.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {

	@Query("SELECT COUNT(1) AS existe FROM Proprietario p WHERE p.cpf = :cpf")
	public Long validateExistProprietarioByCpf(@Param("cpf") String cpf);

	@Query("SELECT p FROM Proprietario p WHERE p.cpf = :cpf")
	public Optional<Proprietario> findByCpf(@Param("cpf") String cpf);

}
