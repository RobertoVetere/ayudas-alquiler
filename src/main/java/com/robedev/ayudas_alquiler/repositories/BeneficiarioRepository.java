package com.robedev.ayudas_alquiler.repositories;

import com.robedev.ayudas_alquiler.entities.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
    Optional<Beneficiario> findByExpediente(String expediente);
}
