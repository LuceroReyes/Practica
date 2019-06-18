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
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.*;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;


/**
 *
 * @author Lucero Reyes
 */
public class vista extends javax.swing.JFrame {
    Mat j,i;
    int level=0;
    JFileChooser seleci=new JFileChooser();
    File archivo;
    
    public vista() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        initComponents();
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
        restablecer = new javax.swing.JButton();
        So = new javax.swing.JCheckBox();
        G = new javax.swing.JCheckBox();
        M = new javax.swing.JCheckBox();

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

        restablecer.setText("Restablecer");
        restablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restablecerActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(crear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(selec)
                .addGap(321, 321, 321))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardar)
                .addGap(49, 49, 49)
                .addComponent(salir)
                .addGap(58, 58, 58)
                .addComponent(restablecer)
                .addGap(208, 208, 208))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(original, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(editada, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bin, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(N))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(C)
                            .addComponent(Corr))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(B, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(So, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(G, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(M)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(selec)
                                    .addComponent(crear))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(original, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 57, Short.MAX_VALUE)
                                .addComponent(G)
                                .addGap(18, 18, 18)
                                .addComponent(So)
                                .addGap(18, 18, 18)
                                .addComponent(B)
                                .addGap(18, 18, 18)
                                .addComponent(C)
                                .addGap(18, 18, 18)
                                .addComponent(Corr)
                                .addGap(18, 18, 18)
                                .addComponent(N)
                                .addGap(18, 18, 18)
                                .addComponent(Bin)))
                        .addGap(33, 33, 33)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(M)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(salir)
                    .addComponent(restablecer))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        }else{
            B.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            So.setEnabled(true);
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
        }else{
            B.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            Bin.setEnabled(true);
            So.setEnabled(true);
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
        }else{
            B.setEnabled(true);
            C.setEnabled(true);
            Bin.setEnabled(true);
            N.setEnabled(true);
            So.setEnabled(true);
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
        }else{
            B.setEnabled(true);
            Bin.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            So.setEnabled(true);
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
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            So.setEnabled(true);
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

    private void restablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restablecerActionPerformed
        this.i=j;
        setimagen(i,true);
    }//GEN-LAST:event_restablecerActionPerformed

    private void SoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoActionPerformed
        if(So.isSelected()){
            Bin.setEnabled(false);
            C.setEnabled(false);
            Corr.setEnabled(false);
            N.setEnabled(false);
            B.setEnabled(false);
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
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            B.setEnabled(true);
            So.setEnabled(true);
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
        }else{
            Bin.setEnabled(true);
            C.setEnabled(true);
            Corr.setEnabled(true);
            N.setEnabled(true);
            B.setEnabled(true);
            So.setEnabled(true);
            G.setEnabled(true);
        }  
    }//GEN-LAST:event_MActionPerformed

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
    private javax.swing.JButton crear;
    private javax.swing.JLabel editada;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel original;
    private javax.swing.JButton restablecer;
    private javax.swing.JButton salir;
    private javax.swing.JButton selec;
    // End of variables declaration//GEN-END:variables
}
