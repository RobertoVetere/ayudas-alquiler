package com.robedev.ayudas_alquiler.controllers;

import com.robedev.ayudas_alquiler.entities.Beneficiario;
import com.robedev.ayudas_alquiler.services.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BeneficiarioController {

    @Autowired
    BeneficiarioService beneficiarioService;

    @GetMapping(value = "/all")
    public List<Beneficiario> findAll(){
        return beneficiarioService.findAll();
    }

    @GetMapping(value = "/expediente{expediente}")
    public ResponseEntity<Beneficiario> findByExpediente(@PathVariable String expediente){
        return beneficiarioService.findByExpediente(expediente);
    }

    @GetMapping(value = "/beneficiario{beneficiario}")
    public ResponseEntity<List<Beneficiario>> findByBeneficiario(@PathVariable String beneficiario){
        return beneficiarioService.findByBeneficiario(beneficiario);
    }
}
