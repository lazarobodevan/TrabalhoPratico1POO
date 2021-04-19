/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.modelo;

import br.ufv.modelo.Cliente;
import br.ufv.modelo.Produto;
import java.util.ArrayList;

/**
 *
 * @author Lázaro
 */
public class Venda {
    private String data;
    private String status;
    private ArrayList<String> produtos;
    private ArrayList<Integer> quantidades;
    private Cliente cliente;
    private int endereco;
    private int codigo;
    private double valorTotal;
    
    public Venda(int codigo, String data, String status, ArrayList<String> produtos, ArrayList<Integer> quantidades, Cliente cliente, int endereco, double valorTotal){
        this.codigo = codigo;
        this.data = data;
        this.status = status;
        this.produtos = produtos;
        this.quantidades = quantidades;
        this.cliente = cliente;
        this.endereco = endereco;
        this.valorTotal = valorTotal;
    }
    
    public ArrayList<String> getProdutos(){
        return this.produtos;
    }
    
    public ArrayList<Integer> getQuantidades(){
        return this.quantidades;
    }
    
    public String getData(){
        return this.data;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public double getValorTotal(){
        return this.valorTotal;
    }
        
    @Override
    public String toString(){
        return "Data:" + this.data +
                "\nStatus: "+ this.status +
                "\nProdutos " + this.produtos +
                "\nSatus: "+this.status+
                "\nQuantidade: "+this.quantidades+
                "\nEndereço: "+this.cliente.getEndereco(endereco-1)+
                "\nValor total: "+this.valorTotal;
    }
}
