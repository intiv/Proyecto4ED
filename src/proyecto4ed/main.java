package proyecto4ed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    ArrayList<Human> personas;
    ArrayList<Set> sets;
    boolean OneCouple;
    int n;

    public main() {
        initComponents();
        personas = new ArrayList();
        sets = new ArrayList();
        try {
            n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos integrantes desea por grupo?"));
            String op2 = JOptionPane.showInputDialog("Desea limitar una pareja por grupo? (Si/No)");
            OneCouple = (op2.equals("Si") || op2.equals("si"));
        } catch (InputMismatchException e) {
            n = 5;
            OneCouple = true;
            JOptionPane.showMessageDialog(null, "Ingresó un input incorrecto. Se asignaron valores por default (5 persoans maximo y 1 pareja por grupo");
        }

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
            String desktop = System.getProperty("user.home");
            JFileChooser chooser = new JFileChooser(desktop + "/Desktop");
            chooser.setAcceptAllFileFilterUsed(false);
            FileFilter filter = new FileNameExtensionFilter(null, "txt");
            chooser.setFileFilter(filter);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                if (chooser.getSelectedFile().getName().endsWith(".txt")) {
                    File file = chooser.getSelectedFile();
                    try (FileReader in = new FileReader(file); BufferedReader reader = new BufferedReader(in)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains(" y ")) {
                                String[] names = line.split(" y ");
                                Couple pareja = new Couple(names[0], names[1], 0);
                                personas.add(pareja);
                            } else {
                                Person persona = new Person(line, 0);
                                personas.add(persona);
                            }
                        }
                        int nSets = (int) Math.ceil(personas.size() / n);
                        System.out.println(nSets);
                        for (int i = 0; i < nSets; i++) {
                            sets.add(new Set(n));
                        }
                        while (!personas.isEmpty() && !sets.isEmpty()) {
                            Random rand = new Random();
                            int cualpersona = rand.nextInt(personas.size());
                            int index = rand.nextInt(sets.size());
                            System.out.println("Curr person " + personas.get(cualpersona) + " index: " + index + " cp: " + cualpersona);
                            if (personas.get(cualpersona) instanceof Couple && OneCouple) {
                                if (sets.get(index).CoupleFits(OneCouple)) {
                                    System.out.println(personas.get(cualpersona) + " entro a couple y onecouple");
                                    if (!sets.get(index).contains(personas.get(cualpersona))) {
                                        if (sets.get(index).add(personas.get(cualpersona), false)) {
                                            personas.remove(cualpersona);
                                            sets.get(index).get(sets.get(index).size() - 1).reduce();
                                        }
                                    
                                    }
                                }else if (allSetsFull(sets, personas.get(cualpersona), n) && !allCoupleSlotsTaken(sets)) {
                                    System.out.println(personas.get(cualpersona) + " entro a !allcoupleslottaken");
                                    boolean forced = false;
                                    while (!forced) {
                                        int which = rand.nextInt(sets.size());
                                        if (sets.get(which).CoupleSlotAvailable()) {
                                            
                                            Human h1 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                            Human h2 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                            personas.get(cualpersona).reduce();
                                            if (sets.get(which).add(personas.get(cualpersona), true)) {
                                                personas.remove(cualpersona);
                                                personas.add(h1);
                                                personas.add(h2);
                                                forced = true;
                                            }
                                        }
                                    }
                                } else if (allSetsFull(sets, personas.get(cualpersona), n) && allCoupleSlotsTaken(sets)) {
                                    System.out.println(personas.get(cualpersona) + " entro a allcoupleslottaken");
                                    boolean forced = false;
                                    while (!forced) {
                                        int which = rand.nextInt(sets.size());
                                        Human h1 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                        Human h2 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                        personas.get(cualpersona).reduce();
                                        if (sets.get(which).add(personas.get(cualpersona), true)) {
                                            personas.remove(cualpersona);
                                            personas.add(h1);
                                            personas.add(h2);
                                            forced = true;
                                        }
                                    }
                                }
                            }else if (personas.get(cualpersona) instanceof Couple && !OneCouple) {
                                if(!allSetsFull(sets,personas.get(cualpersona),n)){
                                    if (sets.get(index).CoupleFits(OneCouple)) {
                                        System.out.println(personas.get(cualpersona) + " entro al else !onecouple");
                                        if (!sets.get(index).contains(personas.get(cualpersona))) {
                                            if (sets.get(index).add(personas.get(cualpersona), false)) {
                                                personas.remove(cualpersona);
                                                sets.get(index).get(sets.get(index).size() - 1).reduce();
                                            }
                                        }
                                    }
                                }else{
                                    if(!allSetsForced(sets)){
                                        System.out.println(personas.get(cualpersona)+" couple y !allsetsforced");
                                        boolean forced=false;
                                        while (!forced) {
                                            int which = rand.nextInt(sets.size());
                                            Human h1 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                            Human h2 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                            personas.get(cualpersona).reduce();
                                            if (sets.get(which).add(personas.get(cualpersona), true)) {
                                                personas.remove(cualpersona);
                                                personas.add(h1);
                                                personas.add(h2);
                                                forced = true;
                                            }
                                        }
                                    }else{
                                        System.out.println(personas.get(cualpersona)+" couple y allsetsforced");
                                        Human h1 = sets.get(index).remove(rand.nextInt(sets.get(index).size()));
                                        Human h2 = sets.get(index).remove(rand.nextInt(sets.get(index).size()));
                                        personas.get(cualpersona).reduce();
                                        if (sets.get(index).add(personas.get(cualpersona), true)) {
                                            personas.remove(cualpersona);
                                            personas.add(h1);
                                            personas.add(h2);
                                        }
                                    }
                                }
                            }else if(personas.get(cualpersona) instanceof Person){    
                                        
                                if (sets.get(index).people() < n) {
                                    System.out.println(personas.get(cualpersona) + " entro al primer if de person");
                                    if (!sets.get(index).contains(personas.get(cualpersona))) {
                                        if (sets.get(index).add(personas.get(cualpersona), false)) {
                                            personas.remove(cualpersona);
                                            //sets.get(index).get(sets.get(index).size() - 1).reduce();
                                        }
                                    }
                                }else if(allSetsFull(sets,personas.get(cualpersona),n) && !allSetsForced(sets)){
                                    int which=LowestPackedUnforcedSet(sets);
                                    System.out.println(personas.get(cualpersona)+" entro al primer else de person");                                   
                                    System.out.println(which);
                                    if(which!=-1){
                                        if(sets.get(index).add(personas.get(cualpersona), true)){
                                            personas.remove(cualpersona);
                                        }
                                    }else{
                                        which=LowestPackedSet(sets);
                                        if(which!=-1){
                                            if(sets.get(index).add(personas.get(cualpersona), true))
                                                personas.remove(cualpersona);
                                        }
                                    }
                                }else if (allSetsFull(sets, personas.get(cualpersona), n) && allSetsForced(sets)) {
                                    System.out.println(personas.get(cualpersona) + " entro al ultimo else de person");
                                    int which = LowestPackedSet(sets);                                       
                                    System.out.println(personas.get(cualpersona)+", "+which+"");  
                                    if(which!=-1)
                                        if (sets.get(which).add(personas.get(cualpersona), true))                                          
                                            personas.remove(cualpersona);   
                                                                            
                                } 
                            }
                        }
                        File dir = new File("./Sets.txt");
                        if (dir.exists()) {
                            dir.delete();
                        }
                        try (FileWriter out = new FileWriter(dir); BufferedWriter writer = new BufferedWriter(out)) {
                            System.out.println("People");
                            for (int i = 0; i < sets.size(); i++) {
                                System.out.println("Set " + i);
                                for (int j = 0; j < sets.get(i).size(); j++) {
                                    System.out.println(sets.get(i).get(j));
                                }
                            }
                            for (int i = 0; i < sets.size(); i++) {
                                writer.write("Set " + i + "\n");
                                for (int j = 0; j < sets.get(i).size(); j++) {
                                    writer.write(sets.get(i).get(j).toString() + "\n");
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Archivo incorrecto. Solo se aceptan archivos txt!");
                }
            }
        } catch (IOException | NullPointerException e) {

        }
    }//GEN-LAST:event_bLoadMouseClicked

    public static boolean allSetsFull(ArrayList<Set> sets, Human current, int n) {
        if(current instanceof Person){
            for (Set set: sets) {
                if (set.people() < n) {
                    return false;
                }
            }
        }else{
            for (Set set: sets) {
                if(set.people()<n-1)
                    return false;
            }
        }
        return true;
    }

    public static boolean allCoupleSlotsTaken(ArrayList<Set> sets) {
        for (int i = 0; i < sets.size(); i++) {
            if (sets.get(i).CoupleSlotAvailable()) {
                return false;
            }
        }
        return true;
    }

    public static boolean allSetsForced(ArrayList<Set> sets) {
        for (Set set : sets) {
            if (!set.Forced()) {
                return false;
            }
        }
        return true;
    }

    public static int LowestPackedSet(ArrayList<Set> sets){
        int min=sets.get(0).people();
        int retVal=-1;
        for (int i = 0; i < sets.size(); i++) {
            if(sets.get(i).people()<=min){
                min=sets.get(i).people();
                retVal=i;
            }
        }
        return retVal;
    }
    
    public static int LowestPackedUnforcedSet(ArrayList<Set> sets){
        int min=-1;
        int retVal=-1;
        for (int i = 0; i < sets.size(); i++) {
            if(!sets.get(i).Forced()){
                min=sets.get(i).people();
                retVal=i;
                i=sets.size();
            }
        }
        if(min!=-1){
            for (int j = 0; j < sets.size(); j++) {
                if(!sets.get(j).Forced()){
                    if(sets.get(j).people()<min){
                        min=sets.get(j).people();
                        retVal=j;
                    }
                }
            }
        }
        return retVal;
        
    }
    
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
        java.awt.EventQueue.invokeLater(() -> {
            new main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLoad;
    // End of variables declaration//GEN-END:variables
}
