package com.lunarez.alfabetizando.ews.response; // :D

/** 
 * Esta classe representa o modelo de dados que será recebido do webservice quando
 * houver uma exception
 * 
 * @author eres
 */
public class ExceptionResponse {

    // ------------------------------------------------------------------ Campos
    private String mensagemDeErroChave;
    private String mensagemDeErro;
    private String link;
    

    // ----------------------------------------------------------------- Getters
    /**
     * @return a mensagemDeErroChave
     */
    public String getMensagemDeErroChave() {
        return mensagemDeErroChave;
        
    }

    /**
     * @return a mensagemDeErro
     */
    public String getMensagemDeErro() {
        
        return mensagemDeErro;
    }

    /**
     * @return o link
     */
    public String getLink() {
        
        return link;
    }    
}