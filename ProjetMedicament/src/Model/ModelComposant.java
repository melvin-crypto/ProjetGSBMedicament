/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Composant;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author paulb
 */
public class ModelComposant extends AbstractTableModel{
    
    private String[] nomsColonnes = {"ID", "Nom"};
    private Vector<String[]> rows;
    private Iterable<Composant> lesComposants;

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
    
    public void loadDatas(ArrayList<Composant> lesComposants)
    {
        rows = new Vector<>();
        for(Composant compo : lesComposants)
        {
            rows.add(new String[]{String.valueOf(compo.getCodeComposant()), compo.getLibelleComposant()});
        }
        fireTableChanged(null);
    }
    
}
