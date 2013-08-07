package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.ClienteBean;
import model.ConnectionFactory;
import model.UserBean;
import view.FrmBackup;
import view.FrmCadastroCliente;
import view.FrmCadastroProduto;
import view.FrmConsultaClientes;
import view.FrmConsultaProdutos;
import view.FrmMenu;
import view.FrmLogin;
import view.FrmSobre;
import view.FrmUsuario;
import view.FrmCadastroUsuario;
import view.FrmConsultaReserva;
import view.FrmNovaVenda;
import view.FrmReservaMesa;
import view.reports.VisualizaRpt;

/**
 *
 * @author Guilherme
 */
public class PastellySystemController {

    private FrmBackup guiBackup = null;
    private FrmCadastroCliente guiCadCliente = null;
    private FrmCadastroProduto guiCadProduto = null;
    private FrmCadastroUsuario guiCadUsuario = null;
    private FrmConsultaClientes guiConClientes = null;
    private FrmConsultaProdutos guiConProdutos = null;
    private FrmConsultaReserva guiConReserva = null;
    private FrmLogin guiLogin = null;
    private FrmMenu guiMenu = null;
    private FrmNovaVenda guiNovaVenda = null;
    private FrmReservaMesa guiReservaMesa = null;
    private FrmSobre guiSobre = null;
    private FrmUsuario guiUsuario = null;
    private UserBean userbean = null;
    private Logger logger = null;
    private String strLogMessage = null;

    /**
     * Construtor padrão da classe.
     * 
     * Ja inicializa, atribui um ActionListener e exibi o Formulário de Login
     */
    public PastellySystemController() {
        guiLogin = FrmLogin.getInstance();
        guiLogin.setActionListener(new LoginListener());
        guiLogin.setVisible(true);
    }

    /**
     * Classe ouvinte de eventos para o Formulário de Login
     * 
     * @see ActionListener
     */
    class LoginListener implements ActionListener {

        /**
         * Sobrescrita do método herdado da interface ActionListener para aten
         * der as necessidade do Formulário de Login
         * 
         * @param e Objeto ActionEvent para orientar as ações a serem tomadas
         * pelo método
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("Logar".equals(e.getActionCommand())) {
                try {
                    logger = null;
                    strLogMessage = null;
                    UserDao userDao = new UserDao();
                    userDao.setLogin(String.valueOf(
                            guiLogin.txtUsuario.getText()));
                    userDao.setPassword(String.valueOf(
                            guiLogin.txtSenha.getPassword()));
                    if (userDao.Logar()) {
                        userbean = userDao;
                        guiLogin.setVisible(false);
                        guiMenu = FrmMenu.getInstance();
                        guiMenu.setActionListener(new MenuListener());
                        guiMenu.statusbarInit(userbean.getLogin());
                        guiMenu.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(guiLogin, "O usuário "
                                + userDao.getLogin() + " não existe\n ou a se"
                                + "nha digitada é inválida.", "Falha de login.",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    logger = Logger.getLogger(PastellySystemController.class.getName());
                    strLogMessage = ex.getMessage();
                    JOptionPane.showMessageDialog(guiLogin, "Ocorreu algum erro"
                            + " na comunicação\n com o Banco de Dados, envie "
                            + "uma cópia do log do sistema\n para os desenvolve"
                            + "dores.", "Erro na comunicação com o BD",
                            JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    logger = Logger.getLogger(PastellySystemController.class.getName());
                    strLogMessage = ex.getMessage();
                    JOptionPane.showMessageDialog(guiLogin, "Arquivo necessário"
                            + " para a comunicação com o Banco de Dados não en"
                            + "contrado, contate os desenvolvedores.", "Erro na "
                            + "comunicacao com o BD",
                            JOptionPane.ERROR_MESSAGE);
                } finally {
                    if (logger != null) {
                        try {
                            FileHandler fh = new FileHandler("C:/PastellySystem/"
                                    + "Logs/login.xml");
                            logger.addHandler(fh);
                            logger.info(strLogMessage);
                        } catch (IOException ex) {
                            Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SecurityException ex) {
                            Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else if ("Sair".equals(e.getActionCommand())) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(guiLogin, "Um evento inesperado "
                        + "ou desconhecido foi lançado no sistema.", "Contate "
                        + "os desenvolvedores", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Classe ouvinte de eventos para o Formulário de Menu
     * 
     * @see ActionListener
     */
    class MenuListener implements ActionListener {

