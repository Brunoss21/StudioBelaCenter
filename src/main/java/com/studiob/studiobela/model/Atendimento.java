package com.studiob.studiobela.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;

public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String telefone;
    private String servico;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @Column(value = "horario")
    private LocalTime horario;

    public Atendimento() {

    }

    public Atendimento(String nome, String telefone, String servico, LocalDate data, LocalTime horario, String status) {
        this.nome = nome;
        this.telefone = telefone;
        this.servico = servico;
        this.data = data;
        this.horario = horario;
        this.status = status;
    }

    public Atendimento(int id, String nome, String telefone, String servico, String status, LocalDate data, LocalTime horario) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.servico = servico;
        this.status = status;
        this.data = data;
        this.horario = horario;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}
