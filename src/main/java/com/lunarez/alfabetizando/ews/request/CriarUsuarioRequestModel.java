package com.lunarez.alfabetizando.ews.request; // :D

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * Esta classe representa o modelo de dados que será enviado pela aplicação 
 * cliente para a criação de um novo usuário
 * 
 * @author eres
 */
@XmlRootElement /* Permite que a classe possa ser convertida em JSON/XML */
public class CriarUsuarioRequestModel {

    // ------------------------------------------------------------------ Campos    
    private char tipo;
    private String codinome;
    private String nomeCompleto;
    private String email;
    private String senha;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd'T'HH:mm:ss")
    private Date dataNascimento;
    

    // ------------------------------------------------------- Getters e Setters
    /**
     * @return the tipo
     */
    public char getTipo() {
        
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo) {
        
        this.tipo = tipo;
    }

    /**
     * @return the codinome
     */
    public String getCodinome() {
        
        return codinome;
    }

    /**
     * @param codinome the codinome to set
     */
    public void setCodinome(String codinome) {
        
        this.codinome = codinome;
    }

    /**
     * @return the nomeCompleto
     */
    public String getNomeCompleto() {
        
        return nomeCompleto;
    }

    /**
     * @param nomeCompleto the nomeCompleto to set
     */
    public void setNomeCompleto(String nomeCompleto) {
        
        this.nomeCompleto = nomeCompleto;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        
        this.senha = senha;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        
        this.dataNascimento = dataNascimento;
    }
}
