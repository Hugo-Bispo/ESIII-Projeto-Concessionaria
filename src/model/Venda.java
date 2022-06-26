package model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "venda")
public class Venda{

	@Id
	@OneToOne
	@JoinColumn(name = "placa")
	@NotNull
	private Carro carro;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "funcional")
	@NotNull
	private Vendedor vendedor;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "cliente")
	@NotNull
	private Cliente cliente;
	
	
	@Id
	@Column(name="data_venda")
	@NotNull
	private LocalDate data_venda;


	public Carro getCarro() {
		return carro;
	}


	public void setCarro(Carro carro) {
		this.carro = carro;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public LocalDate getData_venda() {
		return data_venda;
	}


	public void setData_venda(LocalDate data_venda) {
		this.data_venda = data_venda;
	}


	@Override
	public String toString() {
		return "Venda [carro=" + carro + ", vendedor=" + vendedor + ", cliente=" + cliente + ", data_venda="
				+ data_venda + "]";
	}

	
}
