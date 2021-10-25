package application;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.PagamentoOnline;
import model.services.PaypalServicos;
import model.services.ServicoContrato;

public class Program {

	public static void main(String[] args) throws ParseException {
		// Locale é sempre antes do Scanner
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados do contrato:");
		System.out.println("Número do contrato:");
		Integer numero = sc.nextInt();
		sc.nextLine();
		System.out.println("Data do contrato:(dd/mm/yyyy)");
		Date data = sdf.parse(sc.nextLine());
		System.out.println("Valor do contrato:");
		Double valorTotal = sc.nextDouble();

		Contrato contrato = new Contrato(numero, data, valorTotal);

		System.out.println("Entre com o número de parcelas");
		int n = sc.nextInt();
		
		// instanciar o serviço agora e injetar o PaupalServicos
		ServicoContrato servicocontrato = new ServicoContrato(new PaypalServicos());
		//chama o método Processar contrato
		servicocontrato.ProcessarContrato(contrato, n);
		
		//imprimir o resultado com a lista de parcelas
		System.out.println("Parcelas:");
		
		//para cada parcela  parce na minha lista de parcelas do contrato
		for(Parcela parce : contrato.getParcelas()){
			// para imprimir bonito fazer o tostring na classe Parcelas
			System.out.println(parce);
			
		}
		
		
		
		sc.close();
	}

}
