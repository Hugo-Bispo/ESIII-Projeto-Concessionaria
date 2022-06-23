package control.descontoCoR;

import java.time.LocalDate;

import model.Venda;

public class DescontoUmAnoAgencia implements IDesconto {
	
	public double calculaDesconto(Venda v) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataCadastro = v.getCarro().getData_cadastro().plusYears(1);
		Double valorFinal = v.getCarro().getValorFinal();
		
		if (dataAtual.isAfter(dataCadastro) && v.getCarro().getValor() < 300000 ) {
			valorFinal = valorFinal - (valorFinal * 0.03);
	}
	return valorFinal;
	}

	@Override
	public void proximoDesconto(Venda v) {
		if(v.getCarro().getValorFinal() == 0) {
			v.getCarro().setValorFinal(v.getCarro().getValor());
		}
		System.out.println("Um Ano" + v.getCarro().getValorFinal());
		v.getCarro().setValorFinal(calculaDesconto(v));
	}
}
