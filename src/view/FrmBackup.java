/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author Guilherme / Italo / Francisco
 */
public class FrmBackup extends javax.swing.JInternalFrame
        implements IOuvintesPadrao, ITeclasPadrao {

    private static FrmBackup _instance = null;

    public static synchronized FrmBackup getInstance() {
        if (_instance == null) {
            _instance = new FrmBackup();
        }

        return _instance;
    }

    /**
     * Creates new form FrmBackup
     */
    private FrmBackup() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackup = new javax.swing.JPanel();
        lblImageBackup = new javax.swing.JLabel();
        btnGerarBackup = new javax.swing.JButton();
        btnRestaurarBackup = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Backup");
        setEnabled(false);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pnlBackup.setBackground(new java.awt.Color(255, 255, 204));

        lblImageBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/backup-review.png"))); // NOI18N

        btnGerarBackup.setFont(new java.awt.Font("Tahoma", 0, 14));
        btnGerarBackup.setText("Gerar Backup");
        btnGerarBackup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnGerarBackupKeyReleased(evt);
            }
        });

        btnRestaurarBackup.setFont(new java.awt.Font("Tahoma", 0, 14));
        btnRestaurarBackup.setText("Restaurar Backup");
        btnRestaurarBackup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnRestaurarBackupKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlBackupLayout = new javax.swing.GroupLayout(pnlBackup);
        pnlBackup.setLayout(pnlBackupLayout);
        pnlBackupLayout.setHorizontalGroup(
            pnlBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackupLayout.createSequentialGroup()
                .addComponent(lblImageBackup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRestaurarBackup)
                    .addComponent(btnGerarBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlBackupLayout.setVerticalGroup(
            pnlBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackupLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnGerarBackup)
                .addGap(28, 28, 28)
                .addComponent(btnRestaurarBackup))
            .addComponent(lblImageBackup)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        _instance = null;
        setVisible(false);
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnGerarBackupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGerarBackupKeyReleased
        performAction(evt);
        performNavigateAction(evt);
    }//GEN-LAST:event_btnGerarBackupKeyReleased

    private void btnRestaurarBackupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRestaurarBackupKeyReleased
        performAction(evt);
        performNavigateAction(evt);
    }//GEN-LAST:event_btnRestaurarBackupKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrmBackup().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarBackup;
    private javax.swing.JButton btnRestaurarBackup;
    private javax.swing.JLabel lblImageBackup;
    private javax.swing.JPanel pnlBackup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setActionListener(ActionListener al) {
        btnGerarBackup.addActionListener(al);
        btnGerarBackup.setActionCommand("Gerar");
        btnRestaurarBackup.addActionListener(al);
        btnRestaurarBackup.setActionCommand("Restaurar");
    }

    @Override
    public void performAction(KeyEvent evt) {
        if (evt.isControlDown() && evt.isShiftDown()) {
            if (evt.getKeyCode() == KeyEvent.VK_G) {
                btnGerarBackup.doClick();
            } else if (evt.getKeyCode() == KeyEvent.VK_R) {
                btnRestaurarBackup.doClick();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.formInternalFrameClosing(null);
        }
    }

    @Override
    public void performNavigateAction(KeyEvent evt) {
        if (evt.isControlDown()) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    if (btnGerarBackup.equals(this.getFocusOwner())) {
                        btnRestaurarBackup.requestFocus();
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (btnRestaurarBackup.equals(this.getFocusOwner())) {
                        btnGerarBackup.requestFocus();
                    }
                    break;
            }
        }
    }
}
