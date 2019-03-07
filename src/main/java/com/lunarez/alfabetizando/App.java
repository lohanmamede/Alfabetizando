package com.lunarez.alfabetizando; // :D

import com.lunarez.alfabetizando.controller.Controllers;
import com.lunarez.alfabetizando.model.Usuario;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * Esta classe é o ponto de partida de toda a aplicação
 *
 * @author eres
 */
public class App extends Application {

    // ------------------------------------------------------------------ Campos
    /* Define o "palco" da aplicação */
    private static Stage baseStage;
    /* Define o usuário logado na sessão */
    private static Usuario sessao;
    

    // ------------------------------------------------------- Getters e Setters
    public static Stage getBaseStage() {

        return App.baseStage;
    }
    
    public static Usuario getSessao() {
        
        return App.sessao;
    }

    public static void setSessao(Usuario sessao) {
        
        App.sessao = sessao;
    }
    

    // ---------------------------------------------------------- Demais métodos
    /**
     * Este método inicia a aplicação
     *
     * @param stage "palco" onde as "cenas" (telas) serão exibidas
     * @throws java.lang.Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        /* Armazena o stage para ser manipulado por toda a aplicação */
        App.baseStage = stage;
        
        /* Define as dimensões mínimas da tela */
        App.baseStage.setMinWidth(1000);
        App.baseStage.setMinHeight(650);
        

        /* Define o ícone da aplicação */
        App.baseStage.getIcons().add(
                new Image(this.getClass().getResourceAsStream(
                "/com/lunarez/alfabetizando/images/jogos.png")));

        /* Define o título da aplicação */
        App.baseStage.setTitle("Alfabetizando");

        /* Define o FXML onde está estruturada a primeira tela da aplicação */
        Region region = FXMLLoader.load(this.getClass().getResource(
                "/com/lunarez/alfabetizando/view/TelaLogin.fxml"));

        /* Exibe a primeira tela da aplicação e se ela sera redimensionável */
        App.alternarTela(region, false);

        /* Retira o foco de elementos indesejados ao iniciar a tela, o colocando
        em um elemento "imperceptível". Isso não pode ser feito no método de 
        inicialização no controller da tela, deve ser feito após a tela já ter 
        sido completamente iniciada */
        Controllers.getTelaLoginController().getAnchorPane().requestFocus();
    }

    /**
     * Este método é responsável por realizar a navegação por telas da aplicação
     *
     * @param region indica a tela que será exibida
     * @param redimensionavel indica se a tela deve ou não ser redimensionável
     * @throws java.io.IOException
     */
    public static void alternarTela(Region region, boolean redimensionavel)
            throws IOException {

        /* Cria uma "cena" que será exibida no "palco" a partir da tela que foi
        passada como parâmetro */
        Scene scene = new Scene(region);

        /* Atribui a "cena" ao "palco" */
        App.baseStage.setScene(scene);

        /* Centraliza a tela */
        App.baseStage.centerOnScreen();

        /* Define se a tela será redimensionável */
        App.baseStage.setResizable(redimensionavel);

        /* Exibe a tela */
        App.baseStage.show();
    }

    /**
     * Este método torna a classe executável
     *
     * @param args https://goo.gl/vfH9bp
     */
    public static void main(String[] args) {

        App.launch(args);
    }
}
