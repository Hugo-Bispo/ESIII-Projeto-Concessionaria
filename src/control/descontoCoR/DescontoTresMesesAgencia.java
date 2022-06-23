package control.descontoCoR;

import java.time.LocalDate;

import model.Venda;

public class DescontoTresMesesAgencia implements IDesconto {
	
	@Override
	public double calculaDesconto(Venda v) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataCadastro = v.getCarro().getData_cadastro().plusMonths(3);
		Double valorFinal = v.getCarro().getValorFinal();
		
		if (dataAtual.isAfter(dataCadastro) && v.getCarro().getValor() < 100000 ) {
			valorFinal = valorFinal - (valorFinal * 0.02);
	}
	return valorFinal;
	}

	@Override
	public void proximoDesconto(Venda v) {
		if(v.getCarro().getValorFinal() == 0) {
			v.getCarro().setValorFinal(v.getCarro().getValor());
		}
		System.out.println("Três Meses" + v.getCarro().getValorFinal());
		v.getCarro().setValorFinal(calculaDesconto(v));
		
		DescontoSeisMesesAgencia descValor = new DescontoSeisMesesAgencia();
		descValor.proximoDesconto(v);
		
	}

}
