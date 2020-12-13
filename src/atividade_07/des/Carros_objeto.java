/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade_07.des;

/**
 *
 * @author Igor Almeida
 */
public class Carros_objeto {
    private String placa;
    private String cor;
    private String descricao;

    public Carros_objeto(String placa, String cor, String descricao) {
        this.placa = placa;
        this.cor = cor;
        this.descricao = descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Carros_objeto() {
    }
}
