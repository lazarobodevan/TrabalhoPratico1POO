/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.visao;
import br.ufv.controle.ControleProduto;
import br.ufv.modelo.persistencia.ProdutoDAO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lázaro
 */
public class TelaProduto {
    
    private Scanner s;
    private ControleProduto controleProduto;
    
    public TelaProduto(){
        s = new Scanner(System.in);
        controleProduto = new ControleProduto();
    }
    
    public void telaInicial(){
        ExibirMenu();
        int opc;
        while(true){
            opc = s.nextInt();
            switch(opc){
                case 1:
                    telaInserir();
                    break;
                case 2:
                    telaListar();
                    break;
                case 3:
                    //System.exit(0);
                    break;
                default:
                    System.err.println("Opcao invalida!");
            }
            ExibirMenu();
            if(opc == 3)
                break;
        }
    }
    
    public void ExibirMenu(){
        System.out.println("1- Inserir produto");
        System.out.println("2- Listar produtos");
        System.out.println("3- Voltar");
        System.out.print("Digite: ");
    }
    
    public void telaInserir(){
        System.out.println("----INSERIR PRODUTO----");
        System.out.print("Nome: ");
        String nome = s.next();
        
        System.out.print("Codigo: ");
        int codigo = s.nextInt();
       
        System.out.print("Descricao: ");
        String desc = s.next();
        
        System.out.print("Qtd estoque: ");
        int qtdEstoque = s.nextInt();
       
        System.out.print("Categoria: ");
        String categoria = s.next();
        
        System.out.print("Preço: ");
        double preco = s.nextDouble();
        
        controleProduto.cadastraProduto(codigo, desc, qtdEstoque, categoria, preco, nome);
    }
    
    public void telaListar(){
        ArrayList<String> produtos = controleProduto.listarProdutos();
        System.out.println("----LISTAR PRODUTOS----");
        for(String s: produtos){
            System.out.println(s);
            System.out.println("----");
        }
        System.out.println("-------------");
    }
}
