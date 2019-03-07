package com.lunarez.alfabetizando.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author eres
 */
@NamedQueries({
    @NamedQuery(name = "Usuario.listar", 
            query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.buscarPorId", 
            query = "SELECT u FROM Usuario u WHERE u.idDb = :idDb")
    , @NamedQuery(name = "Usuario.buscarPorNome", 
            query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.buscarPorSenha", 
            query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.logar", 
            query = "SELECT u FROM Usuario u WHERE "
                    + "u.nome = :nome AND u.senha = :senha")})
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    // ------------------------------------------------------------------ Campos
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_db")
    private Long idDb;
    
    @Column(name = "nome", unique = true)
    private String nome;
    
    @Column(name = "senha")
    private String senha;
    
    
    // ------------------------------------------------------------ Construtores
    public Usuario() {
        
        //...
    }

    public Usuario(Long idDb) {
        
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
    
    public String getSenha() {
        
        return senha;
    }

    public void setSenha(String senha) {
        
        this.senha = senha;
    }
}
