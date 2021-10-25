package model.services;

public interface PagamentoOnline {

	public Double taxaPagamento(Double valor);// metodo que calcula valor com a taxa de 2%
	public Double taxaJuros(Double valor, Integer numMeses); //calcula os juros por meses
}
