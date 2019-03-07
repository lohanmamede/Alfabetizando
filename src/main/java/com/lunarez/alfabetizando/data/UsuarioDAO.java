package com.lunarez.alfabetizando.data;

import com.lunarez.alfabetizando.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/* Uso do Criteria: https://goo.gl/MFnP5C */

/**
 * Classe com a implementação da interface DAO do usuário para o banco de dados
 * MariaDB/MYSQL
 *
 * @author eres
 */
public class UsuarioDAO { // =D

    Session sessao;

    public void abrirConexao() {

        SessionFactory fabricaDeSessoes = HibernateUtils.getFabricaDeSessoes();
        sessao = fabricaDeSessoes.openSession();
    }

    public void salvarUsuario(Usuario usuario) {

        /* É iniciada uma transação no banco de dados para que as operações 
        necessárias sejam feitas e commitadas (tornadas permanente) */
        sessao.beginTransaction();
        sessao.save(usuario);
        sessao.getTransaction().commit();
    }

    public void fecharConexao() {

        if (sessao != null) {

            sessao.close();
        }
    }
}
