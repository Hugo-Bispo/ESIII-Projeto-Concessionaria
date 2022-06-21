package control.descontoCoR;

import java.time.LocalDate;

import model.Venda;

public class DescontoUmAnoAgencia implements IDesconto {
	
	public double calculaDesconto(Venda v) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataCadastro = v.getData_venda().plusYears(1);
		Double valorFinal = v.getCarro().getValorFinal();
		
		if (dataCadastro.isAfter(dataAtual) && v.getCarro().getValor() < 300000 ) {
			valorFinal = valorFinal - (valorFinal * 0.03);
	}
	return valorFinal;
	}

	@Override
	public void proximoDesconto(Venda v) {
		v.getCarro().setValorFinal(calculaDesconto(v));
	}
}
