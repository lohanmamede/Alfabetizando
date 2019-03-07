package com.lunarez.alfabetizando.controller; // :D

import com.lunarez.alfabetizando.App;
import com.lunarez.alfabetizando.ews.response.AutenticacaoResponseModel;
import static com.lunarez.alfabetizando.ews.response.AutenticacaoResponseModel.getSessao;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;

/**
 * Esta classe controla a tela principal
 * 
 * @author eres
 */
public class TelaPrincipalController extends ControllerEludika implements Initializable {

    // ------------------------------------------------------------------ Campos
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label labelUsuario;
    

    // ----------------------------------------------------------------- Métodos
    /**
     * Este método configura a inicialização do controller da tela principal
     *
     * @param url local do FXML da tela principal
     * @param rb contém dados específicos de certos idiomas
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /* Armazena a instancia desse controller, para que ele possa ser usado 
        nos controllers de outras telas */
        Controllers.setTelaPrincipalController(this);
        
        labelUsuario.setText(getSessao().getCodinome());
        
        if(getSessao().getCodinome() == null || getSessao().getCodinome().isEmpty()) {
        
            labelUsuario.setText(App.getSessao().getNome());
        }

        /* Chama uma tela de apresentação para compor a tela principal */
        chamarTelaInicial();
    }

    /**
     * Este método cria um Region com a tela inicial e o "encaixa" no AnchorPane
     * reservado na tela principal
     */
    @FXML
    public void chamarTelaInicial() {

        try {

            /* Define o diretório do arquivo FXML referente à tela inicial e 
            cria um Region a partir dele */
            Region region = (AnchorPane) FXMLLoader.load(getClass().getResource(
                    "/com/lunarez/alfabetizando/view/TelaPaginaInicial.fxml"));

            /* Faz com que o region se adapte totalmente as dimensões do 
            AnchorPane */
            AnchorPane.setTopAnchor(region, 0.0D);
            AnchorPane.setBottomAnchor(region, 0.0D);
            AnchorPane.setRightAnchor(region, 0.0D);
            AnchorPane.setLeftAnchor(region, 0.0D);

            /* Troca todo o conteúdo atual do AnchorPane pelo Region com a 
            tela */
            this.anchorPane.getChildren().setAll(region);
        } 
        catch (IOException ex) {

            Logger.getLogger(TelaPrincipalController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void acionarBotaoPaginaInicial() {
        
        try {

            /* Define o diretório do arquivo FXML referente a página inicial e 
            cria um Region a partir dela */
            Region region = FXMLLoader.load(getClass().getResource(
                    "/com/lunarez/alfabetizando/view/TelaPaginaInicial.fxml"));
                    
            /* Faz com que o region se adapte totalmente as dimensões do 
            AnchorPane */
            AnchorPane.setTopAnchor(region, 0.0D);
            AnchorPane.setBottomAnchor(region, 0.0D);
            AnchorPane.setRightAnchor(region, 0.0D);
            AnchorPane.setLeftAnchor(region, 0.0D);

            /* Troca todo o conteúdo atual do AnchorPane pelo Region com a 
            tela */
            this.anchorPane.getChildren().setAll(region);
        } 
        catch (IOException ex) {

            Logger.getLogger(TelaJogoCliqueNasLetrasController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este método define o que deve acontecer quando o botão referente ao jogo
     * Clique nas Letras da tela principal for clicado. É criado um Region com 
     * a tela do jogo, que é encaixado no AnchorPane reservado na tela principal
     */
    @FXML
    public void acionarBotaoJogoCliqueNasLetras() {

        try {

            /* Define o diretório do arquivo FXML referente ao jogo e cria um 
            Region a partir dele */
            Region region = FXMLLoader.load(getClass().getResource(
                    "/com/lunarez/alfabetizando/view/"
                            + "TelaJogoCliqueNasLetrasInicio.fxml"));
                    
            /* Faz com que o region se adapte totalmente as dimensões do 
            AnchorPane */
            AnchorPane.setTopAnchor(region, 0.0D);
            AnchorPane.setBottomAnchor(region, 0.0D);
            AnchorPane.setRightAnchor(region, 0.0D);
            AnchorPane.setLeftAnchor(region, 0.0D);

            /* Troca todo o conteúdo atual do AnchorPane pelo Region com a 
            tela */
            this.anchorPane.getChildren().setAll(region);
        } 
        catch (IOException ex) {

            Logger.getLogger(TelaJogoCliqueNasLetrasController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void deslogar() {
        
        Alert alerta = new Alert(CONFIRMATION);
        alerta.setTitle("Eludika");
        alerta.setHeaderText("Deslogar-se");
        alerta.setContentText("Você tem certeza que deseja sair?");
        
        alerta.initModality(Modality.WINDOW_MODAL);

        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if (resultado.get() == ButtonType.OK) {
            
            try {

                Region region = FXMLLoader.load(this.getClass().getResource(
                            "/com/lunarez/alfabetizando/view/TelaLogin.fxml"));
                    
                    App.alternarTela(region, true);
            } 
            catch (IOException ex) {

                Logger.getLogger(TelaPrincipalController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            
            /* Desvinculação das credenciais do usuário atual da sessão */
            AutenticacaoResponseModel.getSessao().setIdExterno(null);
            AutenticacaoResponseModel.getSessao().setToken(null);

            /* Retirada do foco dos campos ao voltar na tela */
            Controllers.getTelaLoginController().getAnchorPane().requestFocus();
        } 
    }
    
    
    // ------------------------------------------------------- Getters e Setters
    public AnchorPane getAnchorPane() {
        
        return this.anchorPane;
    }
}
