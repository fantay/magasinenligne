/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import magasinenligne.entity.Categorie;
import magasinenligne.entity.Client;
import magasinenligne.entity.Commande;
import magasinenligne.entity.Produit;
import org.junit.Assert;
import org.junit.Test;
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

        //methode 2, la plus utiliser car plus simple d'ecriture
        em.createQuery("DELETE FROM Categorie p").executeUpdate();
        em.createQuery("DELETE FROM Commande p").executeUpdate();
        em.createQuery("DELETE FROM Client p").executeUpdate();

        em.getTransaction().commit();
        em.getTransaction().begin();
        /*  ajoute des données en spécifiant les ID que 
            l'on va utliser dans les test unitaires */
        //ajout d'unr categorie
        Categorie c1 = new Categorie();
        c1.setId(1L);
        c1.setNom("Basket");
        em.persist(c1);

        /*  ajout 2 eme categorie   */
        Categorie c2 = new Categorie();
        c2.setId(2L);
        c2.setNom("Lunettes solaire");
        em.persist(c2);

        /*  ajout d'un produit avec reference de sa categorie   */
        Produit rayban = new Produit();
        rayban.setId(1L);
        rayban.setTitre("ray-Ban");
        rayban.setCategorie(c2);
        c2.getProduits().add(rayban);
        em.persist(rayban);

        /*  Ajout de clients    */
        Client cl1 = new Client();
        cl1.setId(1L);
        cl1.setLogin("RIRI");
        em.persist(cl1);

        Client cl2 = new Client();
        cl2.setId(2L);
        cl2.setLogin("FIFI");
        em.persist(c2);

        Client cl3 = new Client();
        cl3.setId(3L);;
        cl3.setLogin("LOULOU");
        em.persist(cl3);

        /*  ajout des commandes des clients     */
        Commande com1 = new Commande();
        com1.setId(1L);
        com1.setClient(cl1);
        cl1.getCommandes().add(com1);
        com1.setPrixTotal(1000);

        em.persist(com1);

        Commande com2 = new Commande();
        com2.setId(2L);
        com2.setClient(cl3);
        cl3.getCommandes().add(com2);
        com2.setPrixTotal(5);
        em.persist(com2);

        Commande com3 = new Commande();
        com3.setId(3L);
        com3.setClient(cl3);
        cl3.getCommandes().add(com3);
        com3.setPrixTotal(2);
        em.persist(com3);

        //permet d'envoyer la transaction a la base
        em.getTransaction().commit();

    }

    /* 
    ####################################################################
    ############################ TEST ################################## 
    ####################################################################
     */
    @Test
    public void verifComd2EstPasserParRiriKO() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Commande comd2 = em.find(Commande.class, 2L);
        Assert.assertNotEquals("RIRI", comd2.getClient().getLogin());
    }

    //@Test
    public void verifQueCmd3PasserLoulou() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        //recup loulou
        Commande comd3 = em.find(Commande.class, 3L);

        Assert.assertEquals("LOULOU", comd3.getClient().getLogin());

    }

    // @Test
    public void verifQueNbrComdLoulouEst2() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Client c = em.find(Client.class, 3L);
        if (c.getCommandes().size() != 2) {
            Assert.fail("test" + c.getCommandes().size());
        }

    }

    // @Test
    public void verifieQueCatID1EstBasket() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Categorie cat = em.find(Categorie.class, 1L);

        if (cat.getNom().equals("Basket") == false) {
            Assert.fail("CA MARCHE PAS");
        }
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
