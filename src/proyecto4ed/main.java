package proyecto4ed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    ArrayList<Human> personas;
    ArrayList<Set> sets;
    boolean OneCouple;
    int n;
    Graph grafo;

    public main() {
        initComponents();
        personas = new ArrayList();
        sets = new ArrayList();
        grafo = new MultiGraph("Casas conocidas");
        grafo.setStrict(false);

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
        bGenerate = new javax.swing.JButton();
        bDraw = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bLoad.setText("Cargar datos de txt");
        bLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLoadMouseClicked(evt);
            }
        });

        bGenerate.setText("Generar Sets");
        bGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bGenerateMouseClicked(evt);
            }
        });

        bDraw.setText("Visualizar Grafo");
        bDraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bDrawMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(bLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLoadMouseClicked
        try {
            if (personas.isEmpty()) {
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
                            int people = 0;
                            while ((line = reader.readLine()) != null) {
                                if (line.contains(" y ")) {
                                    String[] names = line.split(" y ");
                                    Couple pareja = new Couple(names[0], names[1], 0);
                                    personas.add(pareja);
                                    people += 2;
                                } else {
                                    Person persona = new Person(line, 0);
                                    personas.add(persona);
                                    people++;
                                }
                            }
                            for (Human persona : personas) {
                                if (grafo.getNode(persona.getName()) == null) {
                                    grafo.addNode(persona.getName()).addAttribute("ui.label", persona.getName());
                                }
                            }
                            int nSets = (int) Math.ceil(people / n);

                            System.out.println(nSets + " para " + people);
                            for (int i = 0; i < nSets; i++) {
                                sets.add(new Set(n));
                            }

                            JOptionPane.showMessageDialog(this, "Los datos fueron cargados con exito!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Archivo incorrecto. Solo se aceptan archivos txt!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ya hay datos cargados");
            }
        } catch (IOException | NullPointerException e) {
            sets.clear();
            personas.clear();
            JOptionPane.showMessageDialog(this, "Ocurrio un error durante la carga de datos.\nIntente de nuevo y asegurese de seleccionar un archivo txt con el formato correcto");
        }
    }//GEN-LAST:event_bLoadMouseClicked

    private void bGenerateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bGenerateMouseClicked
        try {
            long cont=0;
            if (!personas.isEmpty()) {
                for (Set set : sets) {

                    set.clear();
                }
                for (Human persona : personas) {
                    persona.SetAdded(false);
                }
                Collections.shuffle(personas);
                while (!AllPeopleAdded(personas)) {
                    Random rand = new Random();
                    boolean validIndex = false;
                    int cualpersona = -1;
                    while (!validIndex) {
                        cualpersona = rand.nextInt(personas.size());
                        if (!personas.get(cualpersona).isAdded()) 
                            validIndex = true;
                        

                    }
                    cont++;
                    if(cont>Math.pow(personas.size(), 10)){
                        System.out.println("Hizo break en "+personas.get(cualpersona));
                        break;
                        
                    }    
                    int index = rand.nextInt(sets.size());
                    if (cualpersona != -1) {
                        System.out.println("Curr person " + personas.get(cualpersona) + " index: " + index + " cp: " + cualpersona);
                        if (personas.get(cualpersona) instanceof Couple && OneCouple) {
                            System.out.println("Entro a couples && onecouple");
                            if (sets.get(index).CoupleFits(OneCouple)) {
                                System.out.println(personas.get(cualpersona) + " entro a couple y onecouple");
                                if (!sets.get(index).contains(personas.get(cualpersona))) {
                                    if (sets.get(index).add(personas.get(cualpersona), false)) {
                                        personas.get(cualpersona).SetAdded(true);
                                        if (sets.get(index).size() > 1) {
                                            personas.get(cualpersona).reduce();
                                        }
                                    }
                                }
                            } else if (allSetsFull(sets, personas.get(cualpersona), n) && !allCoupleSlotsTaken(sets)) {
                                System.out.println(personas.get(cualpersona) + " entro a !allcoupleslottaken");
                                boolean forced = false;
                                while (!forced) {
                                    int which = rand.nextInt(sets.size());
                                    if (sets.get(which).CoupleSlotAvailable()) {
                                        Human h1 = null;
                                        while (!forced) {
                                            h1 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                            if (h1 instanceof Person) {
                                                forced = true;
                                            } else {
                                                sets.get(which).reinsert(h1);
                                            }

                                        }
                                        forced = false;
                                        Human h2 = null;
                                        while (!forced) {
                                            h2 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                            if (h2 instanceof Person) {
                                                forced = true;
                                            } else {
                                                sets.get(which).reinsert(h2);
                                            }
                                        }
                                        forced = false;
                                        if (h1 != null && h2 != null) {
                                            if (sets.get(which).add(personas.get(cualpersona), true)) {
                                                personas.get(cualpersona).reduce();
                                                personas.get(cualpersona).SetAdded(true);
                                                personas.get(personas.indexOf(h1)).SetAdded(false);
                                                personas.get(personas.indexOf(h2)).SetAdded(false);
                                                forced = true;
                                            }
                                        }
                                    }
                                }
                            } else if (allSetsFull(sets, personas.get(cualpersona), n) && allCoupleSlotsTaken(sets)) {
                                System.out.println(personas.get(cualpersona) + " entro a allcoupleslottaken");
                                boolean forced = false;
                                while (!forced) {
                                    int which = rand.nextInt(sets.size());

                                    Human h1 = null;
                                    while (!forced) {
                                        h1 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                        if (h1 instanceof Person) {
                                            forced = true;
                                        } else {
                                            sets.get(which).reinsert(h1);
                                        }

                                    }
                                    forced = false;
                                    Human h2 = null;
                                    while (!forced) {
                                        h2 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                        if (h2 instanceof Person) {
                                            forced = true;
                                        } else {
                                            sets.get(which).reinsert(h2);
                                        }
                                    }
                                    forced = false;

                                    if (h1 != null && h2 != null) {
                                        if (sets.get(which).add(personas.get(cualpersona), true)) {
                                            personas.get(cualpersona).reduce();
                                            personas.get(cualpersona).SetAdded(true);
                                            personas.get(personas.indexOf(h1)).SetAdded(false);
                                            personas.get(personas.indexOf(h2)).SetAdded(false);
                                            forced = true;
                                        }
                                    }
                                }
                            }else if (cont > 300){
                                if(!personas.get(cualpersona).isAdded()){
                                    personas.get(cualpersona).SetAdded(true);
                                    personas.get(cualpersona).reduce();
                                    sets.get(index).reinsert(personas.get(cualpersona));
                                
                                cont=0;
                                }
                            }
                        } else if (personas.get(cualpersona) instanceof Couple && !OneCouple) {
                            System.out.println(personas.get(cualpersona)+" entro a couple y !onecouple");
                            if (!allSetsFull(sets, personas.get(cualpersona), n)) {
                                if (sets.get(index).CoupleFits(OneCouple)) {
                                    System.out.println(personas.get(cualpersona) + " entro al else !onecouple");

                                    if (!sets.get(index).contains(personas.get(cualpersona))) {
                                        if (sets.get(index).add(personas.get(cualpersona), false)) {
                                            if (sets.get(index).people() > 1) {
                                                personas.get(cualpersona).reduce();
                                            }
                                            personas.get(cualpersona).SetAdded(true);

                                        }
                                    }
                                }
                            } else if (!allSetsForced(sets)) {
                                System.out.println(personas.get(cualpersona) + " couple y !allsetsforced");
                                boolean forced = false;
                                while (!forced) {
                                    int which = rand.nextInt(sets.size());
                                    Human h1 = null;
                                    while (!forced) {
                                        h1 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                        if (h1 instanceof Person) {
                                            forced = true;
                                        } else {
                                            sets.get(which).reinsert(h1);
                                        }

                                    }
                                    forced = false;
                                    Human h2 = null;
                                    while (!forced) {
                                        h2 = sets.get(which).remove(rand.nextInt(sets.get(which).size()));
                                        if (h2 instanceof Person) {
                                            forced = true;
                                        } else {
                                            sets.get(which).reinsert(h2);
                                        }
                                    }
                                    forced = false;
                                    if (h1 != null && h2 != null) {
                                        if (sets.get(which).add(personas.get(cualpersona), true)) {
                                            personas.get(cualpersona).reduce();
                                            personas.get(cualpersona).SetAdded(true);
                                            personas.get(personas.indexOf(h1)).SetAdded(false);
                                            personas.get(personas.indexOf(h2)).SetAdded(false);
                                            forced = true;
                                        }
                                    }
                                }
                            } else {
                                System.out.println(personas.get(cualpersona) + " couple y allsetsforced");
                                boolean valid = false;

                                Human h1 = null;
                                while (!valid) {
                                    h1 = sets.get(index).remove(rand.nextInt(sets.get(index).size()));
                                    if (h1 instanceof Person) {
                                        valid = true;
                                    } else {
                                        sets.get(index).reinsert(h1);
                                    }
                                }
                                valid = false;
                                Human h2 = null;
                                while (!valid) {
                                    h2 = sets.get(index).remove(rand.nextInt(sets.get(index).size()));
                                    if (h2 instanceof Person) {
                                        valid = true;
                                    } else {
                                        sets.get(index).reinsert(h2);
                                    }
                                }
                                if (h1 != null && h2 != null) {
                                    if (sets.get(index).add(personas.get(cualpersona), true)) {
                                        personas.get(cualpersona).reduce();
                                        personas.get(cualpersona).SetAdded(true);
                                        personas.get(personas.indexOf(h1)).SetAdded(false);
                                        personas.get(personas.indexOf(h2)).SetAdded(false);
                                    }
                                }
                            }
                        } else if (personas.get(cualpersona) instanceof Person) {

                            if (sets.get(index).people() < n) {
                                System.out.println(personas.get(cualpersona) + " entro al primer if de person");
                                if (!sets.get(index).contains(personas.get(cualpersona))) {
                                    if (sets.get(index).add(personas.get(cualpersona), false)) {
                                        if (sets.get(index).people() > 1) {
                                            personas.get(cualpersona).reduce();
                                        }
                                        personas.get(cualpersona).SetAdded(true);
                                        //sets.get(index).get(sets.get(index).size() - 1).reduce();
                                    }
                                }
                            } else if (allSetsFull(sets, personas.get(cualpersona), n) && !allSetsForced(sets)) {
                                int which = LowestPackedUnforcedSet(sets);
                                System.out.println(personas.get(cualpersona) + " entro al primer else de person");
                                System.out.println(which);
                                if (which != -1) {
                                    if (sets.get(index).add(personas.get(cualpersona), true)) {
                                        personas.get(cualpersona).SetAdded(true);
                                        personas.get(cualpersona).reduce();
                                    }
                                } else {
                                    which = LowestPackedSet(sets);
                                    if (which != -1) {
                                        if (sets.get(index).add(personas.get(cualpersona), true)) {
                                            personas.get(cualpersona).SetAdded(true);
                                            personas.get(cualpersona).reduce();
                                        }
                                    }
                                }
                            } else if (allSetsFull(sets, personas.get(cualpersona), n) && allSetsForced(sets)) {
                                System.out.println(personas.get(cualpersona) + " entro al ultimo else de person");
                                int which = LowestPackedSet(sets);
                                System.out.println(personas.get(cualpersona) + ", " + which + "");
                                if (which != -1) {
                                    if (sets.get(which).add(personas.get(cualpersona), true)) {
                                        personas.get(cualpersona).SetAdded(true);
                                        personas.get(cualpersona).reduce();
                                    }
                                }
                            }
                        }
                    }
                }
                for (Set set : sets) {
                    for (int i = 1; i < set.size(); i++) {
                        if (grafo.getNode(set.get(0).getName()) != null && grafo.getNode(set.get(i).getName()) != null) {
                            if (!personas.get(personas.indexOf(set.get(i))).knows(set.get(0)) && grafo.getEdge(set.get(i).getName() + set.get(0).getName()) == null) {
                                personas.get(personas.indexOf(set.get(i))).meet(set.get(0));
                                Node nodo1 = grafo.getNode(set.get(i).getName());
                                Node nodo2 = grafo.getNode(set.get(0).getName());
                                grafo.addEdge(nodo1.getId() + nodo2.getId(), nodo1, nodo2, true);
                            }

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
                        System.out.println("Set " + i + " size: " + sets.get(i).size());
                        for (int j = 0; j < sets.get(i).size(); j++) {
                            System.out.println(sets.get(i).get(j).toString());
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
        } catch (NullPointerException | IOException e) {
            sets.clear();
            JOptionPane.showMessageDialog(this, "Ocurrio un error creando los sets, vuelva a intentar");
            e.printStackTrace();
        }
    }//GEN-LAST:event_bGenerateMouseClicked

    private void bDrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDrawMouseClicked
        if (grafo.getEachNode() != null) {
            grafo.display(true).setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        }
    }//GEN-LAST:event_bDrawMouseClicked

    public static boolean allSetsFull(ArrayList<Set> sets, Human current, int n) {
        if (current instanceof Person) {
            for (Set set : sets) {
                if (set.people() < n) {
                    return false;
                }
            }
        } else {
            for (Set set : sets) {
                if (set.people() < n - 1) {
                    return false;
                }
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

    public static int LowestPackedSet(ArrayList<Set> sets) {
        int min = sets.get(0).people();
        int retVal = -1;
        for (int i = 0; i < sets.size(); i++) {
            if (sets.get(i).people() <= min) {
                min = sets.get(i).people();
                retVal = i;
            }
        }
        return retVal;
    }

    public static int LowestPackedUnforcedSet(ArrayList<Set> sets) {
        int min = -1;
        int retVal = -1;
        for (int i = 0; i < sets.size(); i++) {
            if (!sets.get(i).Forced()) {
                min = sets.get(i).people();
                retVal = i;
                i = sets.size();
            }
        }
        if (min != -1) {
            for (int j = 0; j < sets.size(); j++) {
                if (!sets.get(j).Forced()) {
                    if (sets.get(j).people() < min) {
                        min = sets.get(j).people();
                        retVal = j;
                    }
                }
            }
        }
        return retVal;

    }

    public boolean AllPeopleAdded(ArrayList<Human> personas) {
        for (Human persona : personas) {
            if (!persona.isAdded()) {
                return false;
            }
        }
        return true;
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
    private javax.swing.JButton bDraw;
    private javax.swing.JButton bGenerate;
    private javax.swing.JButton bLoad;
    // End of variables declaration//GEN-END:variables
}
