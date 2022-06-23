package control.descontoCoR;

import model.Venda;

public class DescontoVendedorCargo implements IDesconto {

	@Override
	public double calculaDesconto(Venda v) {
		Double valorFinal = v.getCarro().getValorFinal();
			if (v.getVendedor().getCargo().equals("Gerente")) {
				valorFinal = valorFinal - (valorFinal * 0.02);
		}
		return valorFinal;
	}

	@Override
	public void proximoDesconto(Venda v) {
		if(v.getCarro().getValorFinal() == 0) {
			v.getCarro().setValorFinal(v.getCarro().getValor());
		}
		System.out.println("Desconto Gerente" + v.getCarro().getValorFinal());
		v.getCarro().setValorFinal(calculaDesconto(v));
		DescontoTresMesesAgencia descValor = new DescontoTresMesesAgencia();
		descValor.proximoDesconto(v);
		
	}

}
