package com.intersys.sistema;

public class TesteAbrirRelatorio {
	public static void main(String[] args) {
		GerarRelatorio gerarRelatorio = new GerarRelatorio();
		gerarRelatorio.setChave(345689);
		gerarRelatorio.setAmbiente(false);
		gerarRelatorio.setGrupo(false);
		gerarRelatorio.setOrderBy("");
		gerarRelatorio.setSem(false);
		gerarRelatorio.setEvento("");
		
		
		GerarRelatorio2 gerarRelatorio2 = new GerarRelatorio2();
		gerarRelatorio2.setImprimir_via(true);
		gerarRelatorio2.setGerarRelatorio(gerarRelatorio);
		
			gerarRelatorio2.gerarRelatorio2();
		
		System.out.println("gerou");
	}

}
