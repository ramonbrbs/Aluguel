package br.ufba.dcc.aluguel.Model;

import java.io.Serializable;

/**
 * Created by ASUS on 03/03/2017.
 */

public class Quarto implements Serializable{
    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return titulo + " - " + bairro;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    private int id;
    private String titulo;
    private String descricao;
    private String bairro;
    private float preco;

}
