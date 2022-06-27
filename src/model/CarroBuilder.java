package model;

import java.time.LocalDate;

public class CarroBuilder {
	private Carro carro;
	private CarroCaracteristicas caracteristicas;

	public CarroBuilder() {
		this.carro = new Carro();
		this.caracteristicas = new CarroCaracteristicas();
	}

	public static CarroBuilder builder() {
		return new CarroBuilder();
	}

	public CarroBuilder addPlaca(String placa) {
		this.carro.setPlaca(placa);
		return this;
	}

	public CarroBuilder addCarroInformacao(String modelo, String versao, String marca, int ano) {
		this.carro.setModelo(modelo);
		this.carro.setVersao(versao);
		this.carro.setMarca(marca);
		this.carro.setAno(ano);
		return this;
	}

	public CarroBuilder addValor(Double valor) {
		this.carro.setValor(valor);
		return this;
	}

	public CarroBuilder addValorFinal(Double valorFinal) {
		this.carro.setValorFinal(valorFinal);
		return this;
	}

	public CarroBuilder addSituacao(String situacao) {
		this.carro.setSituacao(situacao);
		return this;
	}

	public CarroBuilder addDataCadastro(LocalDate data_cadastro) {
		this.carro.setData_cadastro(data_cadastro);
		return this;
	}

	public CarroBuilder addQuilometragem(Double quilometragem) {
		this.caracteristicas.setQuilometragem(quilometragem);
		return this;
	}

	public CarroBuilder addCaracteristicas(Double cilindrada, String combusitivel, String cambio, String cor) {
		this.caracteristicas.setCilindrada(cilindrada);
		this.caracteristicas.setCombustivel(combusitivel);
		this.caracteristicas.setCambio(cambio);
		this.caracteristicas.setCor(cor);
		return this;
	}

	public Carro get() {
		this.carro.setCarroCaracteristicas(caracteristicas);
		return this.carro;
	}

}
