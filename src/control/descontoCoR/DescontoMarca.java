package control.descontoCoR;

import model.Venda;

public class DescontoMarca implements IDesconto {

	private String marcasCarrosBaixaProcura[] = { "Chery", "Geely", "Chana", "Effa", "JAC", "Lifan", "Shineray" };

	@Override
	public double calculaDesconto(Venda v) {
		Double valorFinal = v.getCarro().getValorFinal();
		for (String marca : marcasCarrosBaixaProcura) {
			if (v.getCarro().getMarca().equals(marca)) {
				valorFinal = valorFinal - (valorFinal * 0.03);
			}
		}
		return valorFinal;
	}

	@Override
	public void proximoDesconto(Venda v) {
		v.getCarro().setValorFinal(calculaDesconto(v));
		DescontoVendedorCargo descValor = new DescontoVendedorCargo();
		descValor.proximoDesconto(v);
	}

}
