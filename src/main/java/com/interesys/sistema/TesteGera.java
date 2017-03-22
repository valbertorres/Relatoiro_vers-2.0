package com.interesys.sistema;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.intersys.relatorio.fabricaconexao.FabricaDeConexao;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class TesteGera {
	public static void main(String[] args) {
		try {
			
			Connection connection = FabricaDeConexao.getInstancia().getConnxao();
			ProdutoFactory.setOrderBy("order by pdcodgru");
			ClientePO.setChave(345640);
			List<ProdutoTO> produtoTO = ProdutoFactory.listaProduto();
			JRDataSource jre = new JRBeanCollectionDataSource(produtoTO);
			Map<String, Object> parameters = new HashMap<>();
			InputStream relatorioSource = GerarRelatorio.class.getResourceAsStream("sge.jrxml");
			ByteArrayOutputStream relatorioOutputCompiled = new ByteArrayOutputStream();
			JasperCompileManager.compileReportToStream(relatorioSource, relatorioOutputCompiled);
			byte[] compiledReportData = relatorioOutputCompiled.toByteArray();
			relatorioOutputCompiled.close();

			JasperPrint jasperPrint = JasperFillManager.fillReport(new ByteArrayInputStream(compiledReportData),
					parameters, jre);
			JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
			jasperViewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
			jasperViewer.setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
