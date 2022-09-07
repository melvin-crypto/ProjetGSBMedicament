/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author paulb
 */
public class Composant {
    
    private int codeComposant;
    private String libelleComposant;
    
    public Composant ( int unCode, String unLibelle)
    {
        codeComposant = unCode;
        libelleComposant = unLibelle;
    }

    public Composant(ArrayList<Composant> GetAllComposantsByMedicament) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public int getCodeComposant() {
        return codeComposant;
    }

    /**
     * @param codeComposant the codeComposant to set
     */
    public void setCodeComposant(int codeComposant) {
        this.codeComposant = codeComposant;
    }

    /**
     * @return the libelleComposant
     */
    public String getLibelleComposant() {
        return libelleComposant;
    }

    /**
     * @param libelleComposant the libelleComposant to set
     */
    public void setLibelleComposant(String libelleComposant) {
        this.libelleComposant = libelleComposant;
    }
}
