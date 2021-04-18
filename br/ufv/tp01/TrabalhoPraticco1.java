/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.tp01;
import br.ufv.modelo.Produto;
import br.ufv.tp01.TrabalhoPraticco1;
import br.ufv.visao.TelaProduto;
import br.ufv.visao.TelaCliente;
import br.ufv.visao.TelaVenda;
import br.ufv.visao.TelaGeral;
/**
 *
 * @author Lázaro
 */
public class TrabalhoPraticco1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        /*
       TelaProduto telaProd = new TelaProduto();
       telaProd.telaInicial();
 
       TelaCliente telaClie = new TelaCliente();
       telaClie.telaInicial();

       TelaVenda telaVenda = new TelaVenda();
       telaVenda.telaInicial();
       */
        
        TelaGeral telaGeral = new TelaGeral();
        telaGeral.telaGeral();
       
    }
    
}
