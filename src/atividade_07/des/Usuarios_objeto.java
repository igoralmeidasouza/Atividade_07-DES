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
public class Usuarios_objeto {
    private String CPF;
    private String Nome;
    private String Tipo;
    private String email;
    private String login;
    private String senha;
    private String telefone;
    private String validar;

    public Usuarios_objeto(String CPF, String Nome, String Tipo, String email, String login, String senha, String telefone, String validar) {
        this.CPF = CPF;
        this.Nome = Nome;
        this.Tipo = Tipo;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.validar = validar;
    }
    
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getValidar() {
        return validar;
    }

    public void setValidar(String validar) {
        this.validar = validar;
    }

    public Usuarios_objeto() {
    }
}
