package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "carroCaracteristicas")
public class CarroCaracteristicas extends Carro{
	
	@Column(name = "quilometragem")
	private Double quilometragem;

	@Column(name = "cilindrada")
	private Double cilindrada;

	@Column(name = "combustivel")
	private String combustivel;

	@Column(name = "cambio")
	private String cambio;

	@Column(name = "cor")
	private String cor;

	public Double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Double getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(Double cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "CarroCaracteristicas [quilometragem=" + quilometragem + ", cilindrada=" + cilindrada + ", combustivel="
				+ combustivel + ", cambio=" + cambio + ", cor=" + cor + "]";
	}
	
}
