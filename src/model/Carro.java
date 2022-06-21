package model;

import java.time.LocalDate;

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

	@Column(name = "valor")
	@NotNull
	private double valor;
	
	@Column(name = "valorFinal")
	@NotNull
	private double valorFinal;

	@Column(name = "situacao", length = 1)
	@NotNull
	private String situacao;
	
	@Column(name="data_cadastro")
	@NotNull
	private LocalDate data_cadastro;

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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public LocalDate getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(LocalDate data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", modelo=" + modelo + ", versao=" + versao + ", marca=" + marca + ", ano="
				+ ano + ", valor=" + valor + ", valorFinal=" + valorFinal + ", situacao=" + situacao
				+ ", data_cadastro=" + data_cadastro + "]";
	}
	
	
}
