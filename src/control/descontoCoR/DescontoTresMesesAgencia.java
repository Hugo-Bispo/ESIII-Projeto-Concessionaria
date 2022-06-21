package control.descontoCoR;

import java.time.LocalDate;

import model.Venda;

public class DescontoTresMesesAgencia implements IDesconto {
	
	@Override
	public double calculaDesconto(Venda v) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataCadastro = v.getData_venda().plusMonths(3);
		Double valorFinal = v.getCarro().getValorFinal();
		
		if (dataCadastro.isAfter(dataAtual) && v.getCarro().getValor() < 100000 ) {
			valorFinal = valorFinal - (valorFinal * 0.02);
	}
	return valorFinal;
	}

	@Override
	public void proximoDesconto(Venda v) {
		v.getCarro().setValorFinal(calculaDesconto(v));
		DescontoSeisMesesAgencia descValor = new DescontoSeisMesesAgencia();
		descValor.proximoDesconto(v);
		
	}

}
