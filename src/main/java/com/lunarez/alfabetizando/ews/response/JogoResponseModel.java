package com.lunarez.alfabetizando.ews.response; // :D

/** 
 * Esta classe representa o modelo de dados que será recebido do webservice quando
 * for necessário obter dados de um jogo
 * 
 * @author eres
 */
public class JogoResponseModel {

    // ------------------------------------------------------------------ Campos
    private String idExterno;
    private String nome;
    private String descricao;
    private String downloadUrl;
    private String logotipo;
    private String oferecidoPor;
    private String classificacao;
    private int tamanho;
   
    
    // ------------------------------------------------------- Getters e Setters    
    public String getIdExterno() {
        
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        
        this.idExterno = idExterno;
    }

    public String getNome() {
        
        return nome;
    }

    public void setNome(String nome) {
        
        this.nome = nome;
    }

    public String getDescricao() {
        
        return descricao;
    }

    public void setDescricao(String descricao) {
        
        this.descricao = descricao;
    }

    public String getDownloadUrl() {
        
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        
        this.downloadUrl = downloadUrl;
    }

    public String getLogotipo() {
        
        return logotipo;
    }

    public void setLogotipo(String logotipo) {
        
        this.logotipo = logotipo;
    }

    public String getOferecidoPor() {
        
        return oferecidoPor;
    }

    public void setOferecidoPor(String oferecidoPor) {
        
        this.oferecidoPor = oferecidoPor;
    }

    public int getTamanho() {
        
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        
        this.tamanho = tamanho;
    }

    public String getClassificacao() {
        
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        
        this.classificacao = classificacao;
    }
}