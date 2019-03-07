package com.lunarez.alfabetizando.controller; // :D

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

/**
 * Esta classe controla a tela principal
 * 
 * @author eres
 */
public class TelaJogoCliqueNasLetrasInicioController implements Initializable {

    // ------------------------------------------------------------------ Campos
    @FXML
    private AnchorPane anchorPane;
    

    // ----------------------------------------------------------------- Métodos
    /**
     * Este método configura a inicialização do controller da tela ...
     *
     * @param url local do FXML da tela principal
     * @param rb contém dados específicos de certos idiomas
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /* Armazena a instancia desse controller, para que ele possa ser usado 
        nos controllers de outras telas */
        Controllers.setTelaJogoCliqueNasLetrasInicioController(this);
    }

    @FXML
    public void acionarBotaoNivel1() {
        
        try {

            /* Define o diretório do arquivo FXML referente a página inicial e 
            cria um Region a partir dela */
            Region region = FXMLLoader.load(this.getClass().getResource(
                    "/com/lunarez/alfabetizando/view/"
                            + "TelaJogoCliqueNasLetras.fxml"));
                    
            /* Faz com que o region se adapte totalmente as dimensões do 
            AnchorPane */
            AnchorPane.setTopAnchor(region, 0.0D);
            AnchorPane.setBottomAnchor(region, 0.0D);
            AnchorPane.setRightAnchor(region, 0.0D);
            AnchorPane.setLeftAnchor(region, 0.0D);

            /* Troca todo o conteúdo atual do AnchorPane pelo Region com a 
            tela */
            Controllers.getTelaPrincipalController().getAnchorPane()
                    .getChildren().setAll(region);
        } 
        catch (IOException ex) {

            Logger.getLogger(TelaJogoCliqueNasLetrasInicioController.class
                    .getName()).log(Level.SEVERE, null, ex);
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

            Logger.getLogger(TelaJogoCliqueNasLetrasInicioController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // ------------------------------------------------------- Getters e Setters
    public AnchorPane getAnchorPane() {
        
        return this.anchorPane;
    }
}
