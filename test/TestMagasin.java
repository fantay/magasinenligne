/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import magasinenligne.entity.Categorie;
import magasinenligne.entity.Client;
import magasinenligne.entity.Produit;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Laurent-LIM
 */
public class TestMagasin {
    
    @Before
    public void avant() {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        
        /* On vide toutes les tables */
        //methode 1
        Query query = em.createQuery("DELETE FROM Produit p");
        query.executeUpdate();
        
        //methode 2
        em.createQuery("DELETE FROM Categorie p").executeUpdate();

        /*  
            ajoute des données en spécifiant les ID que 
            l'on va utliser dans les test unitaires 
        */

        //ajout d'unr categorie
        Categorie c1 = new Categorie();
        c1.setId(1L);
        c1.setNom("Basket");
        em.persist(c1);

        /* ajout 2 eme categorie*/
        Categorie c2 = new Categorie();
        c2.setId(2L);
        c2.setNom("Lunettes solaire");
        em.persist(c2);

        /*ajout d'un produit avec reference de sa categorie*/
        Produit rayban = new Produit();
        rayban.setId(1L);
        rayban.setTitre("ray-Ban");
        rayban.setCategorie(c2);
        em.persist(rayban);

        //permet d'envoyer la transaction a la base
        em.getTransaction().commit();
        
    }

    /* ############################ TEST ################################## */
    @Test
    public void verifieQueCatID1EstBasket() {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        Categorie cat = em.find(Categorie.class, 1L);
        
        if (cat.getNom().equals("Basket")==false) {
           Assert.fail("CA MARCHE PAS");
        }
    }

    //@Test
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
        
        Categorie cat = em.find(Categorie.class, 1L);
        for (Produit p : cat.getProduits()) {
            
            System.out.println(p);
        }
        
    }
    
}
