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
    
    public Venda(String data, String status, ArrayList<String> produtos, ArrayList<Integer> quantidades, Cliente cliente, int endereco){
        this.data = data;
        this.status = status;
        this.produtos = produtos;
        this.quantidades = quantidades;
        this.cliente = cliente;
        this.endereco = endereco;
    }
    
    public ArrayList<String> getProdutos(){
        return this.produtos;
    }
    
    public ArrayList<Integer> getQuantidades(){
        return this.quantidades;
    }
    
    @Override
    public String toString(){
        return "Data:" + this.data +
                "\nStatus: "+ this.status +
                "\nProdutos " + this.produtos +
                "\nSatus: "+this.status+
                "\nQuantidade: "+this.quantidades+
                "\nEndereço: "+this.cliente.getEndereco(endereco);
    }
}
