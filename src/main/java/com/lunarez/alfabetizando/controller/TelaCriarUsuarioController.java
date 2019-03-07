package com.lunarez.alfabetizando.controller;

import com.lunarez.alfabetizando.App;
import com.lunarez.alfabetizando.dao.UsuarioDAO;
import com.lunarez.alfabetizando.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author eres
 */
public class TelaCriarUsuarioController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField textFieldNome;
    @FXML
    private PasswordField passwordFieldSenha;
    @FXML
    private Label labelInformativa;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Controllers.setTelaCriarUsuarioController(this);
    }    
   
    @FXML
    public void acionarBotaoCriar() {
        
        if(textFieldNome.getText().equals("") || 
                passwordFieldSenha.getText().equals("")) {
            
            labelInformativa.setText("Não pode haver campos em branco!");
            labelInformativa.setStyle("-fx-background-color: #f0f4c3;"
                    + "-fx-text-fill: #9e9d24;"
                    + "-fx-border-color: #d4e157;"
                    + "-fx-background-radius: 5;"
                    + "-fx-border-radius: 5;"
                    + "-fx-font-size: 13;");  
        } 
        else {
            
            Usuario usuario = new Usuario();
        
            usuario.setNome(textFieldNome.getText());
            usuario.setSenha(passwordFieldSenha.getText());
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            if(usuarioDAO.buscarPorNome(usuario) != null) {
            
                labelInformativa.setText("Usuário já existe!");
                labelInformativa.setStyle("-fx-background-color: #ffcdd2;"
                        + "-fx-text-fill: #c62828;"
                        + "-fx-border-color: #ef5350;"
                        + "-fx-background-radius: 5;"
                        + "-fx-border-radius: 5;"
                        + "-fx-font-size: 13;"); 
            }
            else {
                
                usuarioDAO.salvar(usuario);    
                
                textFieldNome.setText("");
                passwordFieldSenha.setText("");
                
                labelInformativa.setText("Sucesso, volte para logar!");
                labelInformativa.setStyle("-fx-background-color: #c8e6c9;"
                        + "-fx-text-fill: #2e7d32;"
                        + "-fx-border-color: #2e7d32;"
                        + "-fx-background-radius: 5;"
                        + "-fx-border-radius: 5;"
                        + "-fx-font-size: 13;"); 
           }    
        } 
    }
    
    @FXML
    public void acionarBotaoVoltar() {
        
        try {
            
            Region region = FXMLLoader.load(this.getClass().getResource(
                    "/com/lunarez/alfabetizando/view/TelaLogin.fxml"));
            
            App.alternarTela(region, false);
        } 
        catch (IOException ex) {
            
            Logger.getLogger(TelaCriarUsuarioController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    
    public AnchorPane getAnchorPane() {
        
        return this.anchorPane;
    }
}
