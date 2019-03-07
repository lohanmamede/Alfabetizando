package com.lunarez.alfabetizando.controller; // :D

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Esta classe é responsável por definir os atributos e métodos que os jogos 
 * possuem em comum, evitando a repetição de código
 *
 * @author eres
 */
public class ControllersJogos {
    
    
    // ------------------------------------------------------------------ Campos
    private ArrayList<String> listaDeImagens;

    
    // ------------------------------------------------------- Getters e Setters
    public void setListaDeImagens() {

        /* Armazena o caminho absoluto do jar do Alfabetizando */
        String diretorioComJar = System.getProperty("java.class.path");

        try {

            /* Cria um zip usando o caminho do jar */
            ZipFile zipFile = new ZipFile(diretorioComJar);

            /* Cria um Enumeration com os arquivos no zip */
            Enumeration entradas = zipFile.entries();

            /* Instancia a lista de imagens como um ArrayList<String> */
            this.listaDeImagens = new ArrayList<>();

            /* Enquanto há mais elementos no Enumeration... */
            while (entradas.hasMoreElements()) {

                /* Avança para o próximo elemento e guarda o caminho */
                ZipEntry entrada = (ZipEntry) entradas.nextElement();
                String nome = entrada.getName();

                /* Armazena o caminho do elemento na lista de imagens se o 
                elemento não for um diretório e se "/images/jogos/" for parte do
                caminho do elemento */
                if (!entrada.isDirectory() && nome.contains("images/jogos/")) {

                    this.listaDeImagens.add(nome);
                }
            }
        } 
        catch (IOException ex) {

            Logger.getLogger(TelaJogoCliqueNasLetrasController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        /* Embaralha a lista com o caminho das imagens */
        Collections.shuffle(this.listaDeImagens);
    }
    
    public ArrayList<String> getListaDeImagens() {
        
        return this.listaDeImagens;
    }
}
