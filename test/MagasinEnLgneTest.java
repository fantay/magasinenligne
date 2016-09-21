/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import magasinenligne.entity.Categorie;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurent-LIM
 */
public class MagasinEnLgneTest {
    
    @Test
    public void test(){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        // permet d'ouvrir la manipulation des donnees en base
        em.getTransaction().begin();
        
        //ecriture dans categorie
        Categorie c1 = new Categorie();
        c1.setNom("Chaussure a talon");
        
        //ajout dans la base
        em.persist(c1);
        
        //permet d'envoyer la transaction a la base
        em.getTransaction().commit();
        
    }
    
}
