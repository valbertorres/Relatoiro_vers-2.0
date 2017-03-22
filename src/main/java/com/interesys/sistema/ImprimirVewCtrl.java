package com.interesys.sistema;

import javax.swing.JRadioButton;

public class ImprimirVewCtrl {

	private static ImprimirVewCtrl instacia;

	public static ImprimirVewCtrl getInstancia() {
		if (instacia == null) {
			instacia = new ImprimirVewCtrl();
		}
		return instacia;
	}

	private ImprimirVew imprimirVew;
	
	

	public void inicializar() {

	}

	private void inicializarListene() {
		
	}

	public ImprimirVew getImprimirVew() {
		return imprimirVew;
	}

	public void setImprimirVew(ImprimirVew imprimirVew) {
		this.imprimirVew = imprimirVew;
	}

}
