/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.visao;
 import br.ufv.visao.*;
import java.util.Scanner;
/**
 *
 * @author Lázaro
 */
public class TelaGeral {
    private TelaCliente telaCliente;
    private TelaProduto telaProd;
    private TelaVenda telaVenda;
    private Scanner s;
    
    public TelaGeral(){
        telaCliente = new TelaCliente();
        telaProd = new TelaProduto();
        telaVenda = new TelaVenda();
        s = new Scanner(System.in);
    }
    
    public void telaGeral(){
        menu();
        int opc = s.nextInt();
        while(true){
            switch(opc){
                case 1:
                    telaProd.telaInicial();
                    break;
                case 2:
                    telaCliente.telaInicial();
                    break;
                case 3:
                    telaVenda.telaInicial();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Opcao invalida!");
            }
            menu();
            opc = s.nextInt();
        }
    }
    
    public void menu(){
        System.out.println("----MENU GERAL----");
        System.out.println("1- Produtos");
        System.out.println("2- Clientes");
        System.out.println("3- Vendas");
        System.out.println("4- Sair");
        System.out.print("Digite: ");
    }
}
