/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JacquesBuffeteau
 */
public class ConnexionBdd
{
    // Mon objet connexion
    private static Connection cnx;

    public ConnexionBdd() {
        
        
               
        try {
            String pilote = "com.mysql.jdbc.Driver";
            // chargement du pilote
            Class.forName(pilote);
            // L'objet connexion à la BDD avec le nom de la base, le user et le password
//            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation_medicament?serverTimezone="
//                    + TimeZone.getDefault().getID(), "root", "");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation_medicament3?useSSL=false"
                   , "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
      
        
    public static Connection getCnx() {
        return cnx;
    }
}
