package control.descontoCoR;

import model.Venda;

public interface IDesconto {
	public double calculaDesconto(Venda v);
	public void proximoDesconto(Venda v);
}
