package com.lunarez.alfabetizando.ews.request; // :D

import javax.xml.bind.annotation.XmlRootElement;

/** 
 * Esta classe representa o modelo de dados que será enviado pela aplicação 
 * cliente para uma requisição de login
 * 
 * @author eres
 */
@XmlRootElement /* Permite que a classe possa ser convertida em JSON/XML */
public class LoginRequestModel {

    // ------------------------------------------------------------------ Campos    
    private String email;
    private String senha;
    

    // ------------------------------------------------------- Getters e Setters
    /**
     * @return o email   */
    public String getEmail() {
        
        return email;
    }

    /**
     * @param email o email a ser definido
     */
    public void setEmail(String email) {
        
        this.email = email;
    }

    /**
     * @return a senha
     */
    public String getSenha() {
        
        return senha;
    }

    /**
     * @param senha a senha a ser definida
     */
    public void setSenha(String senha) {
        
        this.senha = senha;
    }    
}
