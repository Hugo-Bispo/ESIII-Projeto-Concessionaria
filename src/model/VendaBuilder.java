package model;

import java.time.LocalDate;

public class VendaBuilder {
	Venda venda;
	Carro carro;
	Vendedor vendedor;

	public VendaBuilder() {
		this.venda = new Venda();
		this.carro = new Carro();
		this.vendedor = new Vendedor();
	}

	public static VendaBuilder builder() {
		return new VendaBuilder();
	}

	public VendaBuilder addPlaca(String placa) {
		this.carro.setPlaca(placa);
		return this;
	}

	public VendaBuilder addDataVenda(LocalDate dataVenda) {
		this.venda.setData_venda(dataVenda);
		return this;
	}

	public VendaBuilder addCarroInformacao(String modelo, String versao, String marca, int Ano) {
		this.carro.setModelo(modelo);
		this.carro.setVersao(versao);
		this.carro.setMarca(marca);
		this.carro.setAno(Ano);
		return this;
	}

	public VendaBuilder addValor(Double valor) {
		this.carro.setValor(valor);
		return this;
	}

	public VendaBuilder addValorFinal(Double valorFinal) {
		this.carro.setValorFinal(valorFinal);
		return this;
	}

	public VendaBuilder addSituacao(String situacao) {
		this.carro.setSituacao(situacao);
		return this;
	}

	public VendaBuilder addFuncional(int funcional) {
		this.vendedor.setFuncional(funcional);
		return this;
	}

	public VendaBuilder addNome(String nome) {
		this.vendedor.setNome(nome);
		return this;
	}

	public VendaBuilder addTelefone(String telefone) {
		this.vendedor.setTelefone(telefone);
		return this;
	}

	public VendaBuilder addCargo(String cargo) {
		this.vendedor.setCargo(cargo);
		return this;
	}

	public Venda get() {
		this.venda.setCarro(carro);
		this.venda.setVendedor(vendedor);
		return this.venda;
	}

}
