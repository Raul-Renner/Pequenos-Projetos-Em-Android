package com.example.navegaoentretelas.model;

public class Medico {
    private String nome_completo;
    private String especialidade;
    private String areaAtuacao;
    private String CRM;
    public Medico(){}
    public Medico(String nome_completo,  String especialidade, String areaAtuacao, String CRM) {
        this.nome_completo = nome_completo;
        this.especialidade = especialidade;
        this.areaAtuacao = areaAtuacao;
        this.CRM = CRM;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    @Override
    public String toString() {
        return "Nome Completo: " + nome_completo + '\n' +
                "Especiaçozacao: " + especialidade + '\n' +
                "Area de Atuacao: " + areaAtuacao + '\n';
    }
}
