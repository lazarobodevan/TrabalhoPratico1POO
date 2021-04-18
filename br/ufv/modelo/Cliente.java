/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.modelo;

import java.util.ArrayList;

/**
 *
 * @author Lázaro
 */
public class Cliente {
    private int codigo;
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private ArrayList<String> enderecos;
    
    public Cliente(int codigo, String cpf, String nome, String email, String senha, ArrayList<String>enderecos){
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.enderecos = enderecos;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public String getEndereco(int pos){
        return this.enderecos.get(pos);
    }
    
    @Override
    public String toString(){
        return "Nome "+this.nome+
                "\nCPF: "+this.cpf+
                "\nEmail: "+this.email+
                "\nCodigo: "+this.codigo;
    }
}
