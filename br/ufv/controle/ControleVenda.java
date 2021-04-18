/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;

import br.ufv.modelo.Cliente;
import br.ufv.modelo.Produto;
import br.ufv.modelo.Venda;
import java.util.Scanner;
import br.ufv.modelo.persistencia.VendaDAO;
import java.util.ArrayList;
/**
 *
 * @author Lázaro
 */
public class ControleVenda {
  
    private VendaDAO vendaDAO;
    
    public ControleVenda(){
        vendaDAO = new VendaDAO();
    }
    
    public void cadastraVenda(String data, String status, ArrayList<String> produtos, ArrayList<Integer> quantidade, Cliente cliente, int endereco){
        Venda venda = new Venda(data, status, produtos, quantidade, cliente, endereco);
        if(vendaDAO.validaQuantidade()){
            vendaDAO.cadastraVenda(venda);
        }else{
            System.err.println("Erro ao cadastrar venda.");
            System.err.println("Verifique a quantidade de produtos disponiveis em estoque.");
        }
    }
    
    public ArrayList<String> listarVendas(){
        ArrayList<Venda> vendas = vendaDAO.listarVendas();
        ArrayList<String> vendasStr = new ArrayList<>();
        
        for(Venda v: vendas){
            vendasStr.add(vendas.toString());
        }
        return vendasStr;
    }
    
    
}
