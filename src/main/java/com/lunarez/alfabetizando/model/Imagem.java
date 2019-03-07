package com.lunarez.alfabetizando.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eres
 */
@NamedQueries({
    @NamedQuery(name = "Imagem.listar", 
            query = "SELECT i FROM Imagem i")
    , @NamedQuery(name = "Imagem.buscarPorId", 
            query = "SELECT i FROM Imagem i WHERE i.idDb = :idDb")
    , @NamedQuery(name = "Imagem.buscarPorNome", 
            query = "SELECT i FROM Imagem i WHERE i.nome = :nome")
    , @NamedQuery(name = "Imagem.buscarPorCaminho", 
            query = "SELECT i FROM Imagem i WHERE i.caminho = :caminho")})
@Entity
@Table(name = "imagem")
public class Imagem implements Serializable {

    // ------------------------------------------------------------------ Campos
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_db")
    private Long idDb;
    
    @Column(name = "nome", unique = true)
    private String nome;
    
    @Column(name = "caminho", unique = true)
    private String caminho;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idImagem", 
            fetch = FetchType.LAZY)
    private Collection<NivelTemImagem> nivelTemImagemCollection;

    
    // ------------------------------------------------------------ Construtores
    public Imagem() {
        
        //...
    }

    public Imagem(Long idDb) {
        
        this.idDb = idDb;
    }

    
    // ------------------------------------------------------- Getters e Setters
    public Long getIdDb() {
        
        return idDb;
    }

    public void setIdDb(Long idDb) {
        
        this.idDb = idDb;
    }

    public String getNome() {
        
        return nome;
    }

    public void setNome(String nome) {
        
        this.nome = nome;
    }
    
    public String getCaminho() {
        
        return caminho;
    }

    public void setCaminho(String caminho) {
        
        this.caminho = caminho;
    }

    public Collection<NivelTemImagem> getNivelTemImagemCollection() {
        
        return nivelTemImagemCollection;
    }

    public void setNivelTemImagemCollection(Collection<NivelTemImagem> 
            nivelTemImagemCollection) {
        
        this.nivelTemImagemCollection = nivelTemImagemCollection;
    }
}
