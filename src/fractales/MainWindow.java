/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractales;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jl219611
 */
public class MainWindow extends javax.swing.JFrame{

    /**
     * Creates new form MainWindow
     */
    private Fractales frac;
    private Settings settings;
    private int previousPositionX;
    private int previousPositionY;
    private int couleurMode;
    private BufferedImage image;
    private double RealSeed;
    private double ImaginarySeed;
    
    public MainWindow() {
        initComponents();
        couleurMode = 0;
        RealSeed = -0.123;
        RealSeed = 0.745;
        frac = new Fractales(    jPanel1.getWidth()/2 + jPanel1.getX(),//  X =223 , Y= 125
                                jPanel1.getHeight()/2 + jPanel1.getY(),
                                1,
                                2,
                                "Douady +");
        setTitle("Visualiseur de fractales : "+frac.getMode());
        image = new BufferedImage(  jPanel1.getWidth(), 
                                    jPanel1.getHeight(), 
                                    BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        jPanel1.update(g);
    }
    
    public Graphics getPanelGraphics(){
        return jPanel1.getGraphics();
    }
    
    public void setCouleurMode(int mode){
        couleurMode = mode;
    }
    
    public void setSeed(double real, double imaginary){
        RealSeed = real;
        ImaginarySeed = imaginary;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        setResizable(false);

        jPanel1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jPanel1MouseWheelMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        jButton2.setText("Save as screenshot");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator1);

        jButton1.setText("Options");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jPanel1MouseWheelMoved
       // On vérifie que le zoom est positif, sinon on le met à 0
        
        if (evt.getWheelRotation() <0){
            frac.setZoom(frac.getZoom() * 1.1);
        } else {
            // on empêche l'image de disparaitre en étant trop petite pour être dessinée
            if (frac.getZoom() / 1.1 > 0.1){
                frac.setZoom(frac.getZoom() / 1.1);
            }            
        }        
        // On affiche le niveau de zoom
        System.out.printf("Niveau de zoom : x %.3f %n",frac.getZoom());        
        
        // On met à jour le centre de la fractale après zoom
        double posCoordinateX = frac.getCenterX() - (jPanel1.getWidth()/2- evt.getX())*(0.01/frac.getZoom());
        double posCoordinateY = frac.getCenterY() - (jPanel1.getHeight()/2- evt.getY())*(0.01/frac.getZoom());
        frac.setCenterX(posCoordinateX + (jPanel1.getWidth()/2-evt.getX())*(0.01/frac.getZoom()));
        frac.setCenterY(posCoordinateY + (jPanel1.getHeight()/2-evt.getY())*(0.01/frac.getZoom()));
        
        // On affiche le tout
        updateView(jPanel1.getGraphics());
    }//GEN-LAST:event_jPanel1MouseWheelMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        settings = new Settings();
        settings.setFractales(frac);
        settings.setIterations(frac.getMaxIteration());
        settings.setColoration(couleurMode);
        settings.setFractaleMode(frac.getMode());
        settings.setWindow(this);
        settings.setVisible(true);        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        previousPositionX = evt.getX();
        previousPositionY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
    if ((previousPositionX != evt.getX()) || (previousPositionX != evt.getY())) {
        frac.setCenterX(frac.getCenterX() - (evt.getX()-previousPositionX)*(0.01/frac.getZoom()) );
        frac.setCenterY(frac.getCenterY() - (evt.getY()-previousPositionY)*(0.01/frac.getZoom()) );
        updateView(jPanel1.getGraphics());
    }
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Enregistrer sous...");
        
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            updateView(image.getGraphics());
            System.out.println("Fichier sauvegardé sous : " + fileToSave.getAbsolutePath()+".png");
            try{
                ImageIO.write(image,"png",new File(fileToSave.getAbsolutePath()+".png"));
            }catch (Exception e) {};
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    
    public void updateView(Graphics g){
        double valueX = 0;
        double valueY = 0;
        int nbIteration = 0;

        int IDColumn;
        int IDRow;

        double semiWidth = (double) jPanel1.getWidth() /2;
        double semiHeight = (double) jPanel1.getHeight()/2;
        double valueGap = (0.01/frac.getZoom());
        
        
        for (IDColumn=jPanel1.getX(); IDColumn<jPanel1.getWidth(); ++IDColumn) {
            for (IDRow=jPanel1.getX(); IDRow<jPanel1.getHeight(); ++IDRow) {

                valueX = frac.getCenterX() +(IDColumn-semiWidth)*valueGap;
                valueY = frac.getCenterY() + (IDRow-semiHeight)*valueGap;
                nbIteration = frac.checkDivergence(valueX, valueY, RealSeed, ImaginarySeed, frac.getMaxIteration());

                Color usedColor = frac.getColor(nbIteration, couleurMode);

                if (nbIteration == frac.getMaxIteration()) {
                    g.setColor(Color.BLACK);
                }
                else {
                    g.setColor(usedColor);
                }
                // Il n'est pas possible de dessiner explicitement un point, 
                // alors on triche en dessinant une ligne de 1px
                g.drawLine(IDColumn, IDRow, IDColumn, IDRow);
            }
        }
    }
}
