package com.lunarez.alfabetizando.dao;

import com.lunarez.alfabetizando.data.HibernateUtils;
import com.lunarez.alfabetizando.model.Imagem;
import static java.lang.System.out;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author eres
 */
public class ImagemDAO {

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

    public void salvarOuAtualizar(Imagem imagem) {
        
        try {

            this.abrirConexao(); out.println("Conexão foi aberta!"); /* Log */
            sessao.beginTransaction();
            sessao.saveOrUpdate(imagem);
            sessao.getTransaction().commit(); 
        } 
        finally {

            this.fecharConexao(); out.println("Conexão foi fechada!"); /* Log */
        }
    }

    public void editar(Imagem imagem) {

        sessao.beginTransaction();
        sessao.update(imagem);
        sessao.getTransaction().commit();
    }

    public void deletar(Imagem imagem) {

        sessao.beginTransaction();
        sessao.delete(imagem);
        sessao.getTransaction().commit();
    }  
}
