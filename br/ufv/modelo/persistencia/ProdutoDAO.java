/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.modelo.persistencia;

import br.ufv.modelo.Produto;
import java.util.ArrayList;

/**
 *
 * @author Lázaro
 */
public class ProdutoDAO {
    private static ArrayList<Produto> produtos;    
    
    public ProdutoDAO(){
        produtos = new ArrayList<>();
    }
    
    public void cadastrarProduto(Produto p){
        produtos.add(p);
        System.out.println("Produto Inserido com sucesso!");
        System.out.println("Total de produtos: "+produtos.size());
    }
    
    public Produto pesquisaProduto(int codigo){
        for(Produto p : produtos){
            if(p.getCodigo() == codigo){
                return p;
            }
        }
        return null;
    }
    
    public static ArrayList<Produto> listarProdutos(){
        return produtos;
    }
    
    public void alteraEstoque(int codigo, int qtd){
        for(Produto p: produtos){
            if(p.getCodigo() == codigo){
                p.setEstoque(qtd);
                System.out.println("Estoque alterado!");
                return;
            }else
                System.err.println("Produto nao encontrado!");
        }
    }
}