        /**
         * Sobrescrita do metodo herdado da interface ActionListener para aten
         * der as necessidade do Formulário de Menu
         * 
         * @param e Objeto ActionEvent para orientar as acoes a serem tomadas
         * pelo metodo
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                strLogMessage = null;
                if ("Exibir_Ajuda".equals(e.getActionCommand())) {
                } else if ("Exibir_Backup".equals(e.getActionCommand())) {
                    guiBackup = FrmBackup.getInstance();
                    guiMenu.dpnInicial.add(guiBackup);
                    guiBackup.setActionListener(new BackupListener());
                    guiBackup.setVisible(true);
                } else if ("Exibir_CadastroCliente".equals(e.getActionCommand())) {
                    guiCadCliente = FrmCadastroCliente.getInstance();
                    guiMenu.dpnInicial.remove(guiCadCliente);
                    guiMenu.dpnInicial.add(guiCadCliente);
                    guiCadCliente.setActionListener(new ClientesListener());
                    guiCadCliente.begin();
                    guiCadCliente.setVisible(true);
                } else if ("Exibir_CadastroProduto".equals(e.getActionCommand())) {
                    guiCadProduto = FrmCadastroProduto.getInstance();
                    guiMenu.dpnInicial.add(guiCadProduto);
                    guiCadProduto.setActionListener(new ProdutosListener());
                    guiCadProduto.begin();
                    guiCadProduto.setVisible(true);
                } else if ("Exibir_ConsultaCliente".equals(e.getActionCommand())) {
                    guiConClientes = FrmConsultaClientes.getInstance();
                    guiMenu.dpnInicial.add(guiConClientes);
                    guiConClientes.setActionListener(new ClientesListener());
                    guiConClientes.begin();
                    guiConClientes.setVisible(true);
                } else if ("Exibir_ConsultaProduto".equals(e.getActionCommand())) {
                    guiConProdutos = FrmConsultaProdutos.getInstance();
                    guiMenu.dpnInicial.remove(guiConProdutos);
                    guiMenu.dpnInicial.add(guiConProdutos);
                    guiConProdutos.setActionListener(new ProdutosListener());
                    guiConProdutos.setVisible(true);
                } else if ("Exibir_ConsultaReserva".equals(e.getActionCommand())) {
                    guiConReserva = FrmConsultaReserva.getInstance();
                    guiMenu.dpnInicial.remove(guiConReserva);
                    guiMenu.dpnInicial.add(guiConReserva);
                    guiConReserva.setVisible(true);
                } else if ("Exibir_NovaReserva".equals(e.getActionCommand())) {
                    guiReservaMesa = FrmReservaMesa.getInstance();
                    guiMenu.dpnInicial.remove(guiReservaMesa);
                    guiMenu.dpnInicial.add(guiReservaMesa);
                    guiReservaMesa.setVisible(true);
                } else if ("Exibir_Manual".equals(e.getActionCommand())) {
                } else if ("Exibir_Sobre".equals(e.getActionCommand())) {
                    guiSobre = FrmSobre.getInstance();
                    guiMenu.dpnInicial.add(guiSobre);
                    guiSobre.setVisible(true);
                } else if ("Exibir_NovaVenda".equals(e.getActionCommand())) {
                    guiNovaVenda = FrmNovaVenda.getInstance();
                    guiMenu.dpnInicial.remove(guiNovaVenda);
                    guiMenu.dpnInicial.add(guiNovaVenda);
                    guiNovaVenda.setActionListener(new VendasListener());
                    guiNovaVenda.begin();
                    guiNovaVenda.setVisible(true);
                } else if ("Exibir_UsuarioAtual".equals(e.getActionCommand())) {
                    guiUsuario = FrmUsuario.getInstance();
                    guiMenu.dpnInicial.remove(guiUsuario);
                    guiMenu.dpnInicial.add(guiUsuario);
                    guiUsuario.setActionListener(new UsuariosListener());
                    guiUsuario.setUsuarioAtual(userbean);
                    guiUsuario.setVisible(true);
                } else if ("Exibir_CadastroUsuario".equals(e.getActionCommand())) {
                    if (userbean.getNivel() == 0) {
                        guiCadUsuario = FrmCadastroUsuario.getInstance();
                        guiMenu.dpnInicial.add(guiCadUsuario);
                        guiCadUsuario.setActionListener(new UsuariosListener());
                        guiCadUsuario.begin();
                        guiCadUsuario.setVisible(true);
                    }
                } else if ("Exibir_RelatorioCliente".equals(e.getActionCommand())) {
                    VisualizaRpt.geraRelatorio("RptClientes.jasper", null, "Re"
                            + "latório de Clientes");
                } else if ("Exibir_RelatorioProduto".equals(e.getActionCommand())) {
                    VisualizaRpt.geraRelatorio("RptProdutos.jasper", null, "Re"
                            + "latório de Produtos");
                } else if ("Exibir_RelatorioReserva".equals(e.getActionCommand())) {
                    VisualizaRpt.geraRelatorio("RptReservas.jasper", null, "Re"
                            + "latório de Reservas");
                } else if ("Exibir_RelatorioVenda".equals(e.getActionCommand())) {
                    VisualizaRpt.geraRelatorio("RptVendas.jasper", null, "Rela"
                            + "tório de Vendas");
                } else {
                    JOptionPane.showMessageDialog(guiLogin, "Um evento inespera"
                            + "do ou desconhecido foi lançado no sistema.",
                            "Contate os desenvolvedores",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (IllegalArgumentException ex) {
                logger = Logger.getLogger(PastellySystemController.class.getName());
                strLogMessage = ex.getMessage();
            } catch (Exception ex) {
                logger = Logger.getLogger(PastellySystemController.class.getName());
                strLogMessage = ex.getMessage();
            } finally {
                if (logger != null) {
                    try {
                        FileHandler fh = new FileHandler("C:/PastellySystem/"
                                + "Logs/menu.xml");
                        logger.addHandler(fh);
                        logger.info(strLogMessage);
                    } catch (IOException ex) {
                        Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SecurityException ex) {
                        Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        /**
         * Classe ouvinte de eventos para o Formulário de Backup
         * 
         * @see ActionListener
         */
        class BackupListener implements ActionListener {

