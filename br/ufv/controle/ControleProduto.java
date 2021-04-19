/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;

import br.ufv.modelo.Produto;
import br.ufv.modelo.persistencia.ProdutoDAO;
import java.util.ArrayList;

/**
 *
 * @author Lázaro
 */
public class ControleProduto {
    ProdutoDAO produtoDAO;
    
    public ControleProduto(){
        produtoDAO = new ProdutoDAO();
    }
    
    public void cadastraProduto(int codigo, String descricao, int qtdEstoque, String categoria, double preco, String nome){
        Produto p = new Produto(codigo, descricao, qtdEstoque, categoria, preco, nome);
        System.out.println(p.toString());
        
        Produto pExistente = produtoDAO.pesquisaProduto(codigo);
        if(pExistente != null){
            System.err.println("Produto com código "+codigo+" já existe!");
        }else
            produtoDAO.cadastrarProduto(p);
    }
    
    public ArrayList<String> listarProdutos(){
        ArrayList<String> produtosStr = new ArrayList<>();
        ArrayList<Produto> produtos = produtoDAO.listarProdutos();
        
        for(Produto p: produtos){
            produtosStr.add(p.toString());
        }
        
        return produtosStr;
    }
  
    public String pesquisaProduto(int codigo){
        ArrayList<Produto> produtos = produtoDAO.listarProdutos();
        for(Produto p: produtos){
            if(p.getCodigo() == codigo)
                return p.toString();
        }
        return null;
    }
    
    public void alteraEstoque(int codigo, int qtd){
        produtoDAO.alteraEstoque(codigo, qtd);
    }
    
    public ArrayList<String> listarPorNome(String nome){
        ArrayList<Produto> produtos = produtoDAO.listarProdutos();
        ArrayList<String> produtosNome = new ArrayList<>();
        for(Produto p: produtos){
            if(p.getNome().equals(nome)){
                produtosNome.add(p.toString());
            }
        }
        return produtosNome;
    }
}
