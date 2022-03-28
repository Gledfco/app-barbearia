/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;

import Controller.helper.AgendaHelper;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import View.Agenda;
import model.Agendamento;
import model.Cliente;
import model.Servico;

/**
 *
 * @author Gledshow
 */
public class AgendaController {

private final Agenda view;
private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }

  public void atualizaTabela(){
      //Buscar uma lista com os agendamentos do banco 
      AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
    ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
    
    //exibir essa lista na view
    helper.preencherTabela(agendamentos);
    
  }

  public void atualizaCliente(){
      //buscar clientes no banco de dados
      ClienteDAO clienteDAO = new ClienteDAO();
    ArrayList<Cliente> clientes = clienteDAO.selectAll();
    
    // exibir clientes no ComboBox cliente
   helper.preencherClientes(clientes);   
      
  }
    
 public void atualizaServico(){
     
     ServicoDAO servicoDAO = new ServicoDAO();
    ArrayList<Servico> servicos = servicoDAO.selectAll();
     helper.preencherServicos(servicos);
     
     
 }
  
 public void atualizaValor(){
     
     Servico servico = helper.obterServico();
     helper.setarValor(servico.getValor());
     
 }
 
 public void agendar(){
     
     //Buscar Objeto Agendamento da Tela
     Agendamento agendamento = helper.obterModelo();
     
     //Salvar objeto no banco de dados
     new AgendamentoDAO().insert(agendamento);
     atualizaTabela();
     helper.limparTela();
 }
 
 
}
