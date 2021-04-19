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
import br.ufv.modelo.Produto;
import java.text.ParseException;
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
        controleCliente = new ControleCliente();
    }
    
    
    public void telaInicial() throws ParseException{
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
                    telaAtualizarStatus();
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Opcao invalida");
                    break;
            }
            if(opc == 4)
                break;
            telaMenu();
        }
    }
    
    public void telaMenu(){
        System.out.println("----MENU VENDA----");
        System.out.println("1- Inserir venda");
        System.out.println("2- Listar vendas");
        System.out.println("3- Atualizar status");
        System.out.println("4- Voltar");
        System.out.print("Digite: ");
    }
    
    public void telaInserir(){
        System.out.println("----INSERIR VENDA----");
        System.out.print("Codigo: ");
        int codCompra = s.nextInt();
        
        System.out.print("Data: ");
        String data = s.next();
        
        System.out.print("Status: ");
        String status = s.next();
        
        System.out.print("Produtos: ");
        ArrayList<String> produtos = new ArrayList<>();
        int codigo = s.nextInt();
        
        System.out.println("-->Insira valor negativo para encerrar!");
        ArrayList<Integer> quantidades = new ArrayList<>();
        double valorTotal = 0;
                
        while(true){
            if(codigo < 0)
                break;
            Produto pExistente = controleProduto.pesquisaProduto(codigo);
            if(pExistente != null){
                produtos.add(pExistente.toString());
                System.out.print("Quantidades: ");
                int qtd = s.nextInt();
                
                while(qtd > pExistente.getQtdEstoque()){
                    System.err.println("Quantidade indisponivel!");
                    System.err.println("Estoque: "+pExistente.getQtdEstoque());
                    System.out.print("Quantidades: ");
                    qtd = s.nextInt();
                }
                
                quantidades.add(qtd);
                controleProduto.alteraEstoque(codigo, pExistente.getQtdEstoque() - qtd);
                valorTotal += qtd * pExistente.getPreco();
            }else{
                System.err.println("Produto não existente!");
            }
            System.out.print("Codigo Produto: ");
            codigo = s.nextInt();
        }
        
        System.out.print("Codigo Cliente: ");
        codigo = s.nextInt();
        Cliente cExistente = controleCliente.pesquisaCliente(codigo);
        while(cExistente == null){
            System.err.println("Cliente não encontrado!");
            System.out.print("Codigo Cliente: ");
            codigo = s.nextInt();
            cExistente = controleCliente.pesquisaCliente(codigo);
        }
        
        System.out.print("Endereco de entrega: ");
        int end = s.nextInt();
        
        controleVenda.cadastraVenda(codCompra, data, status, produtos, quantidades, cExistente, end, valorTotal);
        System.out.println("----VENDA CADASTRADA----");
        
    }
    
    public void telaListar() throws ParseException{
        System.out.println("----LISTAR VENDAS----");
        System.out.println("1- Listar todas");
        System.out.println("2- Filtrar por data");
        System.out.print("Digite: ");
        int opc = s.nextInt();
        
        switch(opc){
            case 1:
                ArrayList<String> vendas = controleVenda.listarVendas();
                for(String venda: vendas){
                    System.out.println(venda);
                    System.out.println("--------");
                }
                System.out.println("############");
                break;
            
            case 2:
                System.out.print("Data inicio: ");
                String dtI = s.next();
                System.out.print("Data fim: ");
                String dtF = s.next();
                ArrayList<String> vendasData = controleVenda.listarVendasData(dtI, dtF);
                System.out.println("--------");
                for(String s: vendasData){
                    System.out.println(s);
                    System.out.println("----");
                }
                System.out.println("--------");
                break;
            default:
                System.err.println("Opção inválida!");
                break;
        }
    }
    
    public void telaAtualizarStatus(){
        System.out.print("Codigo: ");
        int codigo = s.nextInt();
        System.out.print("Novo status: ");
        String status = s.next();
        controleVenda.atualizaStatusVenda(codigo, status);
    }
}
