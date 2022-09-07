/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.IMetier;
import Entity.Medicament;
import Entity.Utilisateur;
import Entity.Utilisateur;
import Vue.FrmModifierMedicamentComposant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pbecue
 */
public class FonctionsMetier implements IMetier
{
    
    /**
     * 
     * @param mail 
     * prend en paramètre le mail de l'utilsateur
     * @param mdp
     * prend en paramètre le mot de passe de l'utilsateur
     * @return 
     * un utilisateur avec en paramètre son mail et son mot de passe
     */
   
   
    
    @Override
    public Utilisateur GetUnUser(String mail, String mdp)
    {
        Utilisateur unUser = null;
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select adresseMail,mdp from inscription where adresseMail = '"+mail+"' and mdp = '"+mdp+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                unUser = new Utilisateur(rs.getString("adresseMail"),rs.getString("mdp"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unUser;
    }

    @Override
    public ArrayList<Utilisateur> GetAllUsers(String mail, String mdp) {
                ArrayList<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();

        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select idUser, nomUser,prenomUser, statutUser from users where loginUser = '"+mail+"' and pwdUser = '"+mdp+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
               
             for(Utilisateur u : lesUtilisateurs){
            
                 lesUtilisateurs.add(u);
             }
                
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesUtilisateurs;
    }
    
    /**
     * 
     * @param nom
     * nom de l'utilisateur
     * @param prenom
     * prénom de l'utilisateur
     * @param sexe
     * sexe de l'utilisateur
     * @param adresse
     * adresse de l'utilisateur
     * @param codePostal
     * code postal de l'utilisateur
     * @param ville
     * ville de l'utilisateur
     * @param telephone
     * numéro de téléphone de l'utilisateur
     * @param mail
     * mail du l'utilisateur(identifiant)
     * @param mdp 
     *  mot de passe de l'utilisateur   
     * @docRoot  
     * permet de créer un utilisateur grâce à tous ces paramètres.
     */
    
    
    
