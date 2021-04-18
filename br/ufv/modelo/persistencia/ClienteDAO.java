/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.modelo.persistencia;

import br.ufv.modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Lázaro
 */
public class ClienteDAO {
    
    private static ArrayList<Cliente> clientes;
    
    public ClienteDAO(){
        clientes = new ArrayList<>();
    }
    
    public void cadastraCliente(Cliente c){
        clientes.add(c);
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("Total de clientes: "+clientes.size());
    }
    
    public Cliente pesquisaCliente(int codigo, String cpf, String email){
        for(Cliente c: clientes){
            if(c.getCodigo() == codigo || c.getCpf().equals(cpf) || c.getEmail().equals(email)){
                return c;
            }
        }
        return null;
    }
    
    public static ArrayList<Cliente> listarClientes(){
        return clientes;
    }
    
    public static Cliente pesquisaClienteCodigo(int codigo){
        for(Cliente c: clientes){
            if(c.getCodigo() == codigo)
                return c;
        }
        return null;
    }
    
    public void alteraDadosCliente(int codigo, String cpf, String nome, String email, String senha, ArrayList<String>enderecos){
        for(Cliente c: clientes){
            if(c.getCodigo() == codigo){
                c.setCpf(cpf);
                c.setEmail(email);
                c.setEnderecos(enderecos);
                c.setNome(nome);
                c.setSenha(senha);
                System.out.println("----ATUALIZADO----");
            }else
                System.err.println("Cliente não encontrado");
        }
    }
}
