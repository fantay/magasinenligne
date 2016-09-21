/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magasinenligne.entity;

import javax.persistence.Embeddable;

/**
 *
 * @author Laurent-LIM
 */
@Embeddable
public class Adresse {

    private String rue;
    private Integer numero;
    private Integer codepostal;
    private String ville;
    private String pays;
}
