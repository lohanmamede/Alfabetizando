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
    @NamedQuery(name = "Nivel.listar", 
            query = "SELECT n FROM Nivel n")
    , @NamedQuery(name = "Nivel.buscarPorId", 
            query = "SELECT n FROM Nivel n WHERE n.idDb = :idDb")})
@Entity
@Table(name = "nivel")
public class Nivel implements Serializable {

    // ------------------------------------------------------------------ Campos
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_db")
    private Long idDb;
    
    @Basic(optional = false)
    @Column(name = "rodadas")
    private int rodadas;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivel", 
            fetch = FetchType.LAZY)
    private Collection<NivelTemImagem> nivelTemImagemCollection;

    
    // ------------------------------------------------------------ Construtores
    public Nivel() {
        
        //...
    }

    public Nivel(Long idDb) {
        
        this.idDb = idDb;
    }

    
    // ------------------------------------------------------- Getters e Setters
    public Long getIdDb() {
        
        return idDb;
    }

    public void setIdDb(Long idDb) {
        
        this.idDb = idDb;
    }
    
    public int getRodadas() {
        
        return rodadas;
    }

    public void setRodadas(int rodadas) {
        
        this.rodadas = rodadas;
    }

    public Collection<NivelTemImagem> getNivelTemImagemCollection() {
        
        return nivelTemImagemCollection;
    }

    public void setNivelTemImagemCollection(Collection<NivelTemImagem> 
            nivelTemImagemCollection) {
        
        this.nivelTemImagemCollection = nivelTemImagemCollection;
    }
}
