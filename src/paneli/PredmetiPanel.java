/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paneli;

import paneli.modeli.PredmetiListModel;

/**
 *
 * @author Mihailo
 */
public class PredmetiPanel extends javax.swing.JPanel {

    private PredmetiListModel model;
    
    /**
     * Creates new form PredmetiPanel
     */
    public PredmetiPanel() {
        initComponents();
    }

    public PredmetiPanel(PredmetiListModel model) {
        initComponents();
        this.model = model;
        predmetiLista.setModel(model);
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNorth = new javax.swing.JPanel();
        pnlcenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        predmetiLista = new javax.swing.JList();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        pnlcenter.setLayout(new java.awt.BorderLayout());

        predmetiLista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(predmetiLista);

        pnlcenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(pnlcenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnlcenter;
    private javax.swing.JList predmetiLista;
    // End of variables declaration//GEN-END:variables
}
