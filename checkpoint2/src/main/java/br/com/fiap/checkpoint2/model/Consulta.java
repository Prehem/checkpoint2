package br.com.fiap.checkpoint2.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Consulta {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Profissional profissional;

    @ManyToOne
    private Paciente paciente;

    private LocalDate dataConsulta;
    private String statusConsulta;
    private Double quantidadeHoras;
    private Double valorConsulta;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Consulta() {}

    public Consulta(Long id, Profissional profissional, Paciente paciente,
                    LocalDate dataConsulta, String statusConsulta,
                    Double quantidadeHoras, Double valorConsulta,
                    LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.profissional = profissional;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.statusConsulta = statusConsulta;
        this.quantidadeHoras = quantidadeHoras;
        this.valorConsulta = valorConsulta;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public LocalDate getDataConsulta() { return dataConsulta; }
    public void setDataConsulta(LocalDate dataConsulta) { this.dataConsulta = dataConsulta; }

    public String getStatusConsulta() { return statusConsulta; }
    public void setStatusConsulta(String statusConsulta) { this.statusConsulta = statusConsulta; }

    public Double getQuantidadeHoras() { return quantidadeHoras; }
    public void setQuantidadeHoras(Double quantidadeHoras) { this.quantidadeHoras = quantidadeHoras; }

    public Double getValorConsulta() { return valorConsulta; }
    public void setValorConsulta(Double valorConsulta) { this.valorConsulta = valorConsulta; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