            /**
             * Sobrescrita do método herdado da interface ActionListener para aten
             * der as necessidade do Formulário de Backup
             * 
             * @param e Objeto ActionEvent para orientar as ações a serem tomadas
             * pelo método
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Gerar".equals(e.getActionCommand())) {
                    try {
                        strLogMessage = null;
                        Calendar data = Calendar.getInstance();
                        String backup = "" + data.get(Calendar.DAY_OF_MONTH) + "_"
                                + (data.get(Calendar.MONTH) + 1) + "_"
                                + data.get(Calendar.YEAR);
                        String mysqldump = "C:/PastellySystem/Backups/mysqldump";
                        File diretorio = new File("C:/PastellySystem/Backups");
                        if (!diretorio.isDirectory()) {
                            new File("C:/PastellySystem/Backups").mkdir();
                        }
                        Process process = Runtime.getRuntime().exec("cmd /c "
                                + mysqldump + " -u root --password=root -c -e -K "
                                + "--single-transaction --databases matryuska > "
                                + "C:/PastellySystem/Backups/backup(" + backup + ").sql");
                        process.waitFor();
                        JOptionPane.showMessageDialog(guiBackup, "Backup criado em "
                                + diretorio + ", nao esqueca de salva-lo em sua "
                                + "midia externa.", "Backup Gerado",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (InterruptedException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (Exception ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } finally {
                        if (logger != null) {
                            try {
                                FileHandler fh = new FileHandler("C:/PastellySystem/"
                                        + "Logs/backup.xml");
                                logger.addHandler(fh);
                                logger.info(strLogMessage);
                            } catch (IOException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SecurityException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } else if ("Restaurar".equals(e.getActionCommand())) {
                    String strUrl;
                    String mysql = "C:/PastellySystem/Backups/mysql";
                    JFileChooser chooser = new JFileChooser("C:/PastellySystem/"
                            + "Backups");
                    chooser.setDialogTitle("Selecione o arquivo de backup");
                    chooser.showOpenDialog(chooser);
                    File backup;
                    backup = chooser.getSelectedFile();
                    if (backup != null) {
                        strUrl = backup.getPath();
                        Process process;
                        try {
                            strLogMessage = null;
                            process = Runtime.getRuntime().exec("cmd /c" + mysql
                                    + "-u" + ConnectionFactory.getUSER()
                                    + "-p" + ConnectionFactory.getPASS()
                                    + ConnectionFactory.getDATABASE() + "<"
                                    + strUrl);
                            process.waitFor();
                        } catch (IOException ex) {
                            logger = Logger.getLogger(PastellySystemController.class.getName());
                            strLogMessage = ex.getMessage();
                        } catch (InterruptedException ex) {
                            logger = Logger.getLogger(PastellySystemController.class.getName());
                            strLogMessage = ex.getMessage();
                        } catch (Exception ex) {
                            logger = Logger.getLogger(PastellySystemController.class.getName());
                            strLogMessage = ex.getMessage();
                        } finally {
                            if (logger != null) {
                                try {
                                    FileHandler fh = new FileHandler("C:/PastellySystem/"
                                            + "Logs/restore.xml");
                                    logger.addHandler(fh);
                                    logger.info(strLogMessage);
                                } catch (IOException ex) {
                                    Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (SecurityException ex) {
                                    Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(guiLogin, "Um evento inesperado "
                            + "ou desconhecido foi lançado no sistema.", "Contate "
                            + "os desenvolvedores", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        /**
         * Classe ouvinte de eventos para o Formulário de Cadastro de Clientes
         * 
         * @see ActionListener
         */
        class ClientesListener implements ActionListener {

