package com.example.listdadosmedico.medico.model;

public class Medico {
    private String nome;
    private String especialidade;
    private String area_atuacao;
    private String crm;

    public Medico(){}
    public Medico(String nome, String especialidade, String area_atuacao, String crm) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.area_atuacao = area_atuacao;
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getArea_atuacao() {
        return area_atuacao;
    }

    public void setArea_atuacao(String area_atuacao) {
        this.area_atuacao = area_atuacao;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + '\n' +
                "Especialidade: " + especialidade + '\n' +
                "Area atuação: " + area_atuacao + '\n' +
                "CRM: " + crm + '\n';
    }
}
