/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.modelo;

/**
 *
 * @author Lázaro
 */
public class Produto {
    private int codigo;
    private String descricao;
    private int qtdEstoque;
    private String categoria;
    private double preco;
    private String nome;

    public Produto(int codigo, String descricao, int qtdEstoque, String categoria, double preco, String nome) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.categoria = categoria;
        this.preco = preco;
        this.nome = nome;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setCodigo(int qtd){
        this.qtdEstoque = qtd;
    }
    
    public int getQtdEstoque(){
        return this.qtdEstoque;
    }
    
    /*
    public void cadastraProduto(int codigo, String descricao, int qtdEstoque, String categoria, double preco, String nome){
        Produto p = new Produto(codigo, descricao, qtdEstoque, categoria, preco, nome);
        System.out.println("Cadastrado com sucesso!\n"+p.toString());
    }
    */
    @Override
    public String toString(){
        return"Produto: "+this.nome
                +"\nCategoria: "+this.categoria
                +"\nPreço: "+this.preco
                +"\nEstoque: " +this.qtdEstoque
                +"\nCodigo: "+this.codigo;
    }
}
