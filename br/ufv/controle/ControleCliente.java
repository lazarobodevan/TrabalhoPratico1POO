/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;

import br.ufv.modelo.Cliente;
import br.ufv.modelo.persistencia.ClienteDAO;
import java.util.ArrayList;

/**
 *
 * @author Lázaro
 */
public class ControleCliente{
    private ClienteDAO clienteDAO;
    
    public ControleCliente(){
        clienteDAO = new ClienteDAO();
    }
    
    public void cadastraCliente(int codigo, String cpf, String nome, String email, String senha, ArrayList<String>enderecos){
        Cliente c = new Cliente(codigo, cpf, nome, email, senha, enderecos);
        System.out.println(c.toString());
        
        Cliente cExistente = clienteDAO.pesquisaCliente(codigo, cpf, email);
        if(cExistente != null){
            System.err.println("Dado(s) duplicados!");
        }else
            clienteDAO.cadastraCliente(c);
    }
    
    public ArrayList<String> listarClientes(){
        ArrayList<Cliente> clientes = clienteDAO.listarClientes();
        ArrayList<String> clientesStr = new ArrayList<>();
        
        for(Cliente c: clientes){
            clientesStr.add(c.toString());
        }
        
        return clientesStr;
    }
    
    public Cliente pesquisaCliente(int codigo){
        ArrayList<Cliente> clientes = clienteDAO.listarClientes();
        for(Cliente c: clientes){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        return null;
    }
    
    public void alteraDadosCliente(int codigo, String cpf, String nome, String email, String senha, ArrayList<String>enderecos){
        clienteDAO.alteraDadosCliente(codigo, cpf, nome, email, senha, enderecos);
    }
}
