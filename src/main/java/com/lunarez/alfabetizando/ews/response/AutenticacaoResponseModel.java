package com.lunarez.alfabetizando.ews.response; // :D

/**
 * Esta classe representa o modelo de dados que será recebido do webservice quando
 * houver uma tentativa de login bem-sucedida
 * 
 * @author eres
 */
public class AutenticacaoResponseModel {
    
    // ------------------------------------------------------------------ Campos
    private static AutenticacaoResponseModel sessaoUnica;
    private String idExterno;
    private String token;
    private String codinome;
    private String imagemPerfil;
    
    
    // ------------------------------------------------------------ Construtores
    /* Construtor privado para impedir a instanciação da classe diretamente */
    private AutenticacaoResponseModel() {
        
        //...
    }

    
    // ------------------------------------------------------- Getters e Setters
    /**
     * @return o idExterno
     */
    public String getIdExterno() {
        
        return idExterno;
    }

    /**
     * @return o token
     */
    public String getToken() {
        
        return token;
    }
    
    /**
     * @param idExterno o idExterno a ser definido
     */
    public void setIdExterno(String idExterno) {
        
        this.idExterno = idExterno;
    }

    /**
     * @param token o token a ser definido
     */
    public void setToken(String token) {
        
        this.token = token;
    }
    
    /**
     * @return o codinome
     */
    public String getCodinome() {
        
        return codinome;
    }

    /**
     * @param codinome o codinome a definir
     */
    public void setCodinome(String codinome) {
        
        this.codinome = codinome;
    }
    
    /**
     * @return a imagemPerfil
     */
    public String getImagemPerfil() {
        
        return imagemPerfil;
    }

    /**
     * @param imagemPerfil a imagemPerfil a definir
     */
    public void setImagemPerfil(String imagemPerfil) {
        
        this.imagemPerfil = imagemPerfil;
    }
    
    /**
     * @return a sessaoUnica
     */
    public static AutenticacaoResponseModel getSessao() {
        
        if (sessaoUnica == null) {
            
            sessaoUnica = new AutenticacaoResponseModel();
        }
 
        return sessaoUnica;
    }
}
