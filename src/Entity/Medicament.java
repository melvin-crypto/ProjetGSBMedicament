/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author noasillam
 */
public class Medicament {
    
    private int depotLegal;
    private String nom;
    private int code;
    private String effet;
    private String type;
    private int preCode;
    
    public Medicament( int unDepotLegal, String unNom, int unCode, String unEffet)
    {
        depotLegal = unDepotLegal;
        nom = unNom;
        code = unCode;
        effet = unEffet;
    }
      public Medicament( int unDepotLegal, String unNom, int unCode, String unEffet, String unType)
    {
        depotLegal = unDepotLegal;
        nom = unNom;
        code = unCode;
        effet = unEffet;
        type=unType;
    }

    public Medicament(int preCode,String type) {
        this.preCode=preCode;
        this.type = type;
    }

    public Medicament(String type) {
        this.type = type;
    }

  

    /**
     * @return the depotLegal
     */
    public int getDepotLegal() {
        return depotLegal;
    }

    /**
     * @param depotLegal the depotLegal to set
     */
    public void setDepotLegal(int depotLegal) {
        this.depotLegal = depotLegal;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the effet
     */
    public String getEffet() {
        return effet;
    }

    /**
     * @param effet the effet to set
     */
    public void setEffet(String effet) {
        this.effet = effet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPreCode() {
        return preCode;
    }

    public void setPreCode(int preCode) {
        this.preCode = preCode;
    }
    
    
    
}
