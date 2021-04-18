/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.visao;

import br.ufv.controle.ControleCliente;
import br.ufv.controle.ControleProduto;
import br.ufv.controle.ControleVenda;
import br.ufv.modelo.Cliente;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Lázaro
 */
public class TelaVenda {
    private Scanner s;
    private ControleVenda controleVenda;
    private ControleProduto controleProduto;
    private ControleCliente controleCliente;
   
    public TelaVenda(){
        s = new Scanner(System.in);
        controleVenda = new ControleVenda();   
        controleProduto = new ControleProduto();
    }
    
    
    public void telaInicial(){
        int opc;
        telaMenu();
        
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
                    System.err.println("Opcao invalida");
                    break;
            }
            if(opc == 3)
                break;
        }
    }
    
    public void telaMenu(){
        System.out.println("1- Inserir venda");
        System.out.println("2- Listar vendas");
        System.out.println("3- Voltar");
        System.out.print("Digite: ");
    }
    
    public void telaInserir(){
        System.out.print("Data: ");
        String data = s.next();
        
        System.out.print("Status: ");
        String status = s.next();
        
        System.out.print("Produtos: ");
        ArrayList<String> produtos = new ArrayList<>();
        int codigo = s.nextInt();
        System.out.println("-->Insira valor negativo para encerrar!");
        ArrayList<Integer> quantidades = new ArrayList<>();
        while(true){
            if(codigo < 0)
                break;
            String pExistente = controleProduto.pesquisaProduto(codigo);
            if(pExistente != null){
                produtos.add(pExistente);
                System.out.print("Quantidades: ");
                
                quantidades.add(s.nextInt());
            }else{
                System.err.println("Produto não existente!");
            }
            System.out.println("Codigo Produto: ");
            codigo = s.nextInt();
        }
        
        System.out.print("Codigo Cliente: ");
        codigo = s.nextInt();
        Cliente cliente = controleCliente.pesquisaCliente(codigo);
        
        System.out.print("Endereco de entrega: ");
        int end = s.nextInt();
        
        controleVenda.cadastraVenda(data, status, produtos, quantidades, cliente, end);
        
    }
    
    public void telaListar(){
        for(String venda: controleVenda.listarVendas()){
            System.out.println(venda);
            System.out.println("--------");
        }
        System.out.println("############");
    }
}
