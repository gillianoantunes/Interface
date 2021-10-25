package model.services;

//implementa a interface PagamentoOnline que tem 2 metodos
public class PaypalServicos implements PagamentoOnline {

	//Constantes
	private static final double PAGAMENTOONLINE = 0.02;
	private static final double JUROMENSAL = 0.01;
	@Override
	public Double taxaPagamento(Double valor) {
		
		return valor * PAGAMENTOONLINE;
	}

	@Override
	public Double taxaJuros(Double valor, Integer numMeses) {
		
		return valor * numMeses * JUROMENSAL;
	}

	
}
