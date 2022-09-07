/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.Utilisateur;
import Vue.FrmModifierMedicamentComposant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pbecue
 */
public class FonctionsMetier implements IMetier
{
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
            PreparedStatement ps = cnx.prepareStatement("select cmpCode, libelle from Composant ");
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
            PreparedStatement ps = cnx.prepareStatement("select depotLegal, nom, code, effets from medicament ");
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


    /*@Override
    public void insertTypeMedicament(int depotLegal,int libelle) {
    try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into formuler(depotLegal,preCode) values('"+depotLegal+"''"+libelle+"')");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }    }
   
 
    */
    
    
    
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
     
     public void insertComposantMed(int depotLegal,int cmpCode) {
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into constituer(constituer.depotLegal, constituer.cmpCode) values ("+cmpCode+","+depotLegal+")");          
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

    public void createUnUserNs(String text, String text0, String toString, String text1, int parseInt, String text2, int parseInt0, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
