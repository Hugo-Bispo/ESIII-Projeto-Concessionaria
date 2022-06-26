package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "CPF")
	@NotNull
	private String cpf;

	@Column(name = "nomeCliente", length = 50)
	@NotNull
	private String nome;

	@Column(name = "telefoneCliente", length = 11)
	@NotNull
	private String telefone;

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_endereco")
	@NotNull
	private ClienteEndereco endereco;

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ClienteEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(ClienteEndereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", endereco="
				+ endereco + "]";
	}

	

}
