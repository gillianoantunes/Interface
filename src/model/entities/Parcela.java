package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcela {
	private Date dataVencimento;
	private Double valorParcela;
	
	//para imprimir data no formato abaixo no toString
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Parcela(){
		
	}


	public Parcela(Date dataVencimento, Double valorParcela) {
		this.dataVencimento = dataVencimento;
		this.valorParcela = valorParcela;
	}


	public Date getDataVencimento() {
		return dataVencimento;
	}


	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}


	public Double getValorParcela() {
		return valorParcela;
	}


	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}


	@Override
	public String toString() {
		return sdf.format(dataVencimento) + " - " + String.format("%.2f", valorParcela);
	}
	
	
	
}
