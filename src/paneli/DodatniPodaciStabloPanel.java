/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneli;

import help.Cvor;
import help.Stablo;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Mihailo
 */
public class DodatniPodaciStabloPanel extends javax.swing.JPanel {

    /**
     * Creates new form KartonPredmetaPanel
     */
    public DodatniPodaciStabloPanel() {
        initComponents();
    }

    private Stablo stablo;
    private Map<Cvor, DefaultMutableTreeNode> map;

    public DodatniPodaciStabloPanel(Stablo stablo) {
        initComponents();
        map = new HashMap<>();
        this.stablo = stablo;
        kreirajStablo();
        prikaziStablo();
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
        pnlCenter = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        pnlCenter.setLayout(new java.awt.BorderLayout());
        add(pnlCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    // End of variables declaration//GEN-END:variables

    private JPanel pnlStablo;
    private JScrollPane scroll;
    private JTree stabloJTree;

    private void kreirajStablo() {

        popuniMapu(stablo.getKoren());
        kreirajStabloIzMape();
        DefaultMutableTreeNode top = map.get(stablo.getKoren());
        stabloJTree = new JTree(top);

    }

    private void popuniMapu(Cvor cvor) {
        if (cvor == null) {
            return;
        }
        ubaciUMapu(cvor, kreirajNode(cvor));
        for (Object obj : cvor.getDeca()) {
            Cvor c = (Cvor) obj;
            popuniMapu(c);
        }
    }

    private void kreirajStabloIzMape() {
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry par = (Map.Entry) iter.next();
            Cvor cvor = (Cvor) par.getKey();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) par.getValue();
            if (cvor != stablo.getKoren()) {
                Cvor roditelj = cvor.getRoditelj();
                DefaultMutableTreeNode parent = map.get(roditelj);
//                int index = roditelj.indexDeteta(cvor);
//                parent.insert(node, index);
                parent.add(node);
            }
        }
    }

    private DefaultMutableTreeNode kreirajNode(Cvor cvor) {
        return new DefaultMutableTreeNode(cvor.toString());
    }

    private void ubaciUMapu(Cvor key, DefaultMutableTreeNode val) {
        map.put(key, val);
    }

    private void prikaziStablo() {
        pnlStablo = new JPanel();
        pnlStablo.setLayout(new BorderLayout());
        scroll = new JScrollPane();
        scroll.setViewportView(stabloJTree);
        pnlStablo.add(scroll, BorderLayout.CENTER);
        pnlCenter.add(pnlStablo);
    }

}