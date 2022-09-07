/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


public class Utilisateur {
    
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
    private int CodePostal;
    private String ville;
    private int telephone;
    private String mail;
    private String mdp;

    public Utilisateur(int id, String nom, String prenom, String sexe, String adresse, int CodePostal, String ville, int telephone, String mail, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.CodePostal = CodePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.mail = mail;
        this.mdp = mdp;
    }
    public Utilisateur(String mail, String mdp) {
        this.mail = mail;
        this.mdp = mdp;
    }
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String isSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(int CodePostal) {
        this.CodePostal = CodePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    
    
}
