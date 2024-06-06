package com.robedev.ayudas_alquiler.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String expediente;
    private String documento;
    private String beneficiario;

    private String putuacionCriterios;
    private String subvencionMaxima;
    private String porcentajeSubvencion;

    public Beneficiario() {
    }

    public Beneficiario(String expediente, String documento, String beneficiario,String putuacionCriterios, String subvencionMaxima, String porcentajeSubvencion) {
        this.expediente = expediente;
        this.documento = documento;
        this.beneficiario = beneficiario;
        this.putuacionCriterios = putuacionCriterios;
        this.subvencionMaxima = subvencionMaxima;
        this.porcentajeSubvencion = porcentajeSubvencion;
    }

    public Long getId() {
        return id;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getSubvencionMaxima() {
        return subvencionMaxima;
    }

    public void setSubvencionMaxima(String subvencionMaxima) {
        this.subvencionMaxima = subvencionMaxima;
    }

    public String getPorcentajeSubvencion() {
        return porcentajeSubvencion;
    }

    public void setPorcentajeSubvencion(String porcentajeSubvencion) {
        this.porcentajeSubvencion = porcentajeSubvencion;
    }

    public String getPutuacionCriterios() {
        return putuacionCriterios;
    }

    public void setPutuacionCriterios(String putuacionCriterios) {
        this.putuacionCriterios = putuacionCriterios;
    }

    @Override
    public String toString() {
        return "Beneficiario{" +
                "id=" + id +
                ", expediente='" + expediente + '\'' +
                ", documento='" + documento + '\'' +
                ", beneficiario='" + beneficiario + '\'' +
                ", putuacionCriterios='" + putuacionCriterios + '\'' +
                ", subvencionMaxima='" + subvencionMaxima + '\'' +
                ", porcentajeSubvencion='" + porcentajeSubvencion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beneficiario that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getExpediente(), that.getExpediente()) && Objects.equals(getDocumento(), that.getDocumento()) && Objects.equals(getBeneficiario(), that.getBeneficiario()) && Objects.equals(getPutuacionCriterios(), that.getPutuacionCriterios()) && Objects.equals(getSubvencionMaxima(), that.getSubvencionMaxima()) && Objects.equals(getPorcentajeSubvencion(), that.getPorcentajeSubvencion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getExpediente(), getDocumento(), getBeneficiario(), getPutuacionCriterios(), getSubvencionMaxima(), getPorcentajeSubvencion());
    }
}
