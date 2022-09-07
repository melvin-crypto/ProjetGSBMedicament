/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.FonctionsMetier;
import Entity.Utilisateur;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jacqu
 */
public class ModelUtilisateur extends AbstractTableModel
{
    private String[] nomsColonnes = {"ID", "Nom", "Prenom", "Sexe"};
    private Vector<String[]> rows;

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return nomsColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return nomsColonnes[column]; 
    }
    
    public void loadDatas(ArrayList<Utilisateur> lesUsers)
    {
        rows = new Vector<>();
        for(Utilisateur uti : lesUsers)
        {
            rows.add(new String[]{String.valueOf(uti.getId()),uti.getNom(), uti.getPrenom(), uti.isSexe()});
        }
        fireTableChanged(null);
    }
}
