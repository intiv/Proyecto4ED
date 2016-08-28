/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto4ed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author USUARIO-PC
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    ArrayList<Human> personas;
    ArrayList<Set> sets;

    public main() {
        initComponents();
        personas = new ArrayList();
        sets = new ArrayList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bLoad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bLoad.setText("Cargar datos de txt");
        bLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLoadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(bLoad)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(bLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLoadMouseClicked
        try {
            String dir = System.getProperty("user.home");
            JFileChooser chooser = new JFileChooser(dir + "/Desktop");
            chooser.setAcceptAllFileFilterUsed(false);
            FileFilter filter = new FileNameExtensionFilter(null, "txt");
            chooser.setFileFilter(filter);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                if (chooser.getSelectedFile().getName().endsWith(".txt")) {
                    File file = chooser.getSelectedFile();
                    FileReader in = new FileReader(file);
                    BufferedReader reader = new BufferedReader(in);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains(" y ")) {
                            String[] names = line.split(" y ");
                            Couple pareja = new Couple(names[0], names[1], 0);
                            personas.add(pareja);
                        } else {
                            Person persona = new Person(line);
                            personas.add(persona);
                        }
                    }
                    if (sets.isEmpty()) {
                        sets.add(new HashSet());
                    }
                    while (!personas.isEmpty()) {
                        Random rand = new Random();
                        int index = rand.nextInt(sets.size());
                        int cualpersona = rand.nextInt(personas.size());
                        if (sets.get(index).isEmpty()) {
                            if (personas.get(cualpersona).getBreaks() == 0) {
                                personas.get(cualpersona).setBreaks(2);
                                sets.get(index).add(personas.get(cualpersona));
                                personas.remove(cualpersona);
                            }
                        } else if (sets.get(index).size() < 4 && personas.get(cualpersona) instanceof Couple) {
                            if(!sets.get(index).contains(personas.get(cualpersona))){
                                if(personas.get(cualpersona).getBreaks()>0)
                                    personas.get(cualpersona).reduce();
                                sets.get(index).add(personas.get(cualpersona));
                                personas.remove(cualpersona);
                                
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Archivo incorrecto. Solo se aceptan archivos txt!");
                }
            }
        } catch (IOException e) {

        }
    }//GEN-LAST:event_bLoadMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLoad;
    // End of variables declaration//GEN-END:variables
}