    @Override
    public void createUnUser(String nom, String prenom, String sexe, String adresse, int codePostal, String ville, long telephone, String mail, String mdp) {
    
       
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into inscription values (null,'"+nom+"','"+prenom+"','"+sexe+"','"+adresse+"',"+codePostal+",'"+ville+"','"+telephone+"','"+mail+"','"+mdp+"')");
            ps.executeUpdate();       
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
    
    
    
    
    public ArrayList<Composant> GetAllComposants()
    {
        ArrayList<Composant> lesComposants = new ArrayList<>();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select cmpCode, libelle from Composant order by cmpCode ASC");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Composant unComposant = new Composant(rs.getInt("cmpCode"), rs.getString("libelle"));
                lesComposants.add(unComposant);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesComposants;    
    }
    
    
    
    
    
    
    @Override
    public Composant UpdateUnComposant(int cmpCode, String libelle) {
    
        Composant UpdateUnComposant = null;
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("update composant set libelle='"+libelle+"' where cmpCode='"+cmpCode+"'");
            int rs = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return UpdateUnComposant;    
    }
    
    
    
    public ArrayList<Medicament> GetAllMedicaments()
    {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select depotLegal, nom, code, effets from medicament order by code ASC");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Medicament unMedicament = new Medicament(rs.getInt("depotLegal"), rs.getString("nom"), rs.getInt("code"), rs.getString("effets"));
                lesMedicaments.add(unMedicament);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;    
    }

       public ArrayList<Composant> GetAllComposantRestant(int depotLegal)
    {
        ArrayList<Composant> lesComposants = new ArrayList<>();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select distinct composant.cmpCode, composant.libelle from composant inner join constituer on composant.cmpCode=constituer.cmpCode where composant.cmpCode not in(select composant.cmpCode from composant inner join constituer on composant.cmpCode=constituer.cmpCode where depotLegal='"+depotLegal+"')");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Composant unComposant = new Composant(rs.getInt("cmpCode"), rs.getString("libelle"));
                lesComposants.add(unComposant);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesComposants;    
    }
    
    
    public ArrayList<Composant> GetAllComposantsByMedicament(int code)
    {
        ArrayList<Composant> lesComposants = new ArrayList<>();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select code, libelle from Composant inner join medicament on composant.cmpCode = medicament.code where code = ?");
            ps.setInt(1, code);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Composant unComposant = new Composant(rs.getInt("code"),rs.getString("libelle"));
                lesComposants.add(unComposant);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesComposants;
    }
     public void insertComposant(Composant unComposant) {
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into Composant values (?,?)");
            ps.setInt(1, unComposant.getCodeComposant());
            ps.setString(2, unComposant.getLibelleComposant());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void insertComposantMed(int depotLegal,int cmpCode, int quantite) {
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into constituer(constituer.depotLegal, constituer.cmpCode, constituer.quantite) values ("+cmpCode+","+depotLegal+","+quantite+")");          
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     
     
     public int getLastCode() {
        int lastCode = 0;
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select max(cmpCode) as num from Composant");
            ResultSet rs = ps.executeQuery();
            rs.next();
            lastCode = rs.getInt("num") + 1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastCode;
    }


    
    public void modifierComposantMedicament(int cmpCode, int depotLegal) {
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("update composant set cmpCode = "+cmpCode + " where depotLegal = "+depotLegal);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     public FrmModifierMedicamentComposant UpdateUnComposantMedicament(int Code, String libelle) 
        {
    
        FrmModifierMedicamentComposant UpdateUnComposantMedicament = null;
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("update composant set libelle='"+libelle+"' where cmpCode='"+ Code+"'");
            int rs = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return UpdateUnComposantMedicament;    
    }

        
        public ArrayList<Composant> GetAllComposantsForOneMed(int depotLegal)
    {
        ArrayList<Composant> lesComposants = new ArrayList<>();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select composant.cmpCode, composant.libelle from composant inner join constituer on composant.cmpCode=constituer.cmpCode where depotLegal='"+depotLegal+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Composant unComposant = new Composant(rs.getInt("cmpCode"), rs.getString("libelle"));
                lesComposants.add(unComposant);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesComposants;    
    }

    @Override
    public ArrayList<Medicament> GetAllTypeMedicament(int depotLegal)   {
        ArrayList<Medicament> lesTypeMedicament = new ArrayList<>();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select presentation.preCode,libelle from presentation inner join formuler on presentation.preCode=formuler.preCode inner join medicament on formuler.DepotLegal=medicament.DepotLegal where medicament.depotLegal="+depotLegal+"");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Medicament unMedicament = new Medicament(rs.getInt("preCode"),rs.getString("libelle"));
                lesTypeMedicament.add(unMedicament);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesTypeMedicament;    
    }
  
    @Override
    public ArrayList<Medicament> GetAllTypePasMedicament(int depotLegal)   {
        ArrayList<Medicament> lesTypeMedicament = new ArrayList<>();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select distinct presentation.preCode, presentation.libelle from presentation where libelle not in(select distinct presentation.libelle from presentation inner join formuler on presentation.preCode=formuler.preCode inner join medicament on formuler.depotLegal=medicament.depotLegal where libelle in(select presentation.libelle from presentation inner join formuler on presentation.preCode=formuler.preCode where medicament.depotLegal="+depotLegal+"))");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Medicament unMedicament = new Medicament(rs.getInt("preCode"),rs.getString("libelle"));
                lesTypeMedicament.add(unMedicament);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesTypeMedicament;    
    }
    
      public void insertTypeMedicament(int depotLegal,int preCode) {
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into formuler(formuler.precode, formuler.depotLegal) values ("+depotLegal+","+preCode+")");
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE//GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE 
      //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE //GRAPHIQUE 
      
      
      
      
     public HashMap<String,Integer> GetDatasGraphique1(String nomMedicament) 
    {
        // Dans cette HasMap on va stocker :
        // la clé (String) qui correspond au nom du trader
        // la valeur (Integer) qui correspond au nombre d'actions qu'il possède
        HashMap<String, Integer> datas = new HashMap();
        
         try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select constituer.quantite, composant.libelle from composant inner join constituer on composant.cmpCode= constituer.cmpCode inner join medicament on constituer.depotLegal = medicament.depotLegal where medicament.nom ='"+nomMedicament+"'");
                ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                datas.put(rs.getString(2), rs.getInt(1));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return datas;
        
            }
     public ArrayList<String> GetAllMedicamentsNom()
    {
        ArrayList<String> lesMedicaments = new ArrayList<>();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select nom from medicament");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                lesMedicaments.add(rs.getString(1));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;    
    }
      
        
        /*    public ArrayList<String> GetAllQuantite()
    {
        ArrayList<Composant> lesComposants = new ArrayList<>();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select quantite from Composant order by cmpCode ASC");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Composant unComposant = new Composant(rs.getInt("cmpCode"), rs.getString("libelle"));
                lesComposants.add(unComposant);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesComposants;    
    }*/

//    @Override
//    public ArrayList<String> GetAllQuantite() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
    public HashMap<String,Double> GetDatasGraphique2()
    {
         HashMap<String, Double> datas = new HashMap();
        try {
             Connection cnx = ConnexionBdd.getCnx();
          PreparedStatement  ps = cnx.prepareStatement("SELECT presentation.libelle, COUNT(formuler.depotLegal) as nombre\n" +
                                    "FROM presentation\n" +
                                    "inner JOIN formuler on presentation.preCode=formuler.preCode\n" +
                                    "group by presentation.libelle\n" +
                                    "ORDER by COUNT(formuler.depotLegal) ASC");
           ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                datas.put(rs.getString("libelle"), rs.getDouble("nombre"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return datas;
    }
    
    public HashMap<String,Double> GetDatasGraphique3()
    {
         HashMap<String, Double> datas = new HashMap();
        try {
             Connection cnx = ConnexionBdd.getCnx();
          PreparedStatement  ps = cnx.prepareStatement("SELECT `sexe`, count(`sexe`) as nombre FROM `inscription` group by sexe order by `sexe` ASC");
           ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                datas.put(rs.getString("sexe"), rs.getDouble("nombre"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return datas;
    }
      
      
      
      
      
      
}
