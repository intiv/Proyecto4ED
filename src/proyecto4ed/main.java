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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdSets = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSets = new javax.swing.JTextArea();
        bLoad = new javax.swing.JButton();
        bGenerate = new javax.swing.JButton();
        bDraw = new javax.swing.JButton();
        bVerify = new javax.swing.JButton();
        bExit = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Sets Generados");

        taSets.setColumns(20);
        taSets.setRows(5);
        jScrollPane1.setViewportView(taSets);

        javax.swing.GroupLayout jdSetsLayout = new javax.swing.GroupLayout(jdSets.getContentPane());
        jdSets.getContentPane().setLayout(jdSetsLayout);
        jdSetsLayout.setHorizontalGroup(
            jdSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdSetsLayout.createSequentialGroup()
                .addGroup(jdSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdSetsLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdSetsLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jdSetsLayout.setVerticalGroup(
            jdSetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdSetsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

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

        bVerify.setText("Verificar si todos se conocen");
        bVerify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bVerifyMouseClicked(evt);
            }
        });

        bExit.setText("Salir");
        bExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bExitMouseClicked(evt);
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
                    .addComponent(bGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bVerify)
                        .addGap(160, 160, 160))))
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
                .addGap(18, 18, 18)
                .addComponent(bVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bExit)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLoadMouseClicked
        try {
            //if(!jdSets.isVisible()){
            boolean load = true;
            if (!personas.isEmpty()) {
                int decition = JOptionPane.showConfirmDialog(this, "Si selecciona ok, se borraran todos los datos (Personas, sets y grafo)", "Confirme borrar datos", JOptionPane.OK_CANCEL_OPTION);
                if (decition == JOptionPane.OK_OPTION) {
                    personas.clear();
                    sets.clear();
                    grafo.clear();
                    load=true;
                }else
                    load=false;

            }
            if (load) {
                try {
                    n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos integrantes desea por grupo?"));
                    String op2 = JOptionPane.showInputDialog("Desea limitar una pareja por grupo? (Si/No)");
                    OneCouple = (op2.equals("Si") || op2.equals("si"));
                } catch (InputMismatchException | NumberFormatException e) {
                    n = 5;
                    OneCouple = true;
                    JOptionPane.showMessageDialog(null, "Ingresó un input incorrecto. Se asignaron valores por default (5 personas maximo y 1 pareja por grupo");
                }
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
                            if (!personas.isEmpty()) {
                                personas.clear();

                            }
                            while ((line = reader.readLine()) != null) {
                                if (line.contains(" y ") || line.contains(" & ") || line.contains(" e ") || line.contains(" and ")) {
                                    String[] names = line.contains(" y ") ? line.split(" y ") : (line.contains(" & ") ? line.split(" & ") : (line.contains(" e ") ? line.split(" e ") : line.split(" and ")));
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
                /* }else{
                JOptionPane.showMessageDialog(this, "Se están visualizando datos anteriormente cargados");
            }*/
            }
        } catch (IOException | NullPointerException | NumberFormatException e) {
            sets.clear();
            personas.clear();
            JOptionPane.showMessageDialog(this, "Ocurrio un error durante la carga de datos.\nIntente de nuevo y asegurese de seleccionar un archivo txt con el formato correcto");
        }
    }//GEN-LAST:event_bLoadMouseClicked

    private void bGenerateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bGenerateMouseClicked
        try {
            File dir = new File("./Sets.txt");
            long cont = 0;
            if (!personas.isEmpty()) {
                for (Set set : sets) {
                    set.clear();
                }
                for (Human persona : personas) {
                    persona.SetAdded(false);
                }
                boolean ValidSets = false;
                while (!ValidSets) {
                    while (!AllPeopleAdded(personas)) {
                        Random rand = new Random();
                        boolean validIndex = false;
                        int cualpersona = -1;
                        while (!validIndex) {
                            cualpersona = rand.nextInt(personas.size());
                            if (!personas.get(cualpersona).isAdded()) {
                                validIndex = true;
                            }

                        }
                        cont++;
                        if (cont > Math.pow(personas.size(), 10)) {
                            System.out.println("Hizo break en " + personas.get(cualpersona));
                            break;

                        }
                        int index = rand.nextInt(sets.size());
                        if (cualpersona != -1) {
                            System.out.print("Curr person " + personas.get(cualpersona) + " index: " + index + " cp: " + cualpersona+"  ");
                            if (personas.get(cualpersona) instanceof Couple && OneCouple) {
                                if (sets.get(index).CoupleFits(OneCouple)) {
                                    System.out.println(personas.get(cualpersona) + " entro a couple y onecouple");
                                    if (!sets.get(index).contains(personas.get(cualpersona))) {
                                        if (sets.get(index).add(personas.get(cualpersona), false,OneCouple)) {
                                            personas.get(cualpersona).SetAdded(true);
                                            cont = 0;
                                            if (sets.get(index).size() > 1) {
                                                personas.get(cualpersona).reduce();

                                            }

                                        }
                                    }
                                } else if (allSetsFull(sets, personas.get(cualpersona), n) && !allCoupleSlotsTaken(sets)) {
                                    System.out.println(" entro a !allcoupleslottaken");
                                    boolean forced = false;
                                    while (!forced) {
                                        int which = rand.nextInt(sets.size());
                                        int counter = 0;
                                        if (sets.get(which).CoupleSlotAvailable()) {
                                            Human h1 = null;
                                            while (!forced) {
                                                h1 = sets.get(which).remove(1 + rand.nextInt(sets.get(which).size() - 1));
                                                if (h1 instanceof Person) {
                                                    forced = true;
                                                } else {
                                                    sets.get(which).reinsert(h1);
                                                    h1 = null;
                                                    counter++;
                                                }
                                                if (counter > sets.get(which).people() * n) {
                                                    forced = true;
                                                }
                                            }

                                            Human h2 = null;
                                            if (counter > sets.get(which).people() * n) {
                                                forced = true;
                                            } else {
                                                forced = false;
                                            }
                                            while (!forced) {
                                                h2 = sets.get(which).remove(1 + rand.nextInt(sets.get(which).size() - 1));
                                                if (h2 instanceof Person) {
                                                    forced = true;
                                                } else {
                                                    sets.get(which).reinsert(h2);
                                                }
                                            }

                                            if (h1 != null && h2 != null) {
                                                if (sets.get(which).add(personas.get(cualpersona), true,OneCouple)) {
                                                    personas.get(cualpersona).reduce();
                                                    personas.get(cualpersona).SetAdded(true);
                                                    personas.get(personas.indexOf(h1)).SetAdded(false);
                                                    personas.get(personas.indexOf(h1)).revertbreaks();
                                                    personas.get(personas.indexOf(h2)).SetAdded(false);
                                                    personas.get(personas.indexOf(h2)).revertbreaks();
                                                    forced = true;
                                                    cont = 0;
                                                }
                                            } else {
                                                cont++;
                                            }
                                        }
                                    }
                                } else if (allSetsFull(sets, personas.get(cualpersona), n) && allCoupleSlotsTaken(sets)) {
                                    System.out.println(" entro a allcoupleslottaken");
                                    boolean forced = false;
                                    while (!forced) {
                                        int which = rand.nextInt(sets.size());
                                        int counter = 0;
                                        Human h1 = null;
                                        while (!forced) {
                                            h1 = sets.get(which).remove(1 + rand.nextInt(sets.get(which).size() - 1));
                                            if (h1 instanceof Person) {
                                                forced = true;
                                            } else {
                                                sets.get(which).reinsert(h1);
                                                h1 = null;
                                                counter++;
                                            }
                                            if (counter > sets.get(which).people() * n) {
                                                forced = true;
                                            }
                                        }

                                        Human h2 = null;
                                        if (counter > sets.get(which).people() * n) {
                                            forced = true;
                                        } else {
                                            forced = false;
                                            counter = 0;
                                        }
                                        while (!forced) {
                                            h2 = sets.get(which).remove(1 + rand.nextInt(sets.get(which).size() - 1));
                                            if (h2 instanceof Person) {
                                                forced = true;
                                            } else {
                                                sets.get(which).reinsert(h2);
                                                h2 = null;
                                                counter++;
                                            }
                                            if (counter > sets.get(which).people() * n) {
                                                forced = true;
                                            }
                                        }

                                        if (h1 != null && h2 != null) {
                                            if (sets.get(which).add(personas.get(cualpersona), true,OneCouple)) {
                                                personas.get(cualpersona).reduce();
                                                personas.get(cualpersona).SetAdded(true);
                                                personas.get(personas.indexOf(h1)).SetAdded(false);
                                                personas.get(personas.indexOf(h1)).revertbreaks();
                                                personas.get(personas.indexOf(h2)).SetAdded(false);
                                                personas.get(personas.indexOf(h2)).revertbreaks();
                                                forced = true;
                                                cont = 0;
                                            }
                                        } else if (counter > sets.get(which).people() * n) {
                                            cont++;
                                            if (h1 != null) {
                                                sets.get(which).reinsert(h1);
                                            }
                                            if (h2 != null) {
                                                sets.get(which).reinsert(h2);
                                            }
                                        }
                                    }
                                } else if (cont > 150) {
                                    if (!personas.get(cualpersona).isAdded()) {
                                        personas.get(cualpersona).SetAdded(true);

                                        int cual = LowestPackedUnforcedSet(sets);
                                        if (cual == -1) {
                                            cual = LowestPackedSet(sets);
                                        }
                                        if (cual != -1) {
                                            sets.get(cual).reinsert(personas.get(cualpersona));
                                            if (sets.get(cual).size() != 1) {
                                                personas.get(cualpersona).reduce();
                                            } else {
                                                personas.get(cualpersona).setBreaks(2);
                                            }
                                        } else {
                                            sets.get(index).reinsert(personas.get(cualpersona));
                                        }
                                        cont = 0;
                                    }
                                }
                            } else if (personas.get(cualpersona) instanceof Couple && !OneCouple) {
                                if (!allSetsFull(sets, personas.get(cualpersona), n)) {
                                    if (sets.get(index).CoupleFits(OneCouple)) {
                                        System.out.println(" entro al if de !onecouple");
                                        if (!sets.get(index).contains(personas.get(cualpersona))) {
                                            if (sets.get(index).add(personas.get(cualpersona), false,OneCouple)) {
                                                if (sets.get(index).people() > 1) {
                                                    personas.get(cualpersona).reduce();
                                                }
                                                personas.get(cualpersona).SetAdded(true);
                                                cont = 0;
                                            }
                                        }
                                    }
                                } else if (!allSetsForced(sets)) {
                                    System.out.println(" entro a couple y !allsetsforced");
                                    boolean forced = false;

                                    while (!forced) {
                                        int which = rand.nextInt(sets.size());
                                        int counter = 0;
                                        Human h1 = null;
                                        while (!forced) {
                                            h1 = sets.get(which).remove(1 + rand.nextInt(sets.get(which).size() - 1));
                                            if (h1 instanceof Person) {
                                                forced = true;
                                            } else {
                                                sets.get(which).reinsert(h1);
                                                h1 = null;
                                                counter++;
                                            }
                                            if (counter > sets.get(which).people() * n) {
                                                forced = true;
                                            }
                                        }
                                        if (counter > sets.get(which).people() * n) {
                                            forced = true;
                                        } else {
                                            forced = false;
                                            counter = 0;
                                        }
                                        Human h2 = null;
                                        while (!forced) {
                                            h2 = sets.get(which).remove(1 + rand.nextInt(sets.get(which).size() - 1));
                                            if (h2 instanceof Person) {
                                                forced = true;
                                            } else {
                                                sets.get(which).reinsert(h2);
                                                h2 = null;
                                                counter++;
                                            }
                                            if (counter > sets.get(which).people() * n) {
                                                forced = true;
                                            }
                                        }

                                        if (h1 != null && h2 != null) {
                                            if (sets.get(which).add(personas.get(cualpersona), true,OneCouple)) {
                                                personas.get(cualpersona).reduce();
                                                personas.get(cualpersona).SetAdded(true);
                                                personas.get(personas.indexOf(h1)).SetAdded(false);
                                                personas.get(personas.indexOf(h1)).revertbreaks();
                                                personas.get(personas.indexOf(h2)).SetAdded(false);
                                                personas.get(personas.indexOf(h2)).revertbreaks();
                                                forced = true;
                                                cont = 0;
                                            }
                                        } else {
                                            cont++;
                                            if (h1 != null) {
                                                sets.get(which).reinsert(h1);
                                            }
                                            if (h2 != null) {
                                                sets.get(which).reinsert(h2);
                                            }
                                        }
                                    }
                                } else if (cont > 150) {
                                    if (!personas.get(cualpersona).isAdded()) {
                                        personas.get(cualpersona).SetAdded(true);
                                        boolean validset = false;
                                        int cual = -1;
                                        while (!validset) {
                                            cual = LowestPackedUnforcedSet(sets);
                                            if (cual == -1) {
                                                cual = LowestPackedSet(sets);
                                            }
                                            if (sets.get(cual).size() == 0) {
                                                if (personas.get(cualpersona).getOriginalBreaks() != 2) {
                                                    validset = true;
                                                }
                                            } else {
                                                validset = true;
                                            }

                                        }
                                        if (cual != -1) {
                                            sets.get(cual).reinsert(personas.get(cualpersona));
                                            if (sets.get(cual).size() != 1) {
                                                personas.get(cualpersona).reduce();
                                            } else {
                                                personas.get(cualpersona).setBreaks(2);
                                            }
                                        } else {
                                            sets.get(index).reinsert(personas.get(cualpersona));
                                        }
                                        cont = 0;
                                    }
                                }/* else {
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
                                            cont = 0;
                                            personas.get(personas.indexOf(h1)).SetAdded(false);
                                            personas.get(personas.indexOf(h1)).revertbreaks();
                                            personas.get(personas.indexOf(h2)).SetAdded(false);
                                            personas.get(personas.indexOf(h2)).revertbreaks();
                                        }
                                    }
                                }*/
                            } else if (personas.get(cualpersona) instanceof Person) {

                                if (sets.get(index).people() < n) {
                                    System.out.println( " entro al primer if de person");
                                    if (!sets.get(index).contains(personas.get(cualpersona))) {
                                        if (sets.get(index).add(personas.get(cualpersona), false,OneCouple)) {
                                            if (sets.get(index).people() > 1) {
                                                personas.get(cualpersona).reduce();
                                            }
                                            personas.get(cualpersona).SetAdded(true);
                                            cont = 0;
                                            //sets.get(index).get(sets.get(index).size() - 1).reduce();
                                        }
                                    }
                                } else if (allSetsFull(sets, personas.get(cualpersona), n) && !allSetsForced(sets)) {
                                    int which = LowestPackedUnforcedSet(sets);
                                    System.out.println(" entro al primer else de person");
                                    //if (which != -1) {
                                    if (sets.get(index).add(personas.get(cualpersona), true,OneCouple)) {
                                        personas.get(cualpersona).SetAdded(true);
                                        personas.get(cualpersona).reduce();
                                        cont = 0;
                                    }
                                    /* 
                                         
                                        } else {
                                        which = LowestPackedSet(sets);
                                        if (which != -1) {
                                            if (sets.get(which).add(personas.get(cualpersona), true)) {
                                                personas.get(cualpersona).SetAdded(true);
                                                cont = 0;
                                                personas.get(cualpersona).reduce();
                                            }
                                        }else
                                            if(sets.get(index).add(personas.get(cualpersona), true))
                                    }*/
                                } else if (allSetsFull(sets, personas.get(cualpersona), n) && allSetsForced(sets)) {
                                    System.out.println(" entro al ultimo else de person");
                                    int which = LowestPackedSet(sets);
                                    if (which != -1) {
                                        if (sets.get(which).add(personas.get(cualpersona), true,OneCouple)) {
                                            personas.get(cualpersona).SetAdded(true);
                                            personas.get(cualpersona).reduce();
                                            cont = 0;
                                        }
                                    }
                                } else if (cont > 150) {
                                    if (!personas.get(cualpersona).isAdded()) {
                                        int cual = LowestPackedUnforcedSet(sets);
                                        if (cual == -1) {
                                            cual = LowestPackedSet(sets);
                                        }
                                        if (cual != -1) {
                                            sets.get(cual).reinsert(personas.get(cualpersona));
                                            if (sets.get(cual).size() != 1) {
                                                personas.get(cualpersona).reduce();
                                            }

                                        } else {
                                            sets.get(index).reinsert(personas.get(cualpersona));
                                        }
                                        personas.get(cualpersona).SetAdded(true);
                                        cont = 0;
                                    }
                                }
                            }
                        }
                    }

                    if (dir.exists()) {
                        if (VerifySets(dir, sets, n)) {
                            ValidSets = true;
                        } else {
                            for (Set set : sets) {
                                set.clear();
                            }
                            for (Human persona : personas) {
                                persona.SetAdded(false);
                            }
                            ValidSets = false;
                        }
                    } else {
                        ValidSets = true;
                    }
                }

                if (ValidSets) {
                    for (Human persona : personas) {
                        persona.UpdateBreaks();
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

                    jdSets.pack();

                    taSets.setText("");
                    for (int i = 0; i < sets.size(); i++) {
                        taSets.append("Set " + i + "\n------\n");
                        for (int j = 0; j < sets.get(i).size(); j++) {
                            if (j == 0) {
                                taSets.append("Lider: ");
                            }
                            taSets.append(sets.get(i).get(j).toString() + "\n");
                        }
                    }
                    if (!jdSets.isVisible()) {
                        jdSets.setVisible(true);
                    }
                    if (dir.exists()) {
                        dir.delete();
                    }
                    try (FileWriter out = new FileWriter(dir); BufferedWriter writer = new BufferedWriter(out)) {
                        for (int i = 0; i < sets.size(); i++) {
                            writer.write("Set: " + i + "\n");
                            for (int j = 0; j < sets.get(i).size(); j++) {
                                writer.write(sets.get(i).get(j).toString() + "\n");
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException | IOException e) {
            sets.clear();
            JOptionPane.showMessageDialog(this, "Ocurrio un error creando los sets, vuelva a intentar");
        }
    }//GEN-LAST:event_bGenerateMouseClicked

    private void bDrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDrawMouseClicked
        if (grafo.getEachNode() != null) {
            grafo.display(true).setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);

        }
    }//GEN-LAST:event_bDrawMouseClicked

    private void bExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_bExitMouseClicked

    private void bVerifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVerifyMouseClicked
        if (!personas.isEmpty()) {
            if (EveryoneKnowsEachOther(personas, grafo)) {
                JOptionPane.showMessageDialog(this, "Todo conocen la casa de todos los demas!");
            } else {
                JOptionPane.showMessageDialog(this, "No todos conocen la casa de los demas. Cree mas sets para que se conozcan!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos, cargue una lista de personas y parejas a partir de un archivo de texto primero");
        }
    }//GEN-LAST:event_bVerifyMouseClicked

    public static boolean VerifySets(File file, ArrayList<Set> sets, int n) {
        try {
            for (Set set : sets) {
                if (!set.isEmpty()) {
                    if (set.get(0).getBreaks() != 2) {
                        return false;
                    }
                }

            }
            FileReader read = new FileReader(file);
            BufferedReader reader = new BufferedReader(read);
            ArrayList<Set> temp = new ArrayList();
            String rLine;
            while ((rLine = reader.readLine()) != null) {
                if (rLine.contains("Set: ")) {
                    temp.add(new Set(n));
                } else if (rLine.contains(" y ")) {
                    String[] nombres = rLine.split(" y ");
                    temp.get(temp.size() - 1).reinsert(new Couple(nombres[0], nombres[1], 0));
                } else {
                    temp.get(temp.size() - 1).reinsert(new Person(rLine, 0));
                }
            }
            if (!temp.isEmpty() && !sets.isEmpty()) {
                for (Set set : temp) {
                    boolean SameSet = false;
                    for (Set set2 : sets) {
                        if (set2.size() == set.size()) {
                            for (int i = 0; i < set.size(); i++) {
                                if (set.get(i).getName().equals(set2.get(i).getName())) {
                                    SameSet = true;
                                } else {
                                    SameSet = false;
                                }
                            }
                            if (SameSet) {
                                return false;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
        }
        return true;
    }

    public static boolean allSetsFull(ArrayList<Set> sets, Human current, int n) {
        if (current instanceof Person) {
            for (Set set : sets) {
                if (set.people() < n) {
                    return false;
                }
                if(set.isEmpty())
                    return false;
            }
        } else {
            for (Set set : sets) {
                if (set.people() < n - 1) {
                    return false;
                }
                if(set.isEmpty())
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

    public static boolean CanExtractPersons(Set set) {
        int cont = 0;
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) instanceof Person) {
                cont++;
            }
        }
        return cont >= 2;
    }

    public static boolean EveryoneKnowsEachOther(ArrayList<Human> personas, Graph grafo) {
        for (Human persona : personas) {
            for (int i = 0; i < personas.size(); i++) {
                if (persona != personas.get(i)) {
                    if (grafo.getEdge(persona.getName() + personas.get(i).getName()) == null) {
                        return false;
                    }
                }
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
    private javax.swing.JButton bExit;
    private javax.swing.JButton bGenerate;
    private javax.swing.JButton bLoad;
    private javax.swing.JButton bVerify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdSets;
    private javax.swing.JTextArea taSets;
    // End of variables declaration//GEN-END:variables
}
