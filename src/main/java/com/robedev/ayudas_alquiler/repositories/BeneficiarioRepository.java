package com.robedev.ayudas_alquiler.repositories;

import com.robedev.ayudas_alquiler.entities.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
    Optional<Beneficiario> findByExpediente(String expediente);

    Optional<Beneficiario> findByBeneficiario(String beneficiario);

    @Query("SELECT b FROM Beneficiario b WHERE LOWER(b.beneficiario) LIKE %:keyword%")
    List<Beneficiario> findByKeywordInNombreOrApellido(@Param("keyword") String keyword);

}
