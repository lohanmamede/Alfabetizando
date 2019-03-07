package com.lunarez.alfabetizando.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author eres
 */
@NamedQueries({
    @NamedQuery(name = "NivelTemImagem.listar", 
            query = "SELECT n FROM NivelTemImagem n")
    , @NamedQuery(name = "NivelTemImagem.buscarPorId", 
            query = "SELECT n FROM NivelTemImagem n WHERE n.idDb = :idDb")})
@Entity
@Table(name = "nivel_tem_imagem")
public class NivelTemImagem implements Serializable {

    // ------------------------------------------------------------------ Campos 
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_db")
    private Long idDb;
    
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_db")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Nivel idNivel;
    
    @JoinColumn(name = "id_imagem", referencedColumnName = "id_db")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Imagem idImagem;

    
    // ------------------------------------------------------------ Construtores
    public NivelTemImagem() {
        
        //...
    }

    public NivelTemImagem(Long idDb) {
        
        this.idDb = idDb;
    }

    
    // ------------------------------------------------------- Getters e Setters
    public Long getIdDb() {
        
        return idDb;
    }

    public void setIdDb(Long idDb) {
        
        this.idDb = idDb;
    }
    
    public Nivel getIdNivel() {
        
        return idNivel;
    }

    public void setIdNivel(Nivel idNivel) {
        
        this.idNivel = idNivel;
    }

    public Imagem getIdImagem() {
        
        return idImagem;
    }

    public void setIdImagem(Imagem idImagem) {
        
        this.idImagem = idImagem;
    }
}
