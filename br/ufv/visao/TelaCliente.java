/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.visao;
import br.ufv.controle.ControleCliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lázaro
 */
public class TelaCliente {
    private Scanner s;
    private ControleCliente controleCliente;
    
    public TelaCliente(){
        s = new Scanner(System.in);
        controleCliente = new ControleCliente();
    }
    
    public void telaInicial(){
        exibirMenu();
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
                    System.err.println("Opção inválida!");
            }
            exibirMenu();
            if(opc == 3)
                break;
        }
        
    }
    
    public void exibirMenu(){
        System.out.println("1- Inserir cliente");
        System.out.println("2- Listar clientes");
        System.out.println("3- Voltar");
        System.out.print("Digite: ");
    }
    
    public void telaInserir(){
        System.out.print("Nome: ");
        String nome = s.next();
        
        System.out.print("CPF: ");
        String cpf = s.next();
        
        System.out.print("Codigo: ");
        int codigo = s.nextInt();
        
        System.out.print("Email: ");
        String email = s.next();
        
        System.out.print("Senha: ");
        String senha = s.next();
        
        System.out.print("Qtd de enderecos: ");
        ArrayList<String>enderecos = new ArrayList<>();
        int qtd = s.nextInt();
        for(int i = 0; i < qtd; i++){
            System.out.print("Endereco "+(i+1)+": ");
            enderecos.add(s.next());
        }
        
        controleCliente.cadastraCliente(codigo, cpf, nome, email, senha, enderecos);
    }
    
    public void telaListar(){
        ArrayList<String> clientes = controleCliente.listarClientes();
        for(String s: clientes){
            System.out.println(s);
            System.out.println("----");
        }
    }
}
