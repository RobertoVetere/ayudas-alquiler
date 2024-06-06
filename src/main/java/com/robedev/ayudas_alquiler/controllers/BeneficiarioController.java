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
    BeneficiarioService service;

    @GetMapping(value = "/all")
    public List<Beneficiario> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/expediente{expediente}")
    public ResponseEntity<Beneficiario> findById(@PathVariable String expediente){
        return service.findByExpediente(expediente);
    }
}
