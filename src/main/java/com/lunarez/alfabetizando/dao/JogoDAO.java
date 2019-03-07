package com.lunarez.alfabetizando.dao;

import com.lunarez.alfabetizando.data.HibernateUtils;
import com.lunarez.alfabetizando.model.Jogo;
import static java.lang.System.out;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author eres
 */
public class JogoDAO {

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

    public void salvarOuAtualizar(Jogo jogo) {
        
        try {

            this.abrirConexao(); out.println("Conexão foi aberta!"); /* Log */
            sessao.beginTransaction();
            sessao.saveOrUpdate(jogo);
            sessao.getTransaction().commit(); 
        } 
        finally {

            this.fecharConexao(); out.println("Conexão foi fechada!"); /* Log */
        }
    }

    public void editar(Jogo jogo) {

        sessao.beginTransaction();
        sessao.update(jogo);
        sessao.getTransaction().commit();
    }

    public void deletar(Jogo jogo) {

        sessao.beginTransaction();
        sessao.delete(jogo);
        sessao.getTransaction().commit();
    }  
}