            /**
             * Sobrescrita do método herdado da interface ActionListener para aten
             * der as necessidade do Formulário de Cadastro de Clientes
             * 
             * @param e Objeto ActionEvent para orientar as ações a serem tomadas
             * pelo método
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Adicionar".equals(e.getActionCommand())) {
                    guiCadCliente.booAlteracao = false;
                    guiCadCliente.booInclusao = true;
                    guiCadCliente.limpaCampos();
                    guiCadCliente.habilitaCampos(true);
                    guiCadCliente.setEnabledToolBar(false);
                    guiCadCliente.novoCliente();
                } else if ("Alterar".equals(e.getActionCommand())) {
                    guiCadCliente.booAlteracao = true;
                    guiCadCliente.booInclusao = false;
                    guiCadCliente.habilitaCampos(true);
                    guiCadCliente.setEnabledToolBar(false);
                } else if ("Deletar".equals(e.getActionCommand())) {
                    try {
                        strLogMessage = null;
                        ClienteDao dao = new ClienteDao(guiCadCliente.carregaBean(
                                userbean.getCodigo()));
                        dao.setCodigo(guiCadCliente.clientes.get(
                                guiCadCliente.intPosition).getCodigo());
                        if (JOptionPane.showConfirmDialog(guiCadCliente,
                                dao.toString(), "Confirma exclusão?",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE)
                                == JOptionPane.OK_OPTION) {
                            dao.excluir();
                            guiCadCliente.clientes.remove(guiCadCliente.clientes.get(
                                    guiCadCliente.intPosition));
                            guiCadCliente.atualizaToolbar(false);
                            guiCadCliente.setData(guiCadCliente.intPosition - 2);
                        } else {
                            JOptionPane.showMessageDialog(guiCadCliente, "Exclusão"
                                    + "do cliente " + dao.getNome() + " foi cancela"
                                    + "da pelo usuário.", "Ação cancelada pelo usuá"
                                    + "rio",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (ClassNotFoundException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (SQLException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (Exception ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                        if (strLogMessage.equals("a foreign key constraint fails")) {
                            JOptionPane.showMessageDialog(guiCadCliente, "O cliente"
                                    + "que você tentou excluir nao pode ser excluí"
                                    + "do porque tem vendas realizadas em seu nome.",
                                    "O cliente não pode ser excluído",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } finally {
                        if (logger != null) {
                            try {
                                FileHandler fh = new FileHandler("C:/PastellySystem/"
                                        + "Logs/cliente.xml");
                                logger.addHandler(fh);
                                logger.info(strLogMessage);
                            } catch (IOException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SecurityException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } else if ("Salvar".equals(e.getActionCommand())) {
                    try {
                        strLogMessage = null;
                        ClienteDao dao = new ClienteDao(guiCadCliente.carregaBean(
                                userbean.getCodigo()));
                        if (guiCadCliente.booInclusao) {
                            if (JOptionPane.showConfirmDialog(guiCadCliente,
                                    dao.toString(), "Confirma inclusão?",
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE)
                                    == JOptionPane.OK_OPTION) {
                                guiCadCliente.booInclusao = false;
                                dao.incluir();
                                guiCadCliente.atualizaToolbar(false);
                                guiCadCliente.addCliente(dao);
                            } else {
                                JOptionPane.showMessageDialog(guiCadCliente, "Inclu"
                                        + "são do cliente " + dao.getNome() + " foi "
                                        + "cancelada pelo usuário.", "Ação cancelada"
                                        + "pelo usuário",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else if (guiCadCliente.booAlteracao) {
                            if (JOptionPane.showConfirmDialog(guiCadCliente,
                                    dao.toString(), "Confirma alteração?",
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE)
                                    == JOptionPane.OK_OPTION) {
                                guiCadCliente.booAlteracao = false;
                                dao.alterar();
                            } else {
                                JOptionPane.showMessageDialog(guiCadCliente, "Altera"
                                        + "ção do cliente " + dao.getNome() + " foi "
                                        + "cancelada pelo usuário.", "Ação cancelada"
                                        + "pelo usuário",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            return;
                        }
                        guiCadCliente.habilitaCampos(false);
                        guiCadCliente.atualizaToolbar(true);
                        guiCadCliente.setEnabledToolBar(true);
                        guiCadCliente.booFoneFocus = true;
                    } catch (ClassNotFoundException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (SQLException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (ParseException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (Exception ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } finally {
                        if (logger != null) {
                            try {
                                FileHandler fh = new FileHandler("C:/PastellySystem/"
                                        + "Logs/cliente.xml");
                                logger.addHandler(fh);
                                logger.info(strLogMessage);
                            } catch (IOException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SecurityException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
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
                    guiCadCliente.habilitaCampos(false);
                    guiCadCliente.setEnabledToolBar(true);
                    guiCadCliente.booFoneFocus = true;
                } else if ("Consultar".equals(e.getActionCommand())) {
                    try {
                        strLogMessage = null;
                        ClienteDao clienteDao = new ClienteDao();
                        ArrayList<ClienteBean> clientes = clienteDao.pesquisar(
                                guiConClientes.getQueryItems());
                        guiConClientes.atualizaTable(clientes);
                    } catch (ClassNotFoundException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (SQLException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (ParseException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (Exception ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } finally {
                        if (logger != null) {
                            try {
                                FileHandler fh = new FileHandler("C:/PastellySystem/"
                                        + "Logs/cliente.xml");
                                logger.addHandler(fh);
                                logger.info(strLogMessage);
                            } catch (IOException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SecurityException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(guiLogin, "Um evento inesperado "
                            + "ou desconhecido foi lançado no sistema.", "Contate "
                            + "os desenvolvedores", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        /**
         * Classe ouvinte de eventos para o Formulário de Cadastro de Clientes
         * 
         * @see ActionListener
         */
        class ProdutosListener implements ActionListener {

