package com.example.componentesbasicos.model;

import android.os.Parcelable;

import java.io.Serializable;

public class Aluno {
    private String nome;
    private String sobrenome;
    private String matricula;
    private String curso;
    private String turno_de_utilizacao;
    private String qualidade_laboratorio;
    private String disponibilidade_laboratorio;

    public Aluno(String nome, String sobrenome, String matricula,
                 String curso, String turno_de_utilizacao, String qualidade_laboratorio,
                 String disponibilidade_laboratorio) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.curso = curso;
        this.turno_de_utilizacao = turno_de_utilizacao;
        this.qualidade_laboratorio = qualidade_laboratorio;
        this.disponibilidade_laboratorio = disponibilidade_laboratorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurno_de_utilizacao() {
        return turno_de_utilizacao;
    }

    public void setTurno_de_utilizacao(String turno_de_utilizacao) {
        this.turno_de_utilizacao = turno_de_utilizacao;
    }

    public String getQualidade_laboratorio() {
        return qualidade_laboratorio;
    }

    public void setQualidade_laboratorio(String qualidade_laboratorio) {
        this.qualidade_laboratorio = qualidade_laboratorio;
    }

    public String getDisponibilidade_laboratorio() {
        return disponibilidade_laboratorio;
    }

    public void setDisponibilidade_laboratorio(String disponibilidade_laboratorio) {
        this.disponibilidade_laboratorio = disponibilidade_laboratorio;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", curso='" + curso + '\'' +
                ", turno_de_utilizacao='" + turno_de_utilizacao + '\'' +
                ", qualidade_laboratorio='" + qualidade_laboratorio + '\'' +
                ", disponibilidade_laboratorio='" + disponibilidade_laboratorio + '\'' +
                '}';
    }

}
