package com.lunarez.alfabetizando.controller;

import com.lunarez.alfabetizando.App;
import com.lunarez.alfabetizando.dao.ImagemDAO;
import com.lunarez.alfabetizando.dao.JogoDAO;
import com.lunarez.alfabetizando.dao.NivelDAO;
import com.lunarez.alfabetizando.ews.AutenticacaoEWS;
import com.lunarez.alfabetizando.model.Imagem;
import com.lunarez.alfabetizando.model.Jogo;
import com.lunarez.alfabetizando.model.Nivel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import static javafx.scene.control.Alert.AlertType.INFORMATION;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * FXML Controller class
 *
 * @author eres
 */
public class TelaLoginEludikaController extends ControllerEludika implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    TextField textFieldEmail;
    
    @FXML
    PasswordField passwordFieldSenha;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Controllers.setTelaLoginEludikaController(this);
        // TODO
    }   
    
    /** Método que lida com o botão de autenticação da tela de login */
    @FXML
    public void handleButtonEntrar() {

        try {
            
            this.alimentarBancoDeDados();
            
            /* Criação da variável que lida com as requisições relacionadas ao usuário */
            AutenticacaoEWS autenticacaoEWS = new AutenticacaoEWS();
            
            /* Requisição do serviço de login ao webservice */
            autenticacaoEWS.autenticar(this.textFieldEmail.getText(), this.passwordFieldSenha.getText());
            
            super.alternarParaTela("/com/lunarez/alfabetizando/view/TelaPrincipal.fxml", true, 1000, 680);
        }
        catch(HttpStatusCodeException excecaoDoWebService) {
 
            super.mostrarAlertaDoWebService(INFORMATION, "Eludika",
                    "Falha ao logar", excecaoDoWebService.getResponseBodyAsByteArray());

            /* Evita o foco em elementos indesejados ao especificar o elemento a focar */
            this.anchorPane.requestFocus();
        }
        catch(Exception exceptionGenerica) {
            
            super.mostrarAlerta(INFORMATION, "Eludika",
                    "Falha ao logar", "Tente novamente em alguns instantes");
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
            
            Logger.getLogger(TelaLoginEludikaController.class.getName())
                    .log(Level.SEVERE, null, ex);
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
