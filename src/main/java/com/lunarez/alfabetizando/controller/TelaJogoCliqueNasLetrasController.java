package com.lunarez.alfabetizando.controller; // :D

import com.lunarez.alfabetizando.ews.JogosDoUsuarioEWS;
import com.lunarez.alfabetizando.ews.response.AutenticacaoResponseModel;
import static com.lunarez.alfabetizando.ews.response.AutenticacaoResponseModel.getSessao;
import static java.lang.System.out;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * Esta classe controla a tela do jogo Clique nas Letras
 *
 * @author eres
 */
public class TelaJogoCliqueNasLetrasController extends ControllersJogos 
        implements Initializable {

    // ------------------------------------------------------------------ Campos
    private final Character[] alfabeto = new Character[]{'A', 'B', 'C', 'D',
        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Ç', 'Â', 'Ã', 'Á', 'Í', 'É',
        'Ê', 'Ó', 'Ô', 'Ú'};
    
    Image imagem;
    ImagePattern imagePattern;
    String palavraCorreta;
    private int nivel;
    private int acertos;
    private int erros;
    private int rodada;

    @FXML
    AnchorPane anchorPane;
    @FXML
    Circle circulo;
    @FXML
    Label labelPalavra;
    @FXML
    Label labelAcertos;
    @FXML
    Label labelErros;
    @FXML
    Label labelNDeLetras;
    @FXML
    Label labelInformativa;
    @FXML
    Button botaoApagarLetra;
    @FXML
    Button botaoApagarTudo;
    @FXML
    Button botaoLetra1;
    @FXML
    Button botaoLetra2;
    @FXML
    Button botaoLetra3;
    @FXML
    Button botaoLetra4;
    @FXML
    Button botaoLetra5;
    @FXML
    Button botaoLetra6;
    @FXML
    Button botaoLetra7;
    @FXML
    Button botaoLetra8;
    @FXML
    Button botaoLetra9;
    @FXML
    Button botaoLetra10;
    @FXML
    Button botaoLetra11;
    @FXML
    Button botaoLetra12;
    @FXML
    Button botaoVerificar;

    
    // ----------------------------------------------------------------- Métodos
    /**
     * Este método configura a inicialização do controller da tela do jogo
     * Clique nas Letras
     *
     * @param url local do FXML da tela do jogo Clique nas Letras
     * @param rb contém dados específicos de certos idiomas
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /* Armazena a instancia desse controller, para que ele possa ser usado 
        nos controllers de outras telas */
        Controllers.setTelaJogoCliqueNasLetrasController(this);

        /* Gera uma lista com o caminho das imagens que serão usadas no jogo */
        super.setListaDeImagens();
        
        /* Define a primeira rodada */
        this.rodada = 1;
        
        /* Inicia a primeira rodada */
        iniciarProximaRodada();
    }

    /**
     *
     */
    public void iniciarProximaRodada() {

        /* Inicia a próxima rodada apenas se o número que identifica a rodada
        for menor ou igual a quantidade de imagens disponíveis no jogo */
        if (this.rodada <= super.getListaDeImagens().size()) {

            /* Limpa qualquer texto que esteja na Label */
            this.labelPalavra.setText("");
            
            /* Define a imagem da rodada */
            this.imagem = new Image(
                    this.getClass().getClassLoader().getResourceAsStream(
                    super.getListaDeImagens().get(this.rodada - 1)));

            /* Cria um padrão circular com a imagem e exibe na tela */
            this.imagePattern = new ImagePattern(this.imagem);
            this.circulo.setFill((Paint) this.imagePattern);

            /* Seleciona apenas o nome da imagem da rodada e define como a 
            palavra correta da rodada */
            this.palavraCorreta = super.getListaDeImagens().get(this.rodada - 1)
                    .replace(".png", "")
                    .replace("com/lunarez/alfabetizando/images/jogos/", "")
                    .toUpperCase();

            /* Define o número de letras da palavra correta e exibe na tela */
            this.labelNDeLetras.setText(Integer.toString(
                    this.palavraCorreta.length()));

            /* Sorteia as letras da rodada e exibe na tela */
            this.sortearLetras();
        } 
        else {
            
            JogosDoUsuarioEWS ews = new JogosDoUsuarioEWS();
            
            ews.atualizarJogoDaColecao(AutenticacaoResponseModel.getSessao().getIdExterno(), 
                    "HrxrKxoeMi800Gwu4aER59q8roAKhD",
                    acertos, 
                    1,
                    -1,
                    -1,
                    -1);
            
            /* Mostra mensagem informando que o usuário completou o nível caso o 
            'if' seja false, ou seja, todas as imagens já foram usadas para 
            alguma rodada */ 
            Alert alert = new Alert(INFORMATION);
            alert.setTitle("Alfabetizando");
            alert.setHeaderText("Você completou o nível");
            alert.setContentText("Pontuação: " + acertos + " acertos e " + 
                    erros + " erros!");
            alert.showAndWait();
            
            

            /* Volta à tela inicial após o usuário ter completo o nível */
            Controllers.getTelaPrincipalController().chamarTelaInicial();
        }
    }

    /**
     * Este método sorteia as letras que aparecerão nos botões do jogo.
     * Incluindo as letras da palavra e demais letras, até a quantidade
     * necessária. Por fim as embaralha e as atribui aos botões
     */
    public void sortearLetras() {

        int cont;

        /* Cria uma lista onde serão armazenadas as letras a serem exibidas na 
        tela */
        ArrayList<Character> letras = new ArrayList<>();

        /* Armazena as letras da palavra correta */
        for (cont = 0; cont < this.palavraCorreta.length(); ++cont) {

            letras.add(this.palavraCorreta.toUpperCase().charAt(cont));
            out.println("Letras: " + letras); /* Log */
        }

        /* Define quantas letras devem ser sorteadas para completar a lista */
        int nDeLetrasAleatorias = 12 - this.palavraCorreta.length();

        /* Embaralha as letras do alfabeto */
        Collections.shuffle(Arrays.asList(this.alfabeto));

        /* Armazena as x primeiras que foram embaralhadas anteriormente na 
        lista */
        for (cont = 0; cont < nDeLetrasAleatorias; ++cont) {

            /* Inclui a letra se ela já não estiver presente na lista */
            if (!letras.contains(this.alfabeto[cont])) {

                letras.add(this.alfabeto[cont]);
                out.println("Incluída: " + this.alfabeto[cont]); /* Log */
            } 
            else {
                
                /* Não inclui se estiver, e uma nova iteração é feita */ 
                ++nDeLetrasAleatorias;
                out.println("Não incluída: " + this.alfabeto[cont]); /* Log */
            }
        }

        /* Embaralha a lista de letras final */
        Collections.shuffle(letras);

        /* Atribui cada letra a um botão na tela */
        this.botaoLetra1.setText((letras.get(0)).toString());
        this.botaoLetra2.setText((letras.get(1)).toString());
        this.botaoLetra3.setText((letras.get(2)).toString());
        this.botaoLetra4.setText((letras.get(3)).toString());
        this.botaoLetra5.setText((letras.get(4)).toString());
        this.botaoLetra6.setText((letras.get(5)).toString());
        this.botaoLetra7.setText((letras.get(6)).toString());
        this.botaoLetra8.setText((letras.get(7)).toString());
        this.botaoLetra9.setText((letras.get(8)).toString());
        this.botaoLetra10.setText((letras.get(9)).toString());
        this.botaoLetra11.setText((letras.get(10)).toString());
        this.botaoLetra12.setText((letras.get(11)).toString());
    }
    
    
    // --------------------------- Métodos executados pelo acionamento de botões
    @FXML
    public void acionarBotaoVerificar() {

        if(botaoVerificar.getText().equals("Verificar")) {
            
            /* Exibe mensagem alertando que a Label está em branco, se o usuário
            clicar no botão de verificar e ela estiver */
            if (this.labelPalavra.getText().equals("")) {

                labelInformativa.setText("Não há letras selecionadas!");
                labelInformativa.setStyle("-fx-background-color: #f0f4c3;"
                        + "-fx-text-fill: #9e9d24;"
                        + "-fx-border-color: #d4e157;"
                        + "-fx-background-radius: 5;"
                        + "-fx-border-radius: 5;"
                        + "-fx-font-size: 16;");  
            }
            /* Exibe mensagem informando que o usuário acertou a palavra, 
            aumenta a quantidade de pontos, exibe na tela, define e inicia uma 
            nova rodada */
            else if (this.labelPalavra.getText().equals(this.palavraCorreta)) {

                this.acertos++;
                this.labelAcertos.setText(Integer.toString(this.acertos));

                labelInformativa.setText("Você acertou, clique em Continuar");
                labelInformativa.setStyle("-fx-background-color: #c8e6c9;"
                        + "-fx-text-fill: #2e7d32;"
                        + "-fx-border-color: #2e7d32;"
                        + "-fx-background-radius: 5;"
                        + "-fx-border-radius: 5;"
                        + "-fx-font-size: 16;"); 

                botaoVerificar.setText("Continuar");
                desabilitarBotoes(true);
            } 
            /* Exibe mensagem informando que o usuário não acertou a palavra,
            diminui a quantidade de pontos, exibe na tela, define e inicia uma 
            nova rodada */
            else if (!this.labelPalavra.getText().equals(this.palavraCorreta)) {

                this.erros++;
                this.labelErros.setText(Integer.toString(this.erros));

                labelInformativa.setText("Opps... a palavra correta era " + 
                        this.palavraCorreta + ", clique em Continuar");
                labelInformativa.setStyle("-fx-background-color: #ffcdd2;"
                        + "-fx-text-fill: #c62828;"
                        + "-fx-border-color: #ef5350;"
                        + "-fx-background-radius: 5;"
                        + "-fx-border-radius: 5;"
                        + "-fx-font-size: 16;"); 
                
                botaoVerificar.setText("Continuar");
                desabilitarBotoes(true);
            }
        }
        else if(botaoVerificar.getText().equals("Continuar")) {
            
            this.rodada++;
            this.iniciarProximaRodada();
            
            labelInformativa.setStyle("-fx-opacity: 0"); 
            
            botaoVerificar.setText("Verificar");
            desabilitarBotoes(false);
        }
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoOuvirPalavra() {

        /* Ainda não implementado */
    }

    @FXML
    public void acionarBotaoApagarLetra() {

        /* Substitui o texto na Label por um novo excluindo a última letra */
        if (this.labelPalavra.getText().length() > 0) {

            this.labelPalavra.setText(this.labelPalavra.getText().substring(
                    0, this.labelPalavra.getText().length() - 1));
        }
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoApagarTudo() {

        /* Substitui o texto na Label por um texto vazio */
        this.labelPalavra.setText("");
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra1() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra1.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra2() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra2.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra3() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra3.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra4() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra4.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra5() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra5.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra6() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra6.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra7() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra7.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra8() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra8.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra9() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra9.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra10() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra10.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra11() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra11.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }

    @FXML
    public void acionarBotaoLetra12() {

        /* Adiciona a letra do botão ao fim da Label */
        this.labelPalavra.setText(this.labelPalavra.getText()
                + this.botaoLetra12.getText());
        
        /* Tira o foco do botão e o entrega a um elemento "imperceptível" */
        this.anchorPane.requestFocus();
    }
    
    public void desabilitarBotoes(boolean habilitar) {

        botaoApagarLetra.setDisable(habilitar);
        botaoApagarTudo.setDisable(habilitar);
        botaoLetra1.setDisable(habilitar);
        botaoLetra2.setDisable(habilitar);
        botaoLetra3.setDisable(habilitar);
        botaoLetra4.setDisable(habilitar);
        botaoLetra5.setDisable(habilitar);
        botaoLetra6.setDisable(habilitar);
        botaoLetra7.setDisable(habilitar);
        botaoLetra8.setDisable(habilitar);
        botaoLetra9.setDisable(habilitar);
        botaoLetra10.setDisable(habilitar);
        botaoLetra11.setDisable(habilitar);
        botaoLetra12.setDisable(habilitar);
    }
}

//    /* Armazena o caminho absoluto do diretório onde o jar se encontra */
//    URL diretorio = App.class.getProtectionDomain().getCodeSource()
//            .getLocation();