/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sleepcsv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author killermike
 */
public class SleepGUI extends javax.swing.JFrame {
    FileLoader fl = new FileLoader();

    /** Creates new form SleepGUI */
    public SleepGUI() {
        initComponents();
        
    }
    
    void LoadAndParse ()
    {
        //System.out.println("Starting load and parse");
        if (fl.loadFile())
        {
            SleepCSV.Ready = true;
        }
        
    
        outputResult();
    }
    void outputResult()
    {
        if (SleepCSV.Ready)
        {
        fl.parseFile();
        fl.parseEntries();
        fl.createCSV();
      /*  if (SleepCSV.mode.equals("Single"))
        {
            fl.createCSV();
            
        }
        if (SleepCSV.mode.equals("Multiple"))
        {
            fl.createCSV2();            
        }*/
        }
        
        
       // System.out.println(SleepCSV.outputString);
        jTextArea1.setText(SleepCSV.outputString);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButtonSingle = new javax.swing.JRadioButton();
        jRadioButtonMulti = new javax.swing.JRadioButton();
        jRadioButtonUS = new javax.swing.JRadioButton();
        jRadioButtonBritish = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxTotalMins = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Noto Mono", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        buttonGroup1.add(jRadioButtonSingle);
        jRadioButtonSingle.setSelected(true);
        jRadioButtonSingle.setText("Single");
        jRadioButtonSingle.setToolTipText("Every entry on same column pair");
        jRadioButtonSingle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSingleActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonMulti);
        jRadioButtonMulti.setText("Multi");
        jRadioButtonMulti.setToolTipText("Each sleep in own column pair");
        jRadioButtonMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMultiActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonUS);
        jRadioButtonUS.setSelected(true);
        jRadioButtonUS.setText("US");
        jRadioButtonUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUSActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonBritish);
        jRadioButtonBritish.setText("British");
        jRadioButtonBritish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBritishActionPerformed(evt);
            }
        });

        jLabel1.setText("Date Format");

        jLabel2.setText("Time Outmode");

        jCheckBoxTotalMins.setText("Add Total Minutes");
        jCheckBoxTotalMins.setToolTipText("Add the total minutes since the start of the year");
        jCheckBoxTotalMins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxTotalMinsActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Open...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Export CSV...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonSingle)
                    .addComponent(jRadioButtonMulti)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonUS)
                            .addComponent(jRadioButtonBritish))
                        .addGap(86, 86, 86)
                        .addComponent(jCheckBoxTotalMins)))
                .addGap(302, 302, 302))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonUS)
                    .addComponent(jRadioButtonSingle)
                    .addComponent(jCheckBoxTotalMins))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonBritish)
                    .addComponent(jRadioButtonMulti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File ("sleep-export.csv"));
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            SleepCSV.inputCSVFile = fc.getSelectedFile();
            
        }
        //System.out.println(SleepCSV.inputCSVFile);
        LoadAndParse();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JFileChooser sc = new JFileChooser();
        sc.setSelectedFile(new File ("exportSleep.csv"));
        int result = sc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            FileWriter myWriter = null;
            try {
                File selectedFile = sc.getSelectedFile();
                myWriter = new FileWriter(selectedFile);
                myWriter.write(SleepCSV.outputString);
                myWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(SleepGUI.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    myWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(SleepGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
            

        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jRadioButtonSingleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSingleActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonSingle.isSelected())
        {
            SleepCSV.mode = "Single";
            outputResult();
        }
    }//GEN-LAST:event_jRadioButtonSingleActionPerformed

    private void jRadioButtonMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMultiActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonMulti.isSelected())
        {
            SleepCSV.mode = "Multiple";
            outputResult();
        }
    }//GEN-LAST:event_jRadioButtonMultiActionPerformed

    private void jRadioButtonUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUSActionPerformed
        // TODO add your handling code here:
        
        if (jRadioButtonUS.isSelected())
        {
            SleepCSV.dateFormat = "US";
            outputResult();
        }
    }//GEN-LAST:event_jRadioButtonUSActionPerformed

    private void jRadioButtonBritishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBritishActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonBritish.isSelected())
        {
            SleepCSV.dateFormat = "British";
            outputResult();
        }
        
    }//GEN-LAST:event_jRadioButtonBritishActionPerformed

    private void jCheckBoxTotalMinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxTotalMinsActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxTotalMins.isSelected())
        {
            SleepCSV.showTotalMins = true;
            outputResult();
        }
        else
        {
            SleepCSV.showTotalMins = false;
            outputResult();
        }
    }//GEN-LAST:event_jCheckBoxTotalMinsActionPerformed

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
            java.util.logging.Logger.getLogger(SleepGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SleepGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SleepGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SleepGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SleepGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox jCheckBoxTotalMins;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonBritish;
    private javax.swing.JRadioButton jRadioButtonMulti;
    private javax.swing.JRadioButton jRadioButtonSingle;
    private javax.swing.JRadioButton jRadioButtonUS;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
