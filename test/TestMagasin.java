/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import magasinenligne.entity.Categorie;
import magasinenligne.entity.Client;
import magasinenligne.entity.Produit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurent-LIM
 */
public class TestMagasin {

    @Test
    public void testAjoutClient() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        em.getTransaction().begin();

        //ajout de client
        Client c1 = new Client();
        c1.setLogin("toto");
        em.persist(c1);

        Client c2 = new Client();
        c2.setLogin("tata");
        em.persist(c2);

        em.getTransaction().commit();

    }

    //@Test
    public void testListeProdCategorie() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Categorie cat = em.find(Categorie.class, 2L);
        for (Produit p : cat.getProduits()) {

            System.out.println(p);
        }

    }

    // @Test
    public void test() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        // permet d'ouvrir la manipulation des donnees en base
        em.getTransaction().begin();

        //ecriture dans categorie
        Categorie c1 = new Categorie();
        c1.setNom("Basket");

        //ajout dans la base
        em.persist(c1);

        /* ajout 2 eme categorie*/
        Categorie c2 = new Categorie();
        c2.setNom("Lunettes solaire");
        em.persist(c2);

        Produit rayban = new Produit();
        rayban.setTitre("ray-Ban");
        rayban.setCategorie(c2);
        em.persist(rayban);

        //permet d'envoyer la transaction a la base
        em.getTransaction().commit();

    }

}
