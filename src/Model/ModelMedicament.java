/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Medicament;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author noasillam
 */
public class ModelMedicament extends AbstractTableModel {
    
    private String[] nomsColonnes = {"Code", "Nom", "Depot Legal", "effet"};
    private Vector<String[]> rows;
    private Iterable<Medicament> lesMedicaments;

   
    public int getRowCount() {
        return rows.size();
    }

   
    public int getColumnCount() {
        return nomsColonnes.length;
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }

    
    public String getColumnName(int column) {
        return nomsColonnes[column]; 
    }
    
        public void loadDatas(ArrayList<Medicament> lesMedicaments)
    {
        rows = new Vector<>();
        for(Medicament med : lesMedicaments)
        {
            rows.add(new String[]{String.valueOf(med.getCode()), med.getNom(), String.valueOf(med.getDepotLegal()) , med.getEffet() });
        }
        fireTableChanged(null);
    }
    
    
}
