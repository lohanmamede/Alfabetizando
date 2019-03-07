package com.lunarez.alfabetizando.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lunarez.alfabetizando.App;
import com.lunarez.alfabetizando.ews.response.ExceptionResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import static javafx.scene.control.Alert.AlertType.INFORMATION;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.stage.Modality;

/**
 * Classe quem contém métodos úteis compartilhados entre as classes Controllers
 *
 * @author eres
 */
public class ControllerEludika {
  
    static String servicoDesejado;

    /**
     * Método responsável por gerenciar todas as telas da aplicação
     *
     * @param fxml indica a tela que será exibida
     * @param redimensionavel indica se a tela deve ou não ser redimensionável
     * @param largura a largura do stage
     * @param altura a altura do stage
     */
    public void alternarParaTela(String fxml, boolean redimensionavel, 
            double largura, double altura) {
        
        try {
            
            Region region = FXMLLoader.load(getClass().
                    getResource(fxml));
            
            /* Ocultamento do stage, para realização de configurações */
            App.getBaseStage().close();
            
            App.getBaseStage().setMaximized(false);
            
            /* Definição da altura e da largura da tela */
            App.getBaseStage().setWidth(largura);
            App.getBaseStage().setHeight(altura);
            
            /* Centraliza a tela */
            App.getBaseStage().centerOnScreen();
            
            /* Define se a tela será redimensionável */
            App.getBaseStage().setResizable(redimensionavel);
            
            /* Redefinição da altura e da largura da tela para evitar bugs de
            redimensionamento */
            App.getBaseStage().setWidth(largura);
            App.getBaseStage().setHeight(altura);
            
            /* Cria uma "cena" que será exibida no "palco" a partir da tela que foi
            passada como parâmetro */
            Scene scene = new Scene(region);
            
            scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Nunito");
            
            /* Atribui a "cena" ao "palco" */
            App.getBaseStage().setScene(scene);
            
            /* Exibe a tela */ 
            App.getBaseStage().show();
        } 
        catch (IOException ex) {
            
            //...
        }
    }

    public FXMLLoader chamarTelaInterna(String fxml, Pane panePai, ScrollPane paneConteudo, Pane paneSombra) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        
        try {
            
            /* O Pane pai possui um Pane para exibição de conteúdo e um Pane para
            sombrear o conteúdo quando houver um popup aberto, se houver um 
            terceiro elemento, certamente é um popup, então antes de exibir o novo
            conteúdo, é necessário tornar o Pane com sombra invisível e remover o popup */
            if(panePai.getChildren().size() > 2) {
            
                paneSombra.setVisible(false);
                
                panePai.getChildren().remove(2);
            }

            /* Cria um Region com o arquivo FXML que representa a tela, e exibe 
            o seu conteúdo */
            Region region = loader.load();
            
            paneConteudo.setVvalue(0);

            paneConteudo.setContent(region);
        }
        catch(IOException exception) {
            
            //...
        }  
        
        return loader;
    }
    
    public void chamarTelaInterna(String fxml, ScrollPane paneConteudo) {
        
        try {

            /* Cria um Region com o arquivo FXML que representa a tela, e exibe 
            o seu conteúdo */
            Region region = FXMLLoader.load(getClass().getResource(fxml));
            
            paneConteudo.setVvalue(0);

            paneConteudo.setContent(region);
        }
        catch(IOException exception) {
            
            //...
        }        
    }
    
    public void inserirConteudo(String fxml, VBox vBox, ScrollPane paneConteudo, 
            boolean retornarAoTopo) {
       
        if(paneConteudo != null && retornarAoTopo == true) {
            
            paneConteudo.setVvalue(0);
        }
        
        try {
            
            Region region = FXMLLoader.load(getClass().getResource(fxml));
        
            vBox.getChildren().add(region);
        }
        catch(IOException exception) {
            
            //...
        }        
    }
    
    public void exibirPopUp(String fxml, Pane paneConteudo, Pane paneSombra) {
        
        try {
        
            Region region = FXMLLoader.load(this.getClass().getResource(fxml));

            paneConteudo.getChildren().add(region);
            
            paneSombra.setVisible(true);
        }
        catch(IOException exception) {
            
            System.out.println("Erro: " + exception.toString());
        }        
    }
    
    public void mostrarAlerta(AlertType tipoDoAlerta, String titulo, String cabecalho, String conteudo) {
        
        Alert alert = new Alert(tipoDoAlerta, conteudo);
        alert.setAlertType(tipoDoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.initModality(Modality.WINDOW_MODAL);
        alert.showAndWait(); 
    }
    
    public void mostrarAlertaDoWebService(AlertType tipoDoAlerta, 
            String titulo, String cabecalho, byte[] conteudo) {
        
        /* Extração da mensagem de erro do corpo da resposta */
        String resposta = new String(conteudo);
        
        /* Método onde se obtém valor por valor */
        // JSONObject json = new JSONObject(resposta);
        // String mensagemDeErro = (String) json.get("mensagemDeErro");
        
        /* Conversão da resposta em formato JSON em um objeto ExceptionResponse */
        Gson gson = new GsonBuilder().create();
        ExceptionResponse erro = gson.fromJson(resposta, ExceptionResponse.class);  
        
        this.mostrarAlerta(INFORMATION, titulo, cabecalho, erro.getMensagemDeErro());
    }
    
    public void arredondarImagem(String caminho, Shape forma) {
        
        /* Define a imagem da rodada */
        Image conquistaDesconhecida = new Image(caminho);
            
        /* Cria um padrão circular com a imagem e exibe na tela */
        ImagePattern conquistaDesconhecidaPattern = new ImagePattern(conquistaDesconhecida);
        forma.setFill((Paint) conquistaDesconhecidaPattern);
    }
    
    public Date converterData(DatePicker datePicker) throws ParseException {
        
        /* Conversão do valor no DatePicker para uma data em formato válido */
        java.util.Date dataJava = java.sql.Date.valueOf(datePicker.getValue());
        SimpleDateFormat formatador = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss");
        // formatador.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dataString = formatador.format(dataJava);  
        java.util.Date dataFormatada = formatador.parse(dataString);
        
        return dataFormatada;
    }
    
    public Pane carregarMolde(String fxml) {
        
        Pane pane = new Pane();
        
        try {
            
            pane = FXMLLoader.load(this.getClass().getResource(fxml));
        } 
        catch (IOException ex) {
            
            //...
        }
        
        return pane;
    }
}
