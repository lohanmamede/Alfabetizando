package com.lunarez.alfabetizando.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author eres
 */
@NamedQueries({
    @NamedQuery(name = "Jogo.listar", 
            query = "SELECT j FROM Jogo j")
    , @NamedQuery(name = "Jogo.buscarPorId", 
            query = "SELECT j FROM Jogo j WHERE j.idDb = :idDb")
    , @NamedQuery(name = "Jogo.buscarPorNome", 
            query = "SELECT j FROM Jogo j WHERE j.nome = :nome")})
@Entity
@Table(name = "jogo")
public class Jogo implements Serializable {

    // ------------------------------------------------------------------ Campos
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_db")
    private Long idDb;
    
    @Column(name = "nome", unique = true)
    private String nome;

    
    // ------------------------------------------------------------ Construtores
    public Jogo() {
        
        //...
    }

    public Jogo(Long idDb) {
        
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
}
