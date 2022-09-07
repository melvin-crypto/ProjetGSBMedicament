/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Medicament;
import Entity.Utilisateur;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jacqu
 */
public class ModelTypeExistant extends AbstractTableModel
{
    private String[] nomsColonnes = {"preCode","Libelle"};
    private Vector<String[]> rows;
    private Iterable<Medicament> lesTypeMedicament;

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
    
    public void loadDatas(ArrayList<Medicament> lesTypeMedicament)
    {
        rows = new Vector<>();
        for(Medicament med : lesTypeMedicament)
        {
            rows.add(new String[]{String.valueOf(med.getPreCode()),String.valueOf(med.getType())});
        }
        fireTableChanged(null);
    }
}
