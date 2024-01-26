package com.ricardo.entidades;

public class Endereco {

    private String rua, cidade, uf;
    private int numero, cep;

    public void setEnderco(String rua, String cidade, String uf, int numero, int cep){
        this.rua = rua;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
        this.cep = cep;
    }

    public void setEnderco(String rua, String cidade, String uf, int numero){
        this.rua = rua;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;       
    }

    public void setEnderco(String rua, String cidade, int numero){
        this.rua = rua;
        this.cidade = cidade;       
        this.numero = numero;    

    }   
    
    public Endereco getRua() {
        return this;
    }

    public Endereco getCidade() {
        return this;
    }

    public Endereco getUf() {
        return this;
    }
    public Endereco getNumero() {
        return this;
    }
    
    public Endereco getCep() {
        return this;
    }

}
