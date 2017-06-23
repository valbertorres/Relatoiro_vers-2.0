package com.intersys.sistema;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import com.intersys.relatorio.fabricaconexao.FabricaDeConexao;

public class SelectImagem {
public static void main(String[] args) {
try {
		
		Connection connection = FabricaDeConexao.getInstancia().getConnxao();
		byte[] fileBytes;
		String query;
		int id = 1215;
		
		query = "select P1R_ARQUIVO_PDF from CADP01_REQUISICOES where p1r_id=148";
		Statement state = connection.createStatement();
		ResultSet rs = state.executeQuery(query);
		if (rs.next()) {
			fileBytes = rs.getBytes("P1R_ARQUIVO_PDF");
			OutputStream targetFile = new FileOutputStream("c://" + "teste1235" + ".pdf");
			targetFile.write(fileBytes);
			targetFile.close();
		}
		System.out.println("baixou"+"    c://" + "teste142599" + ".pdf");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}
}