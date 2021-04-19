/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;

import br.ufv.modelo.Cliente;
import br.ufv.modelo.Venda;
import br.ufv.modelo.persistencia.VendaDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author Lázaro
 */
public class ControleVenda {
  
    private VendaDAO vendaDAO;
    
    public ControleVenda(){
        vendaDAO = new VendaDAO();
    }
    
    public void cadastraVenda(String data, String status, ArrayList<String> produtos, ArrayList<Integer> quantidade, Cliente cliente, int endereco){
        Venda venda = new Venda(data, status, produtos, quantidade, cliente, endereco);
        //if(vendaDAO.validaQuantidade()){
            vendaDAO.cadastraVenda(venda);
       // }else{
       //     System.err.println("Erro ao cadastrar venda.");
       //     System.err.println("Verifique a quantidade de produtos disponiveis em estoque.");
       // }
    }
    
    public ArrayList<String> listarVendas(){
        ArrayList<Venda> vendas = vendaDAO.listarVendas();
        ArrayList<String> vendasStr = new ArrayList<>();
        
        for(Venda v: vendas){
            vendasStr.add(vendas.toString());
        }
        return vendasStr;
    }
    
    public ArrayList<String> listarVendasData(String inicio, String fim) throws ParseException{
        
        ArrayList<Venda> vendas = vendaDAO.listarVendas();
        ArrayList<String> vendasData = new ArrayList<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataIn = sdf.parse(inicio);
        Date dataFim = sdf.parse(fim);
        
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(dataIn);
        c2.setTime(dataFim);
        
        Calendar cVenda = Calendar.getInstance();
        for(Venda v: vendas){
            Date dataVenda = sdf.parse(v.getData());
            cVenda.setTime(dataVenda);
            if((cVenda.equals(c1) || cVenda.equals(c2)) || (cVenda.after(c1) && cVenda.before(c2))){
                vendasData.add(v.toString());
            }
        }
        return vendasData;
    }
    
    
}
