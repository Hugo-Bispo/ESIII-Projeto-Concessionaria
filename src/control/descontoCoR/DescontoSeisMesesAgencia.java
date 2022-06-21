package control.descontoCoR;

import java.time.LocalDate;

import model.Venda;

public class DescontoSeisMesesAgencia implements IDesconto {
	
	public double calculaDesconto(Venda v) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataCadastro = v.getData_venda().plusMonths(6);
		Double valorFinal = v.getCarro().getValorFinal();
		
		if (dataCadastro.isAfter(dataAtual) && v.getCarro().getValor() < 200000 ) {
			valorFinal = valorFinal - (valorFinal * 0.01);
	}
	return valorFinal;
	}

	@Override
	public void proximoDesconto(Venda v) {
		v.getCarro().setValorFinal(calculaDesconto(v));
		DescontoUmAnoAgencia descValor = new DescontoUmAnoAgencia();
		descValor.proximoDesconto(v);
		
	}
}
