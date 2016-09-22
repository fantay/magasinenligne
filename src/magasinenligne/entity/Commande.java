/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magasinenligne.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Laurent-LIM
 */
@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*
        enumeration du statut de la commande
     */
    public enum StatutCommande {
        En_Cours, Terminer, Payer, Livrer
    }

    /*
        variables
     */
    private String moyenDePaiment;
    private Integer prixTotal;
    private String modeDeLivraison;
    private Integer fraisDePort;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEtHeureCommande;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateLivraison;

    @Embedded
    private Adresse adresseLivraison;

    @Enumerated(EnumType.STRING)
    private StatutCommande statutCommande;
    
    // ajout de la cle etrangere de la table client avec la relation
    @JoinColumn(name = "id_client")
    @ManyToOne
    private Client client;

    
    public String getMoyenDePaiment() {
        return moyenDePaiment;
    }

    public void setMoyenDePaiment(String moyenDePaiment) {
        this.moyenDePaiment = moyenDePaiment;
    }

    public Integer getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Integer prixTotal) {
        this.prixTotal = prixTotal;
    }

    public String getModeDeLivraison() {
        return modeDeLivraison;
    }

    public void setModeDeLivraison(String modeDeLivraison) {
        this.modeDeLivraison = modeDeLivraison;
    }

    public Integer getFraisDePort() {
        return fraisDePort;
    }

    public void setFraisDePort(Integer fraisDePort) {
        this.fraisDePort = fraisDePort;
    }

    public Date getDateEtHeureCommande() {
        return dateEtHeureCommande;
    }

    public void setDateEtHeureCommande(Date dateEtHeureCommande) {
        this.dateEtHeureCommande = dateEtHeureCommande;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Adresse getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(Adresse adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public StatutCommande getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(StatutCommande statutCommande) {
        this.statutCommande = statutCommande;
    }

    public Client getClient() {
        return client;
    }

    /*
    getter & setter
     */
    public void setClient(Client client) {    
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "magasinenligne.entity.Commande[ id=" + id + " ]";
    }

}
