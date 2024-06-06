package com.robedev.ayudas_alquiler.services;

import com.robedev.ayudas_alquiler.entities.Beneficiario;
import com.robedev.ayudas_alquiler.repositories.BeneficiarioRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {
    @Autowired
    BeneficiarioRepository beneficiarioRepository;

    public void procesarPDF(File archivoPDF) {
        try (PDDocument document = PDDocument.load(archivoPDF)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String texto = pdfStripper.getText(document);

            // Dividir el texto en líneas
            String[] lineas = texto.split("\\r?\\n");

            for (String linea : lineas) {
                // Suponiendo que las columnas están separadas por espacios múltiples o tabulaciones
                String[] columnas = linea.split("\\s+");

                // Verifica que la línea tenga el número correcto de columnas (ajusta según sea necesario)
                if (columnas.length >= 6) {
                    String expediente = columnas[0];
                    String documento = columnas[1];

                    // Índices para las últimas tres columnas
                    int indexPuntuacionCriterios = columnas.length - 3;
                    int penultimoIndice = columnas.length - 2;
                    int ultimoIndice = columnas.length - 1;

                    String puntuacionCriterios = columnas[indexPuntuacionCriterios];
                    String subvencionMaxima = columnas[penultimoIndice];
                    String porcentajeSubvencion = columnas[ultimoIndice];

                    // Unir el nombre del beneficiario separado por espacios
                    StringBuilder beneficiarioBuilder = new StringBuilder();
                    for (int i = 2; i < indexPuntuacionCriterios; i++) {
                        beneficiarioBuilder.append(columnas[i]);
                        if (i < indexPuntuacionCriterios - 1) {
                            beneficiarioBuilder.append(" ");
                        }
                    }
                    String beneficiario = beneficiarioBuilder.toString();

                    Beneficiario nuevoBeneficiario = new Beneficiario(expediente, documento, beneficiario, puntuacionCriterios, subvencionMaxima, porcentajeSubvencion);
                    beneficiarioRepository.save(nuevoBeneficiario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Beneficiario> findAll() {
        return beneficiarioRepository.findAll();
    }

    public ResponseEntity<Beneficiario> findByExpediente(String expediente) {

        Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findByExpediente(expediente);
        return beneficiarioOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                .notFound().build());
    }
}
