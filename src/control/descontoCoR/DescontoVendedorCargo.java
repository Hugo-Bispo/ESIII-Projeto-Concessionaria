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
		v.getCarro().setValorFinal(calculaDesconto(v));
		DescontoTresMesesAgencia descValor = new DescontoTresMesesAgencia();
		descValor.proximoDesconto(v);
		
	}

}
