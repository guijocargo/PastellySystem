package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.ConnectionFactory;
import model.UserBean;
import view.FrmBackup;
import view.FrmCadastroCliente;
import view.FrmCadastroProduto;
import view.FrmConsultaClientes;
import view.FrmConsultaProdutos;
import view.FrmMenu;
import view.FrmLogin;
import view.FrmNovaVenda;
import view.FrmSobre;

/**
 *
 * @author GuiJoCarGo
 */
public class PastellySystemController {

    private FrmBackup guiBackup = null;
    private FrmCadastroCliente guiCadCliente = null;
    private FrmCadastroProduto guiCadProduto = null;
    private FrmConsultaClientes guiConClientes = null;
    private FrmConsultaProdutos guiConProdutos = null;
    private FrmLogin guiLogin = null;
    private FrmMenu guiMenu = null;
    private FrmNovaVenda guiNovaVenda = null;
    private FrmSobre guiSobre = null;
    private UserBean userbean = null;

    public PastellySystemController() {
        guiLogin = FrmLogin.getInstance();
        guiLogin.setActionListener(new LoginListener());
        guiLogin.setVisible(true);
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("Logar".equals(e.getActionCommand())) {
                try {
                    UserDao userDao = new UserDao();
                    userDao.setLogin(String.valueOf(
                            guiLogin.txtUsuario.getText()));
                    userDao.setPassword(String.valueOf(
                            guiLogin.txtSenha.getPassword()));
                    if (userDao.Login()) {
                        guiLogin.setVisible(false);
                        guiMenu = new FrmMenu();
                        guiMenu.setActionListener(new MenuListener());
                        guiMenu.setVisible(true);
                        userbean = userDao;
                    } else {
                        JOptionPane.showMessageDialog(guiMenu, "O usuário "
                                + userDao.getLogin() + " não existe ou a senha "
                                + "digitada é inválida.", "Falha de login.",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("Sair".equals(e.getActionCommand())) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(guiLogin, "Um evento inesperado "
                        + "foi lançado no sistema.", "Contate os desenvolvedo"
                        + "res", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("Exibir_Ajuda".equals(e.getActionCommand())) {
            } else if ("Exibir_Backup".equals(e.getActionCommand())) {
                guiBackup = FrmBackup.getInstance();
                guiBackup.setActionListener(new BackupListener());
                guiBackup.setVisible(true);
            } else if ("Exibir_Calculadora".equals(e.getActionCommand())) {
            } else if ("Exibir_CadastroCliente".equals(e.getActionCommand())) {
                guiCadCliente = FrmCadastroCliente.getInstance();
                guiCadCliente.setActionListener(new CadClientesListener());
                guiCadCliente.setVisible(true);
            } else if ("Exibir_CadastroProduto".equals(e.getActionCommand())) {
                guiCadProduto = FrmCadastroProduto.getInstance();
                guiCadProduto.setVisible(true);
            } else if ("Exibir_CadastroReserva".equals(e.getActionCommand())) {
            } else if ("Exibir_ConsultaCliente".equals(e.getActionCommand())) {
                guiConClientes = FrmConsultaClientes.getInstance();
                guiConClientes.setVisible(true);
            } else if ("Exibir_ConsultaProduto".equals(e.getActionCommand())) {
                guiConProdutos = FrmConsultaProdutos.getInstance();
                guiConProdutos.setVisible(true);
            } else if ("Exibir_ConsultaReserva".equals(e.getActionCommand())) {
            } else if ("Exibir_Manual".equals(e.getActionCommand())) {
            } else if ("Exibir_Sobre".equals(e.getActionCommand())) {
                guiSobre = FrmSobre.getInstance();
                guiSobre.setVisible(true);
            } else if ("Exibir_NovaReserva".equals(e.getActionCommand())) {
            } else if ("Exibir_NovaVenda".equals(e.getActionCommand())) {
                guiNovaVenda = FrmNovaVenda.getInstance();
                guiNovaVenda.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(guiLogin, "Um evento inesperado "
                        + "foi lançado no sistema.", "Contate os desenvolvedo"
                        + "res", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class BackupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("Gerar".equals(e.getActionCommand())) {
                File dir = new File("C:/Backup");
                if (!dir.isDirectory()) {
                    new File("C:/Backup").mkdir();
                }
                try {
                    Process proc = Runtime.getRuntime().exec("cmd /c mysqldump -u"
                            + ConnectionFactory.getUSER() + "--password="
                            + ConnectionFactory.getPASS() + "-c -e -K "
                            + "--single-transaction --databases "
                            + ConnectionFactory.getDATABASE() + " > "
                            + dir.getPath() + "/backup(" + new Date() + ").sql");
                    try {
                        proc.waitFor();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("Restaurar".equals(e.getActionCommand())) {
                String url;
                JFileChooser chooser = new JFileChooser("C:\\Backup");
                chooser.setDialogTitle("Selecione o arquivo de backup");
                chooser.showOpenDialog(chooser);
                File backup;
                backup = chooser.getSelectedFile();
                if (backup != null) {
                    url = backup.getPath();
                    Process proc;
                    try {
                        proc = Runtime.getRuntime().exec("cmd /c mysql -u"
                                + ConnectionFactory.getUSER() + "-p"
                                + ConnectionFactory.getPASS()
                                + ConnectionFactory.getDATABASE() + "<" + url);
                        proc.waitFor();
                    } catch (IOException ex) {
                        Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ;
                }
            } else {
                JOptionPane.showMessageDialog(guiLogin, "Um evento inesperado "
                        + "foi lançado no sistema.", "Contate os desenvolvedo"
                        + "res", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class CadClientesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("Adicionar".equals(e.getActionCommand())) {
                guiCadCliente.booAlteracao = false;
                guiCadCliente.booInclusao = true;
                guiCadCliente.habilitaCampos(true);
                guiCadCliente.limpaCampos(true);
                guiCadCliente.setEnabledToolBar(false);
                guiCadCliente.resize(false);
            } else if ("Alterar".equals(e.getActionCommand())) {
                guiCadCliente.booAlteracao = true;
                guiCadCliente.booInclusao = false;
                guiCadCliente.habilitaCampos(true);
                guiCadCliente.setEnabledToolBar(false);
                guiCadCliente.resize(false);
            } else if ("Deletar".equals(e.getActionCommand())) {
                try {
                    ClienteDao dao = new ClienteDao();
                    dao.setCodigo(guiCadCliente.clientes.get(
                            guiCadCliente.intPosition).getCodigo());
                    dao.excluir();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("Salvar".equals(e.getActionCommand())) {
                try {
                    ClienteDao dao = new ClienteDao(guiCadCliente.carregaBean(
                            userbean.getCodigo()));
                    if (guiCadCliente.booInclusao) {
                        guiCadCliente.booInclusao = false;
                        dao.incluir();
                    } else if (guiCadCliente.booAlteracao) {
                        guiCadCliente.booAlteracao = false;
                        dao.alterar();
                    } else {
                        return;
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
                guiCadCliente.setEnabledToolBar(true);
            } else if ("Cancelar".equals(e.getActionCommand())) {
                if (guiCadCliente.booInclusao) {
                    guiCadCliente.booInclusao = false;
                } else if (guiCadCliente.booAlteracao) {
                    guiCadCliente.booAlteracao = false;
                } else {
                    return;
                }
                guiCadCliente.setData(guiCadCliente.intPosition);
                guiCadCliente.setEnabledToolBar(true);
            } else {
                JOptionPane.showMessageDialog(guiLogin, "Um evento inesperado "
                        + "foi lançado no sistema.", "Contate os desenvolvedo"
                        + "res", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
