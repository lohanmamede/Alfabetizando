package com.lunarez.alfabetizando.data;

import static java.lang.System.err;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author eres
 */
public class HibernateUtils {
    
    private static final SessionFactory FABRICA_DE_SESSOES;
    
    static {
        
        Configuration c = new Configuration();
        c.configure();
        
        try {
            
            FABRICA_DE_SESSOES = new Configuration().configure()
                    .buildSessionFactory();
        }
        catch(HibernateException e) {
            
            err.println("A criação da fábrica de sessões falhou: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static SessionFactory getFabricaDeSessoes() {
        
        return FABRICA_DE_SESSOES;
    }
}
