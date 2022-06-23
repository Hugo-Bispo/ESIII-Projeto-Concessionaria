package control.descontoCoR;

import java.time.LocalDate;

import model.Venda;

public class DescontoSeisMesesAgencia implements IDesconto {
	
	public double calculaDesconto(Venda v) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataCadastro = v.getCarro().getData_cadastro().plusMonths(6);
		Double valorFinal = v.getCarro().getValorFinal();
		
		if (dataAtual.isAfter(dataCadastro) && v.getCarro().getValor() < 200000 ) {
			valorFinal = valorFinal - (valorFinal * 0.01);
	}
	return valorFinal;
	}

	@Override
	public void proximoDesconto(Venda v) {
		if(v.getCarro().getValorFinal() == 0) {
			v.getCarro().setValorFinal(v.getCarro().getValor());
		}
		System.out.println("Seis Meses" + v.getCarro().getValorFinal());
		v.getCarro().setValorFinal(calculaDesconto(v));
		DescontoUmAnoAgencia descValor = new DescontoUmAnoAgencia();
		descValor.proximoDesconto(v);
		
	}
}
