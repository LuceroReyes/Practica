/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Clases.Filtros;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jfree.chart.JFreeChart;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.*;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Lucero Reyes
 */
public class vista extends javax.swing.JFrame {
    Mat j,i;
    int level=0;
    JFileChooser seleci=new JFileChooser();
    File archivo;
    JFreeChart grafica;
 
    public vista() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        initComponents();
        setLocationRelativeTo(null);
        
    }
      private void setimagen(Mat image,boolean i ){
        Image loadedImage =toBuufferdImage(image);
        if(i){
             editada.setIcon(new ImageIcon(loadedImage.getScaledInstance(this.editada.getWidth(),this.editada.getHeight(), Image.SCALE_DEFAULT)));
             this.i=image;
        }else{
            this.i=j;
            original.setIcon(new ImageIcon(loadedImage.getScaledInstance(this.original.getWidth(),this.original.getHeight(), Image.SCALE_DEFAULT)));
        }
            
    }

    private Image toBuufferdImage(Mat matrix){
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if(matrix.channels()>1){
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        if(matrix.channels()>3){
            type= BufferedImage.TYPE_4BYTE_ABGR;
        }
        int bufferSize = matrix.channels()* matrix.cols() * matrix.rows();
        byte[] buffer = new byte [bufferSize];
        matrix.get(0,0,buffer);
        BufferedImage image = new BufferedImage(matrix.cols(),matrix.rows(),type);
        final byte[] targetPixels =((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(buffer,0,targetPixels,0,buffer.length);
        return image;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        crear = new javax.swing.JButton();
        selec = new javax.swing.JButton();
        original = new javax.swing.JLabel();
        editada = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        B = new javax.swing.JCheckBox();
        C = new javax.swing.JCheckBox();
        Corr = new javax.swing.JCheckBox();
        N = new javax.swing.JCheckBox();
        Bin = new javax.swing.JCheckBox();
        So = new javax.swing.JCheckBox();
        G = new javax.swing.JCheckBox();
        M = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        r = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        gr = new javax.swing.JComboBox<>();
        es = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        deri = new javax.swing.JCheckBox();
        la = new javax.swing.JCheckBox();
        can = new javax.swing.JCheckBox();
        tra = new javax.swing.JCheckBox();
        his = new javax.swing.JButton();
        dperros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        crear.setText("Crear Imagen");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });

        selec.setText("Seleccionar Imagen");
        selec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecActionPerformed(evt);
            }
        });

        original.setText("Imagen");

        editada.setText("Editada");

        guardar.setText("Guardar Imagen");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(50);
        jSlider1.setMinimum(-50);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        B.setText("Brillo");
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }
        });

        C.setText("Contraste");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });

        Corr.setText("Correción");
        Corr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorrActionPerformed(evt);
            }
        });

        N.setText("Negativo");
        N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NActionPerformed(evt);
            }
        });

        Bin.setText("Binarización");
        Bin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BinActionPerformed(evt);
            }
        });

        So.setText("Averaging");
        So.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoActionPerformed(evt);
            }
        });

        G.setText("Gauss");
        G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GActionPerformed(evt);
            }
        });

        M.setText("Media");
        M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Filtros");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Suavizados");

        r.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        r.setText("Rotar");
        r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rActionPerformed(evt);
            }
        });

        jLabel3.setText("Grados:");

        jLabel4.setText("Escala:");

        gr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "30", "45", "60", "90", "120", "135", "150", "180", "210", "225", "240", "270", "300", "315", "330", "360" }));

        es.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.1", "0.2", "0.3", "0.4", "0.5" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setText("Transformación");
        jLabel5.setToolTipText("");

        deri.setText("Derivadas");
        deri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deriActionPerformed(evt);
            }
        });

        la.setText(" Laplace");
        la.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laActionPerformed(evt);
            }
        });

        can.setText("Canny");
        can.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canActionPerformed(evt);
            }
        });

        tra.setText("Trasnformada");
        tra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traActionPerformed(evt);
            }
        });

        his.setText("Histograma");
        his.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hisActionPerformed(evt);
            }
        });

        dperros.setText("Dectectar Perritos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(crear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selec)
                        .addGap(226, 226, 226))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(original, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editada, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Bin)
                    .addComponent(B)
                    .addComponent(C)
                    .addComponent(Corr)
                    .addComponent(N)
                    .addComponent(jLabel2)
                    .addComponent(So)
                    .addComponent(G)
                    .addComponent(M)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deri)
                            .addComponent(jLabel5)
                            .addComponent(es, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(gr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(r)
                            .addComponent(la)
                            .addComponent(can)
                            .addComponent(tra)
                            .addComponent(his))))
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(guardar)
                .addGap(95, 95, 95)
                .addComponent(dperros)
                .addGap(55, 55, 55)
                .addComponent(salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(his))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(selec)
                                    .addComponent(crear))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 266, Short.MAX_VALUE)
                                        .addComponent(r)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(es, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(editada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(original, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addComponent(deri)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(la)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(can))
                                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tra))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Bin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(B)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(C)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Corr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(N)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(So)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(G)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(M)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dperros)
                                    .addComponent(salir)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(guardar)))))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        inicio m= new inicio();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_salirActionPerformed

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        Mat imagen1 =new Mat(15,15, CvType.CV_8UC3);
        for(int i=0;i<imagen1.rows();i++){
            for(int j =0;j<imagen1.cols();j++){
                int n1 =(int)(Math.random()*255);
                int n2 =(int)(Math.random()*255);
                int n3 =(int)(Math.random()*255);
                imagen1.put(i,j,new double[]{n1,n2,n3});
                }
        }
        setimagen(imagen1,false);
        i=imagen1;
        
    }//GEN-LAST:event_crearActionPerformed

    private void selecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecActionPerformed
        JFileChooser chooser=new JFileChooser();
        chooser.showDialog(null,null);
        File selectedFile =chooser.getSelectedFile();
        try{
            Mat newImage=Imgcodecs.imread(selectedFile.getPath());
            this.j= newImage;
            setimagen(newImage,false);
        }catch(Exception ex){
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Archivo invalido");
        }
    }//GEN-LAST:event_selecActionPerformed

    private void BinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BinActionPerformed
        if(Bin.isSelected()){
            B.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            So.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false);
            G.setEnabled(false);
            M.setEnabled(false);
            r.setEnabled(false);
            deri.setEnabled(false);
        }else{
            B.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            So.setEnabled(true);
            la.setEnabled(true);
            can.setEnabled(true);
            tra.setEnabled(true);
            G.setEnabled(true);
            M.setEnabled(true);
            r.setEnabled(true);
            deri.setEnabled(true);
        }
        setimagen(Filtros.Binarizacion(i),true);
        jSlider1.setEnabled(false);
    }//GEN-LAST:event_BinActionPerformed

    private void NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NActionPerformed
        jSlider1.setEnabled(false);
        if(N.isSelected()){
            B.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            Bin.setEnabled(false);
            So.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false); 
            G.setEnabled(false);
            M.setEnabled(false);
            r.setEnabled(false);
            deri.setEnabled(false);
        }else{
            B.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            Bin.setEnabled(true);
            So.setEnabled(true);
            G.setEnabled(true);
            M.setEnabled(true);
            r.setEnabled(true);
            deri.setEnabled(true);
        }
        setimagen(Filtros.Negativo(i),true);
    }//GEN-LAST:event_NActionPerformed

    private void CorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorrActionPerformed
       if(Corr.isSelected()){
            B.setEnabled(false);
            C.setEnabled(false);
            Bin.setEnabled(false);
            N.setEnabled(false);
            So.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false);
            G.setEnabled(false);
            M.setEnabled(false);
            r.setEnabled(false);
            deri.setEnabled(false);
        }else{
            B.setEnabled(true);
            C.setEnabled(true);
            Bin.setEnabled(true);
            N.setEnabled(true);
            So.setEnabled(true);
            la.setEnabled(true);
            can.setEnabled(true);
            tra.setEnabled(true);
            G.setEnabled(true);
            M.setEnabled(true);
            r.setEnabled(true);
            deri.setEnabled(true);
        }
       jSlider1.setEnabled(true);
        jSlider1.setMaximum(12);
        jSlider1.setMinimum(9);
        jSlider1.setValue(9);
    }//GEN-LAST:event_CorrActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        if(C.isSelected()){
            B.setEnabled(false);
            Bin.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            So.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false); 
            G.setEnabled(false);
            M.setEnabled(false);
            r.setEnabled(false);
            deri.setEnabled(false);
        }else{
            B.setEnabled(true);
            Bin.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            So.setEnabled(true);
            la.setEnabled(true);
            can.setEnabled(true);
            tra.setEnabled(true); 
            G.setEnabled(true);
            M.setEnabled(true);
            r.setEnabled(true);
            deri.setEnabled(true);
        }
        jSlider1.setEnabled(true);
        jSlider1.setMinimum(0);
        jSlider1.setMaximum(10);
        jSlider1.setValue(0);
    }//GEN-LAST:event_CActionPerformed

    private void BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActionPerformed
        if(B.isSelected()){
            Bin.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            So.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false);
            G.setEnabled(false);
            M.setEnabled(false);
            r.setEnabled(false);
            deri.setEnabled(false);
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            So.setEnabled(true);
            la.setEnabled(true);
            can.setEnabled(true);
            tra.setEnabled(true); 
            G.setEnabled(true);
            M.setEnabled(true);
            r.setEnabled(true);
            deri.setEnabled(true);
        }
        jSlider1.setEnabled(true);
        jSlider1.setMinimum(-5);
        jSlider1.setMaximum(5);
        jSlider1.setValue(0);
    }//GEN-LAST:event_BActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        try{
            Mat image=i;
            if(B.isSelected()){
                if(jSlider1.getValue()<level){
                    setimagen(Filtros.quitarBrillo(image),true);
                    level=jSlider1.getValue();
                }else if(jSlider1.getValue()>level){
                    setimagen(Filtros.agregaBrillo(image),true);
                    level=jSlider1.getValue();
                }
            }else if(C.isSelected()){
                setimagen(Filtros.Contraste(image),true);
            }else if(Corr.isSelected()){
                setimagen(Filtros.agregarCorrecion(image,jSlider1.getValue()),true); 
            }else if(So.isSelected()){
                setimagen(Filtros.Averaging(image),true);
            }else if(G.isSelected()){
                setimagen(Filtros.Gauss(image),true);
            }else if(M.isSelected()){
                setimagen(Filtros.Media(image),true);
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Seleccione un filtro");
        }
        
    }//GEN-LAST:event_jSlider1StateChanged

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if (seleci.showDialog(null,"Guardar Imagen")==JFileChooser.APPROVE_OPTION);
        archivo=seleci.getSelectedFile();
        try{
            Imgcodecs.imwrite(archivo.getPath(),i);
            JOptionPane.showMessageDialog(null, "Imagen guardada con exito");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error a guardar la imagen");
        }
        
    }//GEN-LAST:event_guardarActionPerformed

    private void SoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoActionPerformed
        if(So.isSelected()){
            Bin.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            B.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false);
            G.setEnabled(false);
            M.setEnabled(false);
            r.setEnabled(false);
            deri.setEnabled(false);
            //setimagen(i, true);
            //jSlider1.setEnabled(true);
            //jSlider1.setMinimum(0);
            //jSlider1.setMaximum(5);
            //jSlider1.setValue(0);
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            B.setEnabled(true);
            la.setEnabled(true);
            can.setEnabled(true);
            tra.setEnabled(true);
            G.setEnabled(true);
            M.setEnabled(true);
            r.setEnabled(true);
            deri.setEnabled(true);
        }
        
    }//GEN-LAST:event_SoActionPerformed

    private void GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GActionPerformed
    if(G.isSelected()){
            Bin.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            B.setEnabled(false);
            So.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false); 
            M.setEnabled(false);
            r.setEnabled(false);
            deri.setEnabled(false);
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            B.setEnabled(true);
            So.setEnabled(true);
            la.setEnabled(true);
            can.setEnabled(true);
            tra.setEnabled(true);
            M.setEnabled(true);
            r.setEnabled(true);
            deri.setEnabled(true);
        }    
    }//GEN-LAST:event_GActionPerformed

    private void MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MActionPerformed
        if(M.isSelected()){
            Bin.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            B.setEnabled(false);
            So.setEnabled(false);
            G.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false);  
            r.setEnabled(false);
            deri.setEnabled(false);
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            B.setEnabled(true);
            So.setEnabled(true);
            G.setEnabled(true);
            la.setEnabled(true);
            can.setEnabled(true);
            tra.setEnabled(true);  
            r.setEnabled(true);
            deri.setEnabled(true);
        }  
    }//GEN-LAST:event_MActionPerformed

    private void rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rActionPerformed
        // TODO add your handling code here:
        if(r.isSelected()){
            Bin.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            B.setEnabled(false);
            So.setEnabled(false);
            G.setEnabled(false);
            M.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false); 
            deri.setEnabled(false);
            String grados=gr.getSelectedItem().toString();
            int gra=Integer.parseInt(grados);
            String escala=es.getSelectedItem().toString();
            double esc=Double.parseDouble(escala);
            i=Filtros.rotacion(i, gra,esc);
            setimagen(i,true);
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            B.setEnabled(true);
            So.setEnabled(true);
            G.setEnabled(true);
            M.setEnabled(true);
            la.setEnabled(true);
            can.setEnabled(true);
            tra.setEnabled(true); 
            deri.setEnabled(true);
        }
    }//GEN-LAST:event_rActionPerformed

    private void deriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deriActionPerformed
        // TODO add your handling code here
        if(deri.isSelected()){
            Bin.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            B.setEnabled(false);
            So.setEnabled(false);
            G.setEnabled(false);
            r.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false);   
            M.setEnabled(false);
            setimagen(Filtros.Sobel(i),true);
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            B.setEnabled(true);
            So.setEnabled(true);
            G.setEnabled(true);
            r.setEnabled(true);
            la.setEnabled(true);
            can.setEnabled(true);
            tra.setEnabled(true);  
            M.setEnabled(true);
        }
    }//GEN-LAST:event_deriActionPerformed

    private void laActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laActionPerformed
        // TODO add your handling code here:
        if(la.isSelected()){
            Bin.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            B.setEnabled(false);
            So.setEnabled(false);
            G.setEnabled(false);
            r.setEnabled(false);
            deri.setEnabled(false);
            can.setEnabled(false);
            tra.setEnabled(false);   
            M.setEnabled(false);
            setimagen(Filtros.Laplace(i),true);
        }else{
             Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            B.setEnabled(true);
            So.setEnabled(true);
            G.setEnabled(true);
            r.setEnabled(true);
            deri.setEnabled(true);
            can.setEnabled(true);
            tra.setEnabled(true);  
            M.setEnabled(true);
        }
        
    }//GEN-LAST:event_laActionPerformed

    private void canActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canActionPerformed
        // TODO add your handling code here:
        if(can.isSelected()){
            Bin.setEnabled(true);
            Bin.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            B.setEnabled(false);
            So.setEnabled(false);
            G.setEnabled(false);
            r.setEnabled(false);
            la.setEnabled(false);
            deri.setEnabled(false);
            tra.setEnabled(false);   
            M.setEnabled(false);
            setimagen(Filtros.Canny(i),true);
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            B.setEnabled(true);
            So.setEnabled(true);
            G.setEnabled(true);
            r.setEnabled(true);
            la.setEnabled(true);
            deri.setEnabled(true);
            tra.setEnabled(true);  
            M.setEnabled(true);
        }
    }//GEN-LAST:event_canActionPerformed

    private void traActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traActionPerformed
        // TODO add your handling code here:
        if(tra.isSelected()){
           Bin.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            B.setEnabled(false);
            So.setEnabled(false);
            G.setEnabled(false);
            r.setEnabled(false);
            la.setEnabled(false);
            can.setEnabled(false);
            deri.setEnabled(false);   
            M.setEnabled(false);
            setimagen(Filtros.transformada(i),true);
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            B.setEnabled(true);
            So.setEnabled(true);
            G.setEnabled(true);
            r.setEnabled(true);
            la.setEnabled(true);
            can.setEnabled(true);
            deri.setEnabled(true);  
            M.setEnabled(true);
        }
    }//GEN-LAST:event_traActionPerformed

    private void hisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hisActionPerformed
        // TODO add your handling code here:
        Filtros.histograma(j);
    }//GEN-LAST:event_hisActionPerformed

    /**
     * @param args the command line arguments 
     */
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
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox B;
    private javax.swing.JCheckBox Bin;
    private javax.swing.JCheckBox C;
    private javax.swing.JCheckBox Corr;
    private javax.swing.JCheckBox G;
    private javax.swing.JCheckBox M;
    private javax.swing.JCheckBox N;
    private javax.swing.JCheckBox So;
    private javax.swing.JCheckBox can;
    private javax.swing.JButton crear;
    private javax.swing.JCheckBox deri;
    private javax.swing.JButton dperros;
    private javax.swing.JLabel editada;
    private javax.swing.JComboBox<String> es;
    private javax.swing.JComboBox<String> gr;
    private javax.swing.JButton guardar;
    private javax.swing.JButton his;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JCheckBox la;
    private javax.swing.JLabel original;
    private javax.swing.JCheckBox r;
    private javax.swing.JButton salir;
    private javax.swing.JButton selec;
    private javax.swing.JCheckBox tra;
    // End of variables declaration//GEN-END:variables
}
