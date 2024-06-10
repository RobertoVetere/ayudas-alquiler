package com.robedev.ayudas_alquiler;

import com.robedev.ayudas_alquiler.entities.Beneficiario;
import com.robedev.ayudas_alquiler.repositories.BeneficiarioRepository;
import com.robedev.ayudas_alquiler.services.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AyudasAlquilerApplication implements CommandLineRunner {

	//@Autowired
	//BeneficiarioService beneficiarioService;

	//@Autowired
	//BeneficiarioRepository beneficiarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(AyudasAlquilerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*
		List<Beneficiario> existingBeneficiarios = beneficiarioRepository.findAll();
		if (existingBeneficiarios.isEmpty()) {
			String archivoPDF = "anexo.pdf";
			File documento = new File(archivoPDF);
			if (documento.exists()) {
				beneficiarioService.procesarPDF(documento);
				System.out.println("Archivo procesado correctamente");
			} else {
				System.out.println("El documento no existe");
			}
		} else {
			System.out.println("Los datos ya existen en la base de datos, no se requiere cargar el archivo PDF.");
		}

	 */

	}
}
