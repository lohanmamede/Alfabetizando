package com.lunarez.alfabetizando.dao;

import com.lunarez.alfabetizando.data.HibernateUtils;
import com.lunarez.alfabetizando.model.Usuario;
import static java.lang.System.out;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author eres
 */
public class UsuarioDAO {

    Session sessao;

    private void abrirConexao() {

        SessionFactory fabricaDeSessoes = HibernateUtils.getFabricaDeSessoes();
        sessao = fabricaDeSessoes.openSession();
    }
    
    private void fecharConexao() {
        
        if (sessao != null) {
            
            sessao.close();
        }
    }

    public void salvar(Usuario usuario) {
        
        try {

            this.abrirConexao(); out.println("Conexão foi aberta!"); /* Log */
            sessao.beginTransaction();
            sessao.save(usuario);
            sessao.getTransaction().commit(); 
        } 
        finally {

            this.fecharConexao(); out.println("Conexão foi fechada!"); /* Log */
        }
    }

    public void editar(Usuario usuario) {

        sessao.beginTransaction();
        sessao.update(usuario);
        sessao.getTransaction().commit();
    }

    public void deletar(Usuario usuario) {

        sessao.beginTransaction();
        sessao.delete(usuario);
        sessao.getTransaction().commit();
    }

    public Usuario logar(Usuario usuario) {

        Usuario resultado = null;
        
        try {
            
            this.abrirConexao(); out.println("Conexão foi aberta!"); /* Log */
            
            sessao.beginTransaction();
        
            Query query = sessao.getNamedQuery("Usuario.logar");
            query.setParameter("nome", usuario.getNome());
            query.setParameter("senha", usuario.getSenha());

            resultado = (Usuario) query.uniqueResult();

            sessao.getTransaction().commit();  
        }
        finally {

            this.fecharConexao(); out.println("Conexão foi fechada!"); /* Log */
        }
        
        
        return resultado;
    }
    
    public Usuario buscarPorNome(Usuario usuario) {

        Usuario resultado = null;
        
        try {
            
            this.abrirConexao(); out.println("Conexão foi aberta!"); /* Log */
            
            sessao.beginTransaction();
        
            Query query = sessao.getNamedQuery("Usuario.buscarPorNome");
            query.setParameter("nome", usuario.getNome());

            resultado = (Usuario) query.uniqueResult();

            sessao.getTransaction().commit();  
        }
        finally {

            this.fecharConexao(); out.println("Conexão foi fechada!"); /* Log */
        }
        
        
        return resultado;
    }
}
