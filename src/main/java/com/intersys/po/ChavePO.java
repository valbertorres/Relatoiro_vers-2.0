package com.intersys.po;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intersys.relatorio.fabricaconexao.FabricaDeConexao;
import com.intersys.to.ChaveTO;

public class ChavePO {

	private static ChavePO instancia;

	public static synchronized ChavePO getInstancia() {
		if (instancia == null) {
			instancia = new ChavePO();
		}
		return instancia;
	}

	private ChaveTO chaveTO;

	public ChaveTO chave() {
		String sql = "select CASE WHEN P1TIPO=0 THEN 'Orcamento' else TPNOME end as tipo, p1chave "
				+ "from cadp01,cadtipped where p1chave=? and p1tipo=tpcodigo";

		try (Connection connection = FabricaDeConexao.getInstancia().getConnxao()) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setLong(1, this.chaveTO.getChave());
				try (ResultSet resultSet = statement.executeQuery()) {

					while (resultSet.next()) {
						chaveTO = transferenciaResultSet(resultSet);
						return chaveTO;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static ChaveTO transferenciaResultSet(ResultSet resultSet) throws SQLException {
		ChaveTO chaveTO = new ChaveTO();

		chaveTO.setChave(resultSet.getLong("p1chave"));
		chaveTO.setTipoVenda(resultSet.getString("tipo"));

		return chaveTO;
	}

	public ChaveTO getChaveTO() {
		return chaveTO;
	}

	public void setChaveTO(ChaveTO chaveTO) {
		this.chaveTO = chaveTO;
	}

}
