package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcela;

public class ServicoContrato {
	// os serviços não se conectam por instancias usando o new para não ter
	// acoplamento alto
	// usamos inversao de controle quem controla a instancia é outro lugar tipo a
	// classe Program
	private PagamentoOnline pagamentoOnline;// interface atributo

	// cria um construtor recebendo a interface
	public ServicoContrato(PagamentoOnline pagamentoOnline) {
		this.pagamentoOnline = pagamentoOnline;
	}

	public void ProcessarContrato(Contrato contrato, int numMeses) {
		Double parcelabasica = contrato.getValorTotal() / numMeses;
		for (int i = 1; i <= numMeses; i++) {
			// apliquei a taxa de juros
			Double taxaAtualizada = parcelabasica + pagamentoOnline.taxaJuros(parcelabasica, i);
			// apliquei a taxa de pagamento em cima da taxaatualizada
			Double taxaTotal = taxaAtualizada + pagamentoOnline.taxaPagamento(taxaAtualizada);
			// chama o método adiciona mês e adiciona i meses
			Date dataVencimento = adicionaMes(contrato.getDataContrato(), i);

			// adicionar na lista instanciando a classe Parcela
			// adicionou na lista um novo objeto
			contrato.getParcelas().add(new Parcela(dataVencimento, taxaTotal));

		}

	}

	// funcao para adicionar meses a uma data
	// usamos o calendar
	public Date adicionaMes(Date data, int n) {
		// instancia o calendar
		Calendar calendar = Calendar.getInstance();
		// seta a data do calendar para a data que quero
		calendar.setTime(data);
		// adiciono dias,meses,ano
		calendar.add(calendar.MONTH, n);
		// retorna a fata dele alterada
		return calendar.getTime();

	}
}
