/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.reports;

import java.sql.Connection;
import java.util.Map;
import model.ConnectionFactory;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fp0520111066
 */
public class VisualizaRpt {

    /**
     * Gera relatório a partir do seu arquivo "compilado"(*.jasper)
     * 
     * @param arquivoRpt Nome do arquivo iReport compilado (ex.: arq.jasper)
     * que irá ser usado para gerar a visualização do relatório
     * @param parameter Parâmetro(s) para preencger o SQL da consulta que gera o
     * relatório (caso exisam).
     * @param titulo Título qu aparecerá na borda da janela do relatório.
     * @throws Exception Lança uma exceção genérica, para evitar tratar
     * exceções aqui.
     */
    public static void geraRelatorio(String arquivoRpt, Map parameter,
            String titulo) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        JasperPrint jp = JasperFillManager.fillReport("src/view/reports/"
                + arquivoRpt, parameter, conn);
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.setTitle(titulo);
        viewer.setVisible(true);
    }
}
