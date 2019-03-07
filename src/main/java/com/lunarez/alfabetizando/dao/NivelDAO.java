package com.lunarez.alfabetizando.dao;

import com.lunarez.alfabetizando.data.HibernateUtils;
import com.lunarez.alfabetizando.model.Jogo;
import com.lunarez.alfabetizando.model.Nivel;
import static java.lang.System.out;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author eres
 */
public class NivelDAO {

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

    public void salvarOuAtualizar(Nivel nivel) {
        
        try {

            this.abrirConexao(); out.println("Conexão foi aberta!"); /* Log */
            sessao.beginTransaction();
            sessao.saveOrUpdate(nivel);
            sessao.getTransaction().commit(); 
        } 
        finally {

            this.fecharConexao(); out.println("Conexão foi fechada!"); /* Log */
        }
    }

    public void editar(Nivel nivel) {

        sessao.beginTransaction();
        sessao.update(nivel);
        sessao.getTransaction().commit();
    }

    public void deletar(Nivel nivel) {

        sessao.beginTransaction();
        sessao.delete(nivel);
        sessao.getTransaction().commit();
    }  
}