            /**
             * Sobrescrita do metodo herdado da interface ActionListener para aten
             * der as necessidade do Formulário de Cadastro de Clientes
             * 
             * @param e Objeto ActionEvent para orientar as acoes a serem tomadas
             * pelo metodo
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Adicionar".equals(e.getActionCommand())) {
                    guiCadProduto.booAlteracao = false;
                    guiCadProduto.booInclusao = true;
                    guiCadProduto.limpaCampos();
                    guiCadProduto.habilitaCampos(true);
                    guiCadProduto.setEnabledToolBar(false);
                    guiCadProduto.novoProduto();
                } else if ("Alterar".equals(e.getActionCommand())) {
                    guiCadProduto.booAlteracao = true;
                    guiCadProduto.booInclusao = false;
                    guiCadProduto.habilitaCampos(true);
                    guiCadProduto.setEnabledToolBar(false);
                } else if ("Deletar".equals(e.getActionCommand())) {
                    try {
                        strLogMessage = null;
                        ProdutoDao dao = new ProdutoDao(guiCadProduto.carregaBean());
                        dao.setCodigo(guiCadProduto.produtos.get(
                                guiCadProduto.intPosition).getCodigo());
                        if (JOptionPane.showConfirmDialog(guiCadProduto,
                                dao.toString(), "Confirma exclusão?",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE)
                                == JOptionPane.OK_OPTION) {
                            dao.excluir();
                            guiCadProduto.produtos.remove(guiCadProduto.produtos.get(
                                    guiCadProduto.intPosition));
                            guiCadProduto.atualizaToolbar(false);
                            guiCadProduto.setData(guiCadProduto.intPosition - 2);
                        } else {
                            JOptionPane.showMessageDialog(guiCadCliente, "Exclusão"
                                    + "do cliente " + dao.getDescricao() + " foi "
                                    + "cancelada pelo usuário.", "Ação cancelada "
                                    + "pelo usuário",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (ClassNotFoundException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (SQLException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (Exception ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } finally {
                        if (logger != null) {
                            try {
                                FileHandler fh = new FileHandler("C:/PastellySystem/"
                                        + "Logs/produto.xml");
                                logger.addHandler(fh);
                                logger.info(strLogMessage);
                            } catch (IOException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SecurityException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } else if ("Salvar".equals(e.getActionCommand())) {
                    try {
                        strLogMessage = null;
                        ProdutoDao dao = new ProdutoDao(guiCadProduto.carregaBean());
                        if (guiCadProduto.booInclusao) {
                            if (JOptionPane.showConfirmDialog(guiCadCliente,
                                    dao.toString(), "Confirma inclusão?",
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE)
                                    == JOptionPane.OK_OPTION) {
                                guiCadProduto.booInclusao = false;
                                dao.incluir();
                                guiCadProduto.atualizaToolbar(false);
                                guiCadProduto.addProduto(dao);
                            } else {
                                JOptionPane.showMessageDialog(guiCadCliente, "Inclu"
                                        + "são do cliente " + dao.getDescricao()
                                        + " foi cancelada pelo usuário.", "Ação cance"
                                        + "lada pelo usuário",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else if (guiCadProduto.booAlteracao) {
                            if (JOptionPane.showConfirmDialog(guiCadCliente,
                                    dao.toString(), "Confirma alteração?",
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE)
                                    == JOptionPane.OK_OPTION) {
                                guiCadProduto.booAlteracao = false;
                                dao.alterar();
                            } else {
                                JOptionPane.showMessageDialog(guiCadCliente, "Altera"
                                        + "ção do cliente " + dao.getDescricao()
                                        + " foi cancelada pelo usuário.", "Ação can"
                                        + "celada pelo usuário",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            return;
                        }
                        guiCadProduto.habilitaCampos(false);
                        guiCadProduto.setEnabledToolBar(true);
                    } catch (ClassNotFoundException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (SQLException ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } catch (Exception ex) {
                        logger = Logger.getLogger(PastellySystemController.class.getName());
                        strLogMessage = ex.getMessage();
                    } finally {
                        if (logger != null) {
                            try {
                                FileHandler fh = new FileHandler("C:/PastellySystem/"
                                        + "Logs/produto.xml");
                                logger.addHandler(fh);
                                logger.info(strLogMessage);
                            } catch (IOException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SecurityException ex) {
                                Logger.getLogger(PastellySystemController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    guiCadProduto.setEnabledToolBar(true);
                } else if ("Cancelar".equals(e.getActionCommand())) {
                    if (guiCadProduto.booInclusao) {
                        guiCadProduto.booInclusao = false;
                    } else if (guiCadProduto.booAlteracao) {
                        guiCadProduto.booAlteracao = false;
                    } else {
                        return;
                    }
                    guiCadProduto.setData(guiCadProduto.intPosition);
                    guiCadProduto.habilitaCampos(false);
                    guiCadProduto.setEnabledToolBar(true);
                } else {
                    JOptionPane.showMessageDialog(guiLogin, "Um evento inesperado "
                            + "ou desconhecido foi lançado no sistema.", "Contate "
                            + "os desenvolvedores", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        /**
         * Classe ouvinte de eventos para os Formulários de Usuarios
         * 
         * @see ActionListener
         */
        class VendasListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Gravar".equals(e.getActionCommand())) {
                }
            }
        }

