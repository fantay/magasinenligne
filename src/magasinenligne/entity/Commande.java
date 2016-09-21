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

    /*
        getter & setter
     */
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
