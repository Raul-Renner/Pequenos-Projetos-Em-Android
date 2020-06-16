package com.example.navegacaoentretelas_aula5.model;

public class Contato {
    private static int contador = 0;
    private int id_contato;
    private String nome;
    private String telefone;
    private String endereco;


    public Contato(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.id_contato = contador++;
    }

    public int getId_contato() {
        return id_contato;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "nome=" + nome + '\'' +
                "telefone=" + telefone + '\'' +
                "endereco=" + endereco + '\'' ;
    }
}
