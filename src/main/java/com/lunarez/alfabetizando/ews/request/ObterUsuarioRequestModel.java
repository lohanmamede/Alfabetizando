package com.lunarez.alfabetizando.ews.request; // :D

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Esta classe representa o modelo de dados que será enviado para a aplicação
 * cliente caso uma tentativa de login seja bem-sucedida
 * 
 * @author eres
 */
@XmlRootElement /* Permite que a classe possa ser convertida em JSON/XML */
public class ObterUsuarioRequestModel {
    
    // ------------------------------------------------------------------ Campos
    private String idExterno;
    private String token;

    
    // ------------------------------------------------------- Getters e Setters
    /**
     * @return o idExterno
     */
    public String getIdExterno() {
        
        return idExterno;
    }

    /**
     * @param idExterno o idExterno a definir
     */
    public void setIdExterno(String idExterno) {
        
        this.idExterno = idExterno;
    }

    /**
     * @return o token
     */
    public String getToken() {
        
        return token;
    }

    /**
     * @param token o token a definir
     */
    public void setToken(String token) {
        
        this.token = token;
    }
}
