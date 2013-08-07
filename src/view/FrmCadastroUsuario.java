    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmCadastroUsuario.java
 *
 * Created on Jun 4, 2012, 10:16:20 PM
 */
package view;

import controller.UserDao;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.UserBean;

/**
 *
 * @author USER
 */
public class FrmCadastroUsuario extends javax.swing.JInternalFrame
        implements IViewMetodosPadrao, IOuvintesPadrao, ITeclasPadrao {

    public List<UserBean> usuarios = new ArrayList<UserBean>();
    public int intPosition = 0;
    public boolean booInclusao = false;
    public boolean booAlteracao = false;
    private static FrmCadastroUsuario _instance = null;
    public DefaultTableModel defaultTableModel = new DefaultTableModel();

    public static synchronized FrmCadastroUsuario getInstance() {
        if (_instance == null) {
            _instance = new FrmCadastroUsuario();
        }
        return _instance;
    }

    /** Creates new form FrmCadastroUsuario */
    private FrmCadastroUsuario() {
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

        tobNavegador = new javax.swing.JToolBar();
        btnVoltarInicio = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        txtContador = new javax.swing.JTextField();
        lblContador = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnSeguir = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNivelAcesso = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 204));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro de Usuarios");
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

        tobNavegador.setBackground(new java.awt.Color(254, 254, 150));
        tobNavegador.setRollover(true);

        btnVoltarInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/primeiro.png"))); // NOI18N
        btnVoltarInicio.setFocusable(false);
        btnVoltarInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVoltarInicio.setOpaque(false);
        btnVoltarInicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVoltarInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarInicioActionPerformed(evt);
            }
        });
        tobNavegador.add(btnVoltarInicio);

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/anterior.png"))); // NOI18N
        btnVoltar.setFocusable(false);
        btnVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVoltar.setOpaque(false);
        btnVoltar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        tobNavegador.add(btnVoltar);
        tobNavegador.add(jSeparator1);

        txtContador.setText("0");
        tobNavegador.add(txtContador);

        lblContador.setText("de ( 0 )");
        tobNavegador.add(lblContador);
        tobNavegador.add(jSeparator2);

        btnSeguir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/proximo.png"))); // NOI18N
        btnSeguir.setFocusable(false);
        btnSeguir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSeguir.setOpaque(false);
        btnSeguir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeguirActionPerformed(evt);
            }
        });
        tobNavegador.add(btnSeguir);

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/ultimo.png"))); // NOI18N
        btnUltimo.setFocusable(false);
        btnUltimo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUltimo.setOpaque(false);
        btnUltimo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        tobNavegador.add(btnUltimo);
        tobNavegador.add(jSeparator3);

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/add-2-icon (2)_1.png"))); // NOI18N
        btnAdicionar.setFocusable(false);
        btnAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionar.setOpaque(false);
        btnAdicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tobNavegador.add(btnAdicionar);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/alterar.png"))); // NOI18N
        btnAlterar.setFocusable(false);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setOpaque(false);
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tobNavegador.add(btnAlterar);

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/delete-icon.png"))); // NOI18N
        btnDeletar.setFocusable(false);
        btnDeletar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeletar.setOpaque(false);
        btnDeletar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tobNavegador.add(btnDeletar);
        tobNavegador.add(jSeparator4);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/basic-data-icon.png"))); // NOI18N
        btnSalvar.setEnabled(false);
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setOpaque(false);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tobNavegador.add(btnSalvar);

        btnCancelar.setEnabled(false);
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setOpaque(false);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tobNavegador.add(btnCancelar);

        lblCodigo.setText("CÓDIGO:");

        txtCodigo.setBackground(new java.awt.Color(255, 255, 204));
        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);

        lblLogin.setText("LOGIN:");

        lblSenha.setText("SENHA:");

        txtSenha.setText("jPasswordField1");

        tabUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabUsuarios);

        jLabel1.setText("NIVEL DE ACESSO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tobNavegador, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo)
                    .addComponent(lblLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNivelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tobNavegador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNivelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        _instance = null;
        setVisible(false);
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnVoltarInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarInicioActionPerformed
        setData(0);
    }//GEN-LAST:event_btnVoltarInicioActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        setData(intPosition - 1);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguirActionPerformed
        setData(intPosition + 1);
    }//GEN-LAST:event_btnSeguirActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        setData(usuarios.size() - 1);
    }//GEN-LAST:event_btnUltimoActionPerformed

    public void novoCliente() {
        txtCodigo.setText(String.valueOf(usuarios.size() + 1));
        txtContador.setText("");
    }

    /**
     * Carregar um ClienteBean contendo as informacoes de um unico cliente
     * 
     * @param codUser Codigo do cliente a ser carregado
     * @return ClienteBean contendo as informacoes do cliente
     */
    public UserBean carregaBean(int codUser) {
        UserBean bean = new UserBean(Integer.parseInt(txtCodigo.getText()),
                txtLogin.getText(), "", Integer.parseInt(txtNivelAcesso.getText()));
        return bean;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSeguir;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltarInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblContador;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTable tabUsuarios;
    private javax.swing.JToolBar tobNavegador;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtContador;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNivelAcesso;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setData(int index) {
        intPosition = index;
        txtContador.setText(String.valueOf(intPosition + 1));
        txtCodigo.setText(String.valueOf(usuarios.get(index).getCodigo()));
        txtSenha.setText(usuarios.get(index).getPassword());
        txtLogin.setText(usuarios.get(index).getLogin());
        txtNivelAcesso.setText(String.valueOf(usuarios.get(index).getNivel()));
        if (intPosition == 0) {
            setEnabledNavigator(false);
        } else if (intPosition == usuarios.size() - 1) {
            setEnabledNavigator(true);
        }
    }

    @Override
    public void setEnabledNavigator(boolean b) {
        btnVoltarInicio.setEnabled(b);
        btnVoltar.setEnabled(b);
        btnSeguir.setEnabled(!b);
        btnUltimo.setEnabled(!b);
    }

    @Override
    public void setEnabledToolBar(boolean b) {
        btnAdicionar.setEnabled(b);
        btnAlterar.setEnabled(b);
        btnDeletar.setEnabled(b);
        btnSalvar.setEnabled(!b);
        btnCancelar.setEnabled(!b);
    }

    @Override
    public void habilitaCampos(boolean b) {
        txtSenha.setEnabled(b);
        txtLogin.setEnabled(b);
        txtNivelAcesso.setEnabled(b);
    }

    @Override
    public void limpaCampos() {
        txtCodigo.setText(String.valueOf(usuarios.size()));
        txtSenha.setText("");
        txtLogin.setText("");
        txtNivelAcesso.setText("");
    }

    @Override
    public void atualizaTable() {
        tabUsuarios.setModel(defaultTableModel);
    }

    @Override
    public void atualizaToolbar(boolean novo) {
        lblContador.setText("de ( " + usuarios.size() + " )");
        if (novo && !usuarios.isEmpty()) {
            setData(usuarios.size() - 1);
        } else if (!usuarios.isEmpty()) {
            setData(intPosition);
        }
    }

    @Override
    public void begin() {
        defaultTableModel.addColumn("Cod.");
        defaultTableModel.addColumn("Login");
        defaultTableModel.addColumn("Nivel de Acesso");
        try {
            UserDao dao = new UserDao();
            usuarios = dao.pesquisar();
            for (int i = 0; i < usuarios.size(); i++) {
                Object[] o = {
                    usuarios.get(i).getCodigo(),
                    usuarios.get(i).getLogin(),
                    usuarios.get(i).getNivel()
                };
                defaultTableModel.addRow(o);
            }
            atualizaTable();
            atualizaToolbar(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!usuarios.isEmpty()) {
            setData(0);
        }
    }

    @Override
    public void setActionListener(ActionListener al) {
        btnAdicionar.addActionListener(al);
        btnAdicionar.setActionCommand("Adicionar");
        btnDeletar.addActionListener(al);
        btnDeletar.setActionCommand("Deletar");
        btnAlterar.addActionListener(al);
        btnAlterar.setActionCommand("Alterar");
        btnSalvar.addActionListener(al);
        btnSalvar.setActionCommand("Salvar");
        btnCancelar.addActionListener(al);
        btnCancelar.setActionCommand("Cancelar");
    }

    @Override
    public void performAction(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void performNavigateAction(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}