        /**
         * Classe ouvinte de eventos para os Formulários de Usuarios
         * 
         * @see ActionListener
         */
        class UsuariosListener implements ActionListener {

            /**
             * Sobrescrita do metodo herdado da interface ActionListener para aten
             * der as necessidade dos Formulários de Usuario
             * 
             * @param e Objeto ActionEvent para orientar as acoes a serem tomadas
             * pelo metodo
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Alterar_Login".equals(e.getActionCommand())) {
                    String senha = guiUsuario.showJOptionPane();
                    if (senha.equals(userbean.getPassword())) {
                        JOptionPane.showConfirmDialog(guiCadCliente, senha, "OK",
                                JOptionPane.OK_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                    }
                } else if ("Alterar_Senha".equals(e.getActionCommand())) {
                    // TODO Alteracao de senha
                } else if ("Promover_Usuario".equals(e.getActionCommand())) {
                    if (userbean.getNivel() == 1) {
                        // TODO Promocao de usuario
                    } else {
                        JOptionPane.showMessageDialog(guiMenu, "Você não tem permis"
                                + "são para executar essa ação.", "Acesso negado",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(guiLogin, "Um evento inesperado "
                            + "ou desconhecido foi lançado no sistema.", "Contate "
                            + "os desenvolvedores", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}