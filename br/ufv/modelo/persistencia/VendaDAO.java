/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.modelo.persistencia;

import br.ufv.modelo.Venda;
import br.ufv.modelo.Produto;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lázaro
 */
public class VendaDAO {
    private Scanner s;
    private static ArrayList<Venda> vendas;
    
    public VendaDAO(){
        s = new Scanner(System.in);
        vendas = new ArrayList<>();
    }
    
    public void cadastraVenda(Venda v){
        vendas.add(v);
        System.out.println("Venda cadastrada com sucesso!");
    }
    
    /*
    public boolean validaQuantidade(){
        for(Venda v: vendas){
            for(int i = 0; i < v.getProdutos().size(); i++){
                if(v.getQuantidades().get(i) > v.getProdutos().get(i).getQtdEstoque()){
                    //se a quantidade a ser comprada for maior que a quantidade em estoque
                    return false;
                }
            }
        }
        return true; //quantidades condizentes com as disponiveis
    }
    */
    public static ArrayList<Venda> listarVendas(){
        return vendas;
    }
    /*
    public void atualizaStatusVenda(int codigo){
        for(Venda v: vendas){
            if(v.)
        }

    }
    */

}
