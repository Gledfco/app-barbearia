/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import View.MenuPrincipal;
import app.barbearia.view.Login;
import model.Usuario;


/**
 *
 * @author Gledshow
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    
    public void entrarNoSistema(){
      
        //pegar um Usuario da View
        Usuario usuario = helper.obterModelo();
        
        
        // pesquisar Usuario no banco 
        UsuarioDAO usuarioDAO = new UsuarioDAO();
       Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
       
         
        // Se o usuario da view tiver o mesmo usuario e senha que o usuario que veio do banco direcionar para o menu 
        if(usuarioAutenticado != null){
            //navegar menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
            
        }else{
            view.exibeMensagem("Usuario ou senha inválidos");
        }
        
        //Senão, mostrar mensagem ao usuario  " Usuario ou senha invalidos"
      
          
        
        
        
        
        
    }
    
    
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        
        this.view.exibeMensagem("Executei o fiz tarefa");
        
        
    }
    
}
