/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.barbearia.view;

import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Usuario;

/**
 *
 * @author Gledshow
 */
public class MainTeste {
    
    
    public static void main(String[] args) {
        
        Servico servico = new Servico(1,"barba",30);
       
        
        Cliente cliente = new Cliente(1, "Joao", "Rua teste", "063454-545");
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario(2,"Maria","teste");
        System.out.println(usuario.getNome()); 
        
       Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "31/03/2022 12:35");
        
        System.out.println(agendamento.getCliente().getNome());
       
    }
    
    
}
