/*
 * FrmLogin.java
 *
 * Created on Apr 10, 2012, 12:31:12 AM
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Guilherme
 */
public class FrmLogin extends javax.swing.JFrame
        implements IOuvintesPadrao, ITeclasPadrao {

    private boolean booPerformAction = true;
    private static FrmLogin _instance = null;

    /**
     * 
     * 
     * @return 
     */
    public static synchronized FrmLogin getInstance() {
        if (_instance == null) {
            _instance = new FrmLogin();
        }
        
        Dimension dim  = Toolkit.getDefaultToolkit().getScreenSize();
        int w = _instance.getSize().width;
        int h = _instance.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        _instance.setBounds(x, y, w, h);
        _instance.setIconImage(new ImageIcon("C:/PastellySystem/Imagens/pastelly.png").getImage());

        return _instance;
    }

    /** Creates new form FrmLogin */
    private FrmLogin() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        lblImagemLogin = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        pnlLogin.setBackground(new java.awt.Color(255, 255, 204));
        pnlLogin.setForeground(new java.awt.Color(204, 204, 255));
        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImagemLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/lock.png"))); // NOI18N
        pnlLogin.add(lblImagemLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        pnlLogin.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 92, -1));

        lblUsuario.setText("Usuário:");
        pnlLogin.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lblSenha.setText("Senha:");
        pnlLogin.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
        });
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenhaKeyReleased(evt);
            }
        });
        pnlLogin.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 92, -1));

        btnLogin.setText("Entrar");
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnLoginKeyReleased(evt);
            }
        });
        pnlLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 127, -1));

        btnSair.setText("Cancelar");
        btnSair.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnSairKeyReleased(evt);
            }
        });
        pnlLogin.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 127, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        if (!txtUsuario.getText().isEmpty()) {
            txtUsuario.selectAll();
        }
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained
        if (!String.valueOf(txtSenha.getPassword()).isEmpty()) {
            txtSenha.selectAll();
        }
    }//GEN-LAST:event_txtSenhaFocusGained

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        performAction(evt);
        performNavigateAction(evt);
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyReleased
        performAction(evt);
        performNavigateAction(evt);
    }//GEN-LAST:event_txtSenhaKeyReleased

    private void btnLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyReleased
        performNavigateAction(evt);
    }//GEN-LAST:event_btnLoginKeyReleased

    private void btnSairKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSairKeyReleased
        performNavigateAction(evt);
    }//GEN-LAST:event_btnSairKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblImagemLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlLogin;
    public javax.swing.JPasswordField txtSenha;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setActionListener(ActionListener al) {
        btnLogin.addActionListener(al);
        btnLogin.setActionCommand("Logar");
        btnSair.addActionListener(al);
        btnSair.setActionCommand("Sair");
    }

    @Override
    public void performAction(KeyEvent evt) {
        if (booPerformAction) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnLogin.doClick();
            } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                btnSair.doClick();
            }
            booPerformAction = false;
        } else {
            booPerformAction = true;
        }
    }

    @Override
    public void performNavigateAction(KeyEvent evt) {
        if (evt.isControlDown()) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    if (txtUsuario.equals(this.getFocusOwner())) {
                        txtSenha.requestFocus();
                    } else if (txtSenha.equals(this.getFocusOwner())) {
                        btnLogin.requestFocus();
                    } else if (btnLogin.equals(this.getFocusOwner())) {
                        btnSair.requestFocus();
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (txtSenha.equals(this.getFocusOwner())) {
                        txtUsuario.requestFocus();
                    } else if (btnLogin.equals(this.getFocusOwner())) {
                        txtSenha.requestFocus();
                    } else if (btnSair.equals(this.getFocusOwner())) {
                        btnLogin.requestFocus();
                    }
                    break;
            }
        }
    }
}
