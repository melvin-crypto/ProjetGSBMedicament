/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.Utilisateur;
import java.util.ArrayList;
import Entity.Medicament;
import Entity.Composant;

public interface IMetier 
{
    public ArrayList<Utilisateur> GetAllUsers(String mail, String mdp);
    public Composant UpdateUnComposant(int cmpCode, String libelle);
    public void createUnUser(String nom, String prenom, String sexe, String adresse, int CodePostal, String ville, long telephone, String mail, String mdp);
    public Utilisateur GetUnUser(String mail, String mdp); 
    
    public ArrayList<Composant> GetAllComposants();
    public ArrayList<Medicament> GetAllMedicaments();
    public ArrayList<Composant> GetAllComposantsByMedicament(int code);
    public void insertComposant(Composant unComposant);
    public int getLastCode();
    public void modifierComposantMedicament(int cmpCode, int depotLegal);
    public ArrayList<Composant> GetAllComposantsForOneMed(int depotLegal);
    public ArrayList<Composant> GetAllComposantRestant(int depotLegal);
    public void insertComposantMed(int depotLegal, int cmpCode);
    public ArrayList<Medicament> GetAllTypeMedicament(int depotLegal);
    public ArrayList<Medicament> GetAllTypePasMedicament(int depotLegal);
 public void insertTypeMedicament(int depotLegal,int preCode);


}
