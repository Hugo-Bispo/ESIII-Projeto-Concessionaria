package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "carro")
public class Carro {

	@Id
	@Column(name = "placa", length = 7)
	@NotNull
	private String placa;

	@Column(name = "modelo", length = 20)
	@NotNull
	private String modelo;

	@Column(name = "versao", length = 20)
	@NotNull
	private String versao;

	@Column(name = "marca", length = 20)
	@NotNull
	private String marca;

	@Column(name = "ano")
	@NotNull
	private int ano;

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

	@Column(name = "valor")
	@NotNull
	private double valor;

	@Column(name = "situacao", length = 1)
	@NotNull
	private String situacao;

	@Column(name = "agencia", length = 20)
	private String agencia;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", modelo=" + modelo + ", versao=" + versao + ", marca=" + marca + ", ano="
				+ ano + ", quilometragem=" + quilometragem + ", cilindrada=" + cilindrada + ", combustivel="
				+ combustivel + ", cambio=" + cambio + ", cor=" + cor + ", valor=" + valor + ", situacao=" + situacao
				+ ", agencia=" + agencia + "]";
	}
	
	
}
