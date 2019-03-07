package com.lunarez.alfabetizando.controller;

import com.lunarez.alfabetizando.App;
import com.lunarez.alfabetizando.dao.ImagemDAO;
import com.lunarez.alfabetizando.dao.JogoDAO;
import com.lunarez.alfabetizando.dao.NivelDAO;
import com.lunarez.alfabetizando.dao.UsuarioDAO;
import com.lunarez.alfabetizando.model.Imagem;
import com.lunarez.alfabetizando.model.Jogo;
import com.lunarez.alfabetizando.model.Nivel;
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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author eres
 */
public class TelaLoginController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField textFieldNome;
    @FXML
    private PasswordField passwordFieldSenha;
    @FXML
    private Label labelInformativa;
    @FXML
    private ProgressIndicator progresso;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Controllers.setTelaLoginController(this);
    }
    
    @FXML
    public void acionarBotaoEntrar() {
        
        if(textFieldNome.getText().equals("") || passwordFieldSenha.getText()
                .equals("")) {
            
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
        
            Usuario usuarioEncontrado = usuarioDAO.logar(usuario);
            
            if(usuarioEncontrado == null) {
            
                labelInformativa.setText("Email e/ou senha incorretos!");
                labelInformativa.setStyle("-fx-background-color: #ffcdd2;"
                        + "-fx-text-fill: #c62828;"
                        + "-fx-border-color: #ef5350;"
                        + "-fx-background-radius: 5;"
                        + "-fx-border-radius: 5;"
                        + "-fx-font-size: 13;"); 
            }
            else {
                
                this.alimentarBancoDeDados();

                try {
                    
                    App.setSessao(usuarioEncontrado);
                    
                    Region region = FXMLLoader.load(this.getClass().getResource(
                            "/com/lunarez/alfabetizando/view/"
                                    + "TelaPrincipal.fxml"));
                    
                    App.alternarTela(region, true);
                } 
                catch (IOException ex) {
                    
                    Logger.getLogger(TelaLoginController.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @FXML 
    public void acionarBotaoCriarUsuario() {
        
        try {
            
            Region region = FXMLLoader.load(this.getClass().getResource(
                    "/com/lunarez/alfabetizando/view/TelaCriarUsuario.fxml"));
            
            App.alternarTela(region, false);
            
            Controllers.getTelaCriarUsuarioController().getAnchorPane()
                    .requestFocus();
        } 
        catch (IOException ex) {
            
            Logger.getLogger(TelaLoginController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void acionarBotaoLogarComEludika() {
        
        try {
            
            Region region = FXMLLoader.load(this.getClass().getResource(
                    "/com/lunarez/alfabetizando/view/TelaLoginEludika.fxml"));
            
            App.alternarTela(region, false);
            
            Controllers.getTelaLoginEludikaController().getAnchorPane()
                    .requestFocus();
        } 
        catch (IOException ex) {
            
            Logger.getLogger(TelaLoginController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
    
    public AnchorPane getAnchorPane() {
        
        return this.anchorPane;
    }
    
    public void alimentarBancoDeDados() {

        Jogo jogo = new Jogo();
        JogoDAO jogoDAO = new JogoDAO();
        
        jogo.setIdDb(1L);
        jogo.setNome("Clique nas Letras");
        jogoDAO.salvarOuAtualizar(jogo);
        jogo.setIdDb(2L);
        jogo.setNome("Digite as Letras");
        jogoDAO.salvarOuAtualizar(jogo);
        jogo.setIdDb(3L);
        jogo.setNome("Digite a Palavra");
        jogoDAO.salvarOuAtualizar(jogo);
        jogo.setIdDb(4L);
        jogo.setNome("Selecione a Palavra");
        jogoDAO.salvarOuAtualizar(jogo);  
        
        Imagem imagem = new Imagem();
        ImagemDAO imagemDAO = new ImagemDAO();
        
        imagem.setIdDb(1L);
        imagem.setNome("Abacate");
        imagem.setCaminho("/com/lunarez/alfabetizando/imagens/jogos/"
                + "Abacate.png");
        imagemDAO.salvarOuAtualizar(imagem); 
        
        imagem.setIdDb(2L);
        imagem.setNome("Banana");
        imagem.setCaminho("/com/lunarez/alfabetizando/imagens/jogos/"
                + "Banana.png");
        imagemDAO.salvarOuAtualizar(imagem); 
        
        imagem.setIdDb(3L);
        imagem.setNome("Bolo");
        imagem.setCaminho("/com/lunarez/alfabetizando/imagens/jogos/Bolo.png");
        imagemDAO.salvarOuAtualizar(imagem); 
        
        imagem.setIdDb(4L);
        imagem.setNome("Boneca");
        imagem.setCaminho("/com/lunarez/alfabetizando/imagens/jogos/"
                + "Boneca.png");
        imagemDAO.salvarOuAtualizar(imagem); 
        
        imagem.setIdDb(5L);
        imagem.setNome("Casa");
        imagem.setCaminho("/com/lunarez/alfabetizando/imagens/jogos/Casa.png");
        imagemDAO.salvarOuAtualizar(imagem); 
        
        imagem.setIdDb(6L);
        imagem.setNome("Cavalo");
        imagem.setCaminho("/com/lunarez/alfabetizando/imagens/jogos/"
                + "Cavalo.png");
        imagemDAO.salvarOuAtualizar(imagem); 
        
        imagem.setIdDb(7L);
        imagem.setNome("Cenoura");
        imagem.setCaminho("/com/lunarez/alfabetizando/imagens/jogos/"
                + "Cenoura.png");
        imagemDAO.salvarOuAtualizar(imagem); 
        
        imagem.setIdDb(8L);
        imagem.setNome("Coelho");
        imagem.setCaminho("/com/lunarez/alfabetizando/imagens/jogos/"
                + "Coelho.png");
        imagemDAO.salvarOuAtualizar(imagem); 
        
        imagem.setIdDb(9L);
        imagem.setNome("Dado");
        imagem.setCaminho("/com/lunarez/alfabetizando/imagens/jogos/Dado.png");
        imagemDAO.salvarOuAtualizar(imagem); 
        
        imagem.setIdDb(10L);
        imagem.setNome("Girafa");
        imagem.setCaminho("/com/lunarez/alfabetizando/imagens/jogos/"
                + "Girafa.png");
        imagemDAO.salvarOuAtualizar(imagem); 
        
        Nivel nivel = new Nivel();
        NivelDAO nivelDAO = new NivelDAO();
        
        nivel.setIdDb(1L);
        nivel.setRodadas(10);
        nivelDAO.salvarOuAtualizar(nivel);  
    }
}